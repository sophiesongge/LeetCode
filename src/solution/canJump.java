package solution;

/**
 * @author Sophie Song
 * @since 03/07/2017
 */
public class canJump {

    public boolean canJump(int[] nums) {

        if(nums == null || nums.length == 0){
            return true;
        }

        if(nums[0] == 0 && nums.length != 1){
            return false;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        dp[1] = nums[0];


        //动态规划，dp[i]表示，到第i步，最多能走到哪儿，如果这个值等于或小于i，并且此时i不是结尾，则认为走不到结尾，因为走到i就停止了（当然我们的dp多了一位，所以要按i-last
        // 算）
        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i-1]+i-1);
            if(dp[i] <= i-1){
                return false;
            }
        }
        return true;
    }
}
