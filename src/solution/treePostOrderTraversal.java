package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author Sophie Song
 * @since 17/07/2017
 */
public class treePostOrderTraversal {

    /**
     *       0
     *     /   \
     *    1     2
     *   /\    / \
     *  3 4    5 6
     */

    public static void main(String[] args) {
        TreeNode p0 = new TreeNode(0);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);

        p0.left = p1;
        p0.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;

        treePostOrderTraversal test = new treePostOrderTraversal();

        ArrayList<Integer> res = test.postOrderTraversalNonRecursive(p0);

        for(Integer i : res) {
            System.out.print(i + " ");
        }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList();

        if(root==null){
            return result;
        }

        postorder(result, root);

        return result;
    }

    public void postorder(ArrayList<Integer> result, TreeNode root){
        if(root==null){
            return;
        }
        postorder(result, root.left);
        postorder(result, root.right);
        result.add(root.val);
    }

    public ArrayList<Integer> postOrderTraversalNonRecursive(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack();

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();
            res.add(top.val);
            if(top.left!=null) {
                stack.push(top.left);
            }
            if(top.right!=null) {
                stack.push(top.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
