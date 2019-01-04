package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 * @author Sophie Song
 * @since 04/10/2018
 */
public class DegreeOfAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,1};

        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        int max = 0;
        Map<Integer, Integer> degree = new HashMap();
        for(int x : nums) {
            if(degree.containsKey(x)) {
                degree.put(x, degree.get(x) + 1);
            }else{
                degree.put(x, 1);
            }
            max = Math.max(max, degree.get(x));
        }
        List<Integer> list = new ArrayList();
        for(Integer x : degree.keySet()) {
            if(degree.get(x) == max) {
                list.add(x);
            }
        }
        System.out.println("***************The most frequent elements**************");
        for(Integer x : list) {
            System.out.print(x + " ");
        }
        int length = nums.length;
        for(Integer x : list) {
            int left = 0;
            int right = nums.length - 1;
            while(left < right) {
                if(nums[left] != x) {
                    left++;
                }
                if(nums[right] != x) {
                    right--;
                }
                if(nums[left] == x && x == nums[right]) {
                    break;
                }
            }
            length = Math.min(length, right - left + 1);
        }
        return length;
    }
}
