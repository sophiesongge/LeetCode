package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sophie Song
 * @since 2017/6/9
 */
public class PermutationSequence {

    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        System.out.println(test.getPermutation(5, 3));
    }

    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList();
        for(int i=1; i<=n; i++) {
            num.add(i);
        }
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i=1; i<n; i++) {
            factorial[i] = i * factorial[i-1];
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for(int i = n-1; i>0; i--) {
            int index = k / factorial[i-1];
            k = k%factorial[i-1];
            sb.append(num.get(index));
            num.remove(index);
        }
        return sb.toString();
    }
}
