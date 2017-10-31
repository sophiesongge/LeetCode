package solution;

/**
 * @author Sophie Song
 * @since 31/10/2017
 */
public class ReverseStringII {

    public void reverseString(char[] s) {
        reverseWord(s, 0, s.length-1);

        int i = 0;
        int j = 0;

        while(j < s.length) {
            if(s[j] == ' '){
                reverseWord(s, i, j-1);
                i = j+1;
            }
            j++;
        }
        reverseWord(s, i, j-1);
    }

    public void reverseWord(char[] word, int i, int j) {
        while(i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String ss = "the sky is blue";
        char[] s = ss.toCharArray();
        ReverseStringII test = new ReverseStringII();
        test.reverseString(s);
        System.out.println(new String(s));
    }
}
