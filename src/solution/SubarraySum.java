package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sophie Song
 * @since 2017/5/20
 * https://leetcode.com/problems/subarray-sum-equals-k/#/description
 * rangeSum(i, j) = sum(j) - sum(i), 为了降低复杂度，可以把sum(i)存到哈希表里
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum , 1);

        for(int i=0; i<nums.length; i++) {
            sum = sum + nums[i];

            if(map.containsKey(sum - k)){
                count = count + map.get(sum - k);
            }

            if(map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            }else {
                map.put(sum, 1);
            }
        }

        return count;
    }


    public static void main(String[] args) {
        SubarraySum test = new SubarraySum();

        int[] nums = new int[]{1, 1, 1};

        System.out.println(test.subarraySum(nums, 2));
    }
}
