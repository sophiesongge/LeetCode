package solution;

import java.util.*;
public class _4Sum{
	
	public static void main(String[] args){
		int[] nums = new int[]{1,0,-1,0,-2,2};
		int target = 0;
		
		_4Sum test = new _4Sum();
		
		List<List<Integer>> res = test.fourSum1(nums, target);
		
		for(int i=0; i<res.size(); i++){
			for(int j=0; j<res.get(i).size(); j++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	//backtracing的方法虽然可以得出结果，但是会get一个TLE
    public List<List<Integer>> fourSum0(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temps = new ArrayList();
        if(nums==null || nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        backtracing(result, temps, 0, nums, target);
        return result;
    }
    
    private void backtracing(List<List<Integer>> results, List<Integer> temps, int current, int[] nums, int target){
        if(target == 0 && temps.size() == 4){
            results.add(new ArrayList(temps));
        }
        for(int i=current; i<nums.length; i++){
            temps.add(nums[i]);
            backtracing(results, temps, i+1, nums, target-nums[i]);
            temps.remove(temps.size()-1);
            while(i<nums.length-1 && nums[i+1] == nums[i]){
                i++;
            }
        }
    }
    
    //两个指针比较保险, 但是也得到了TLE！所以要动个脑筋， 就是要剪枝！
    
    public List<List<Integer>> fourSum1(int[] nums, int target){
    	List<List<Integer>> result = new ArrayList();
    	
    	if(nums==null || nums.length == 0){
    		return result;
    	}
    	
    	Arrays.sort(nums);
    	int max = nums[nums.length - 1];
    	
    	for(int i=0; i<nums.length-3; i++){
    		if(i!=0 && nums[i] == nums[i-1]){
    			continue;
    		}
    		
    		for(int j=i+1; j<nums.length-2; j++){
    			if(j!=i+1 && nums[j] == nums[j-1]){
    				continue;
    			}
    			
    			int m = j+1;
    			int n = nums.length - 1;
    			
    			while(m < n){
        			
        			int targetSum = target - nums[i] - nums[j];
        			int sum = nums[m] + nums[n];
        			if(sum > targetSum){
        				n--;
        			}else if(sum < targetSum){
        				m++;
        			}else{
        				List<Integer> temps = new ArrayList();
        				temps.addAll(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
        				result.add(temps);
        				m++;
        				n--;
        				while(m<n && nums[m] == nums[m-1]){
        					m++;
        				}
        				while(m<n && nums[n] == nums[n+1]){
        					n--;
        				}
        			}
    			}
    		}
    	}
    	return result;
    }
	
}