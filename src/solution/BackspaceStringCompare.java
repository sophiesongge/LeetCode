package solution;

/**
 * Created by Sophie on 2019/2/24.
 */
class Solution {
    public static void main(String[] args) {
        String S = "bxj##tw";
        String T = "bxo#j##tw";

        System.out.println(backspaceCompare(S, T));
    }

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skips = 0;
        int skipt = 0;

        while(i >= 0 || j >= 0) {

            while(i >= 0) {
                if(S.charAt(i) == '#') {
                    skips++;
                    i--;
                }else if(skips>0) {
                    skips--;
                    i--;
                }else {
                    break;
                }
            }

            while(j >= 0) {
                if(T.charAt(j) == '#') {
                    skipt++;
                    j--;
                }else if(skipt>0) {
                    skipt--;
                    j--;
                }else {
                    break;
                }
            }
            if(i > 0 && j > 0 &&  S.charAt(i) != T.charAt(j)){
                return false;
            }

            if(i>=0 != j>=0) {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }
}
