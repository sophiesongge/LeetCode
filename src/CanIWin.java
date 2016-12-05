public class CanIWin{
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(desiredTotal > sum){
            return false;
        }
        if(desiredTotal <= 0){
            return true;
        }
        boolean[] dp = new boolean[maxChoosableInteger+1];
        dp[0] = true;
        dp[1] = true;
        
        
        return false;
    }
    
    public boolean helper(int maxChoosableInteger, int desiredTotal, )
}