package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sophie Song
 * @since 2017/5/12
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/#/description
 */
public class CountSmallerNumbers {
    private class BST {
        int val;
        int count;
        int same;
        BST left;
        BST right;

        public BST(int val) {
            this.val = val;
            this.count = 0;
            this.same = 1;
        }
    }

    private BST insert(BST root, int val) {
        if(root == null) {
            root = new BST(val);
        }else if(val == root.val){
            root.same++;
        }else if(val < root.val) {
            root.count++;
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    private int search(BST root, int val) {
        if(root == null) {
            return 0;
        }else if(val == root.val) {
            return root.count;
        }else if(val < root.val) {
            return search(root.left, val);
        }else {
            return root.count+ root.same + search(root.right, val);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList();
        BST root = null;

        if(nums == null || nums.length == 0) {
            return result;
        }

        for(int i=nums.length-1; i>=0; i--) {
            result.add(0, search(root, nums[i]));
            root = insert(root, nums[i]);
        }

        return result;
    }
}
