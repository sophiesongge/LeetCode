package solution;

/**
 * @author Sophie Song
 * @since 2017/5/7
 * https://leetcode.com/problems/validate-binary-search-tree/#/description
 */
public class isValidBST {
    //方法一、min/max法，原理是root是右子树的最大值，左子树的最小值
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean helper(TreeNode root, long MAX, long MIN) {
        if(root == null) {
            return true;
        }


        if(root.val <= MIN || root.val >= MAX) {
            return false;
        }

        return helper(root.left, root.val, MIN) && helper(root.right, MAX, root.val);
    }
}
