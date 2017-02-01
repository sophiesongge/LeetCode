/**
 * https://leetcode.com/problems/house-robber-iii/
 * @author Sophie
 *
 */
public class HouseRobberIII {
	public static void main(String[] args){
		
	}
	
	public int rob(TreeNode root){
		int[] res = DFS(root);
		return Math.max(res[0], res[1]);
	}
	
	public int[] DFS(TreeNode root){
		
		if(root == null){
			return new int[2];
		}
		
		int[] left = DFS(root.left);
		int[] right = DFS(root.right);
		
		int[] res = new int[2];
		
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//不偷root
		res[1] = root.val + left[0] + right[0];//偷root
				
		return res;
	}
	
	
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x){ 
			val = x; 
		}
	}
}


