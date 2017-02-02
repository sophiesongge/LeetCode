package solution;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class _3Sum{
	
	public static void main(String[] args){
		_3Sum test = new _3Sum();
		int[] nums = new int[]{-9,-2,3,2,2,5,4,8,4,2,9,0,6,8,-7,9,-6,-8,1,-7,3,-8,6,-9};
		
		long startTime1=System.nanoTime();
		List<List<Integer>> res1 = test.threeSum1(nums);
		long endTime1=System.nanoTime();
		
		System.out.printf("The execution time of two pointer method is: %s \n", String.valueOf(endTime1 - startTime1));
		System.out.printf("The result of two pointer method is: \n%s\n", test.toString(res1));
		
		
		
		long startTime2=System.nanoTime();
		List<List<Integer>> res2 = test.threeSum2(nums);
		long endTime2=System.nanoTime();
		
		System.out.printf("The execution time of backtracing method is: %s \n", String.valueOf(endTime2 - startTime2));
		System.out.printf("The result of two pointer method is: \n%s\n", test.toString(res2));
		
	}
	
	//Two Pointer Method
	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> res = new ArrayList();
		
		if(nums==null || nums.length==0){
			return res;
		}
		
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length-2; i++){
			if(i>0 && nums[i] == nums[i-1]){
				continue;
			}
			int start = i+1;
			int end = nums.length-1;
			int target = -nums[i];
			
			while(start < end){
				int sum = nums[start] + nums[end];
				if(target > sum){
					start++;
				}else if(target < sum){
					end--;
				}else{
					List<Integer> temps = new ArrayList();
					temps.addAll(Arrays.asList(nums[i], nums[start], nums[end]));
					res.add(temps);
					start++;
					end--;
					while(start < end && nums[start] == nums[start-1]){
						start++;
					}
					while(start < end && nums[end] == nums[end+1]){
						end--;
					}
				}
			}
		}
		return res;
	}
	
	//Backtracing	--- This method is no longer accepted by LeetCode, it will get a TLE, but I am quite sure that this is also a good method
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> res = new ArrayList();
		List<Integer> temps = new ArrayList();
		
		if(nums==null || nums.length==0){
			return res;
		}
		Arrays.sort(nums);
		backtracing(res, temps, 0, 0, nums);
		
		return res;
	}
	
	public void backtracing(List<List<Integer>> res, List<Integer> temps, int start, int target, int[] nums){
		if(target == 0 && temps.size() == 3){
			res.add(new ArrayList(temps));
		}
		
		for(int i=start; i<nums.length; i++){
			temps.add(nums[i]);
			backtracing(res, temps, i+1, target-nums[i], nums);
			temps.remove(temps.size() - 1);
			while(i<nums.length-1 && nums[i+1] == nums[i]){
				i++;
			}
		}
		
	}
	
	
	public String toString(List<List<Integer>> input){
		String res = "";
		
		for(int i=0; i<input.size(); i++){
			for(int j=0; j<input.get(i).size(); j++){
				res = res + input.get(i).get(j) + " ";
			}
			res = res + "\n";
		}
		return res;
	}

}