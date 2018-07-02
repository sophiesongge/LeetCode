package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Sophie Song
 * @since 2017/5/10
 */
public class test {

    public static void main(String[] args){
        TreeNodeB root = new TreeNodeB(1);
        TreeNodeB n2 = new TreeNodeB(2);
        TreeNodeB n3 = new TreeNodeB(5);
        TreeNodeB n4 = new TreeNodeB(3);
        TreeNodeB n5 = new TreeNodeB(4);
        TreeNodeB n6 = new TreeNodeB(6);
        TreeNodeB n7 = new TreeNodeB(7);

        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n6.left = n7;

        BFS(root);
        DFS(root);

    }

    public static void BFS(TreeNodeB root){
        if(root == null){
            return;
        }

        Queue<TreeNodeB> q = new LinkedList<TreeNodeB>();
        q.add(root);
        System.out.print(root.val+" ");

        while(!q.isEmpty()){
            TreeNodeB top = q.poll();
            if(top.left != null){
                q.add(top.left);
                System.out.print(top.left.val+" ");
            }
            if(top.right != null){
                q.add(top.right);
                System.out.print(top.right.val+" ");
            }
        }
        System.out.println();
    }

    public static void DFS(TreeNodeB root) {
        if(root == null) {
            return;
        }

        Stack<TreeNodeB> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()) {
            TreeNodeB top = s.pop();
            System.out.println(top.val);
            if(top.right != null) {
                s.push(top.right);
            }
            if(top.left != null) {
                s.push(top.left);
            }
        }
    }
}

class TreeNodeB{
    public int val;
    public TreeNodeB left;
    public TreeNodeB right;

    public TreeNodeB(int data){
        this.val = data;
        this.left = null;
        this.right = null;
    }
}