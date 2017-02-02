package solution;
/**
 * https://leetcode.com/problems/word-search/
 * 这道题直观的想其实是一道图的广度优先搜索题，问题是如果用我们比较熟悉的邻接表的方式来表示图，这个图很难进行表示。 所以退而求其次， 用回溯的思想来做
 * @author Sophie
 *
 */
public class WordSearch {
	
	public static void main(String[] args){
		WordSearch test = new WordSearch();
		
		char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
		String word = "ABCCED";
		String word0 = "ABCB";
		
		char[][] board1 = new char[][]{{'a', 'b'}};
		String word1 = "ba";
		
		System.out.println(test.exist(board1, word1));
	}
	
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(backtracing(board, word, 0, i, j)){
        			return true;
        		}
        	}
        }
    	return false;
    }
    
    public boolean backtracing(char[][] board, String word, int wordindex, int rowindex, int colindex){
    	
    	if(wordindex == word.length()){
    		return true;
    	}
    	
    	if(rowindex < 0 || colindex < 0 || rowindex >= board.length || colindex >= board[0].length){
    		return false;
    	}
    	
    	if(board[rowindex][colindex] == word.charAt(wordindex)){
    		char temps = board[rowindex][colindex];
    		board[rowindex][colindex] = '$';
    		boolean res = backtracing(board, word, wordindex+1, rowindex+1, colindex) ||
    					  backtracing(board, word, wordindex+1, rowindex-1, colindex) ||
    					  backtracing(board, word, wordindex+1, rowindex, colindex+1) ||
    					  backtracing(board, word, wordindex+1, rowindex, colindex-1);
    		board[rowindex][colindex] = temps;
    		return res;
    	}
    	return false;
    }
}
