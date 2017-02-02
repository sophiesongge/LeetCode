package solution;
/**
 * https://leetcode.com/problems/house-robber-ii/
 * @author Sophie
 *
 */
public class HouseRobberII {
	public static void main(String[] args){
		HouseRobberII test = new HouseRobberII();
		int[] nums = new int[]{1, 2};
		System.out.println(test.rob(nums));
	}
	
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
        	return nums[0];
        }
        int len = nums.length;
        
        int[] takeFirst = new int[len + 1];
        int[] takeLast = new int[len + 1];
        
        takeFirst[0] = 0;
        takeFirst[1] = nums[0];
        
        takeLast[0] = 0;
        takeLast[1] = 0;
        
        for(int i=2; i<=len; i++){
        	takeFirst[i] = Math.max(takeFirst[i-1], takeFirst[i-2] + nums[i-1]);
        	takeLast[i] = Math.max(takeLast[i-1], takeLast[i-2] + nums[i-1]);
        }
        
        return Math.max(takeFirst[len-1], takeLast[len]);
    }
}
