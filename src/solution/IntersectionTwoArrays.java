package solution;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * https://leetcode.com/problems/intersection-of-two-arrays/#/description
 * @author Sophie Song
 * @since 20/03/2017
 */
public class IntersectionTwoArrays {


    public static void main(String[] args) {
        IntersectionTwoArrays test = new IntersectionTwoArrays();

        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{2, 1};


        test.toPrint(test.intersection(nums1, nums2));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0) {
            return nums1;
        }

        if(nums2 == null || nums2.length == 0) {
            return nums2;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> res = new ArrayList();

//        for(int i=0; i<nums1.length; i++) {
//            if(search(nums2, nums1[i]) != -1) {
//                res.add(nums1[i]);
//            }
//            while(i != nums1.length - 1 && nums1[i+1] == nums1[i]) {
//                i++;
//            }
//        }
        int start = 0;
        for(int i=0; i<nums1.length; i++) {
            int s = advancedSearch(nums2, nums1[i], start);
            if( s != -1){
                res.add(nums1[i]);
                start = s;
            }
            while(i != nums1.length - 1 && nums1[i+1] == nums1[i]) {
                i++;
            }
        }



        int[] ans = new int[res.size()];

        for(int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

//    public int search(int[] nums, int target) {
//
//        int start = 0;
//        int finish = nums.length - 1;
//
//        while(start <= finish) {
//            int mid = start + (finish - start) / 2;
//            if(target > nums[mid]) {
//                start = mid + 1;
//            }else if(target < nums[mid]) {
//                finish = mid - 1;
//            }else{
//                return mid;
//            }
//        }
//        return -1;
//    }

    public int advancedSearch(int[] nums, int target, int begin) {
        if(begin > nums.length) {
            return -1;
        }

        int start = begin;
        int finish = nums.length - 1;

        while(start <= finish) {
            int mid = start + (finish - start) / 2;

            if(target > nums[mid]) {
                start = mid + 1;
            }else if(target < nums[mid]) {
                finish = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public void toPrint(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}


