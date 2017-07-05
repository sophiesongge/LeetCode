package solution;

/**
 * @author Sophie Song
 * @since 03/07/2017
 */
public class canJumpII {

    public int jump(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        int curFurthest = 0;
        //算到倒数第二位就行，最后一位不用算
        for(int i=0; i<nums.length-1; i++) {
            curFurthest = Math.max(curFurthest, i + nums[i]);
            if(curFurthest >= nums.length-1){
                return jumps+1;
            }
            if(i == curEnd) {
                curEnd = curFurthest;
                jumps++;
            }
        }
        return jumps;
    }

}
