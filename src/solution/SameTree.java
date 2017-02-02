package solution;
import java.util.ArrayList;

/**
 * 题目：https://leetcode.com/problems/same-tree/
 * 备注：经典的recursive问题，化解问题是关键
 * @author Sophie
 */

public class SameTree {
	public static void main(String[] args){
		TreeNode p = new TreeNode(0);
		TreeNode q = new TreeNode(1);
		System.out.println(isSameTree(p, q));
	}
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(p==null && q!=null){
            return false;
        }else if(q==null && p!=null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else{
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}