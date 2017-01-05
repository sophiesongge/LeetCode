import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum{
	
	public static void main(String[] args){
		//Test Setup
		TwoSum test = new TwoSum();
		int[] nums = new int[]{11, 2, 3, 7, 15, 12, 9, 2};
		int target = 10;
		
		//Test for HashTable Method
		long startTime1=System.nanoTime();
		int[] res1 = test.twoSum1(nums, target);
		long endTime1=System.nanoTime();
		
		String timer1 = String.valueOf(endTime1 - startTime1);
		System.out.printf("The Execution Time for HashTable Method: %s ns \n", timer1);
		System.out.printf("The Execution Results for HashTable Method: %s, %s \n\n", res1[0], res1[1]);
		
		//Test for Two Pointer Method
		long startTime2=System.nanoTime();
		int[] res2 = test.twoSum1(nums, target);
		long endTime2=System.nanoTime();
		
		String timer2 = String.valueOf(endTime2 - startTime2);
		System.out.printf("The Execution Time for Two Pointers Method: %s ns \n", timer2);
		System.out.printf("The Execution Results for HashTable Method: %s, %s \n\n", res2[0], res2[1]);
	}
	
	//HashTable Method
	 public int[] twoSum1(int[] nums, int target) {
		 int[] res = new int[2];
		 if(nums == null || nums.length == 0){
			 return res;
		 }
		 
		 HashMap<Integer, Integer> helper = new HashMap();
		 
		 for(int i=0; i<nums.length; i++){
			 if(helper.containsKey(target - nums[i])){
				 res[0] = helper.get(target - nums[i]);
				 res[1] = i;
				 return res;
			 }else{
				 helper.put(nums[i], i);
			 }
		 }
		 return res;
	 }
	 
	 //Two Pointers Method
	 public int[] twoSum2(int[] nums, int target){
		 int[] res = new int[2];
		 if(nums==null || nums.length==0){
			 return res;
		 }
		 
		 HashMap<Integer, Integer> helper = new HashMap();
		 for(int i = 0; i<nums.length; i++){
			 helper.put(i, nums[i]);
		 }
		 
		 Arrays.sort(nums);
		 
		 int start = 0;
		 int end = nums.length - 1;
		 
		 while(start < end){
			 int sum = nums[start] + nums[end];
			 if(target > sum){
				 start++;
			 }else if(target < sum){
				 end--;
			 }else{
				 ArrayList<Integer> temps = new ArrayList();
				 for(Integer index : helper.keySet()){
					 if(helper.get(index) == nums[start] || helper.get(index) == nums[end]){
						 temps.add(index);
					 }
				 }
				 res[0] = temps.get(0);
				 res[1] = temps.get(1);
				 return res;
			 }
		 }
		 
		 return res;
	 }
	
}