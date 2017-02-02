package solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-search-ii/
 * @author Sophie
 * 这道题如果按照word search I的方法来判断每一个词是不是能由这个board组成则会超时, 因为对每个词都要进行一次完整的backtracing， 这时候如果能有一个数据结构把所有的词都索引起来让我们只查一次就好了
 * 正确的方法是将需要检查的词组成一个TrieTree， 然后每次判断由board形成的词是不是在这个TrieTree中, 其他思路其实和wordsearch I是一样的
 */
public class WordSearchII {
	public static void main(String[] args){
		String[] words = new String[]{"oath","pea","eat","rain"};
		char[][] board = new char[][]{{'o', 'a', 'a', 'n'},{'e', 't', 'a', 'e'},{'i', 'h', 'k', 'r'},{'i', 'f', 'l', 'v'}};
		WordSearchII test = new WordSearchII();
		test.toString(test.findWords(board, words));
	}
	
	public List<String> findWords(char[][] board, String[] words) {
		TrieTree trie = new TrieTree();
		for(String s : words){
			trie.insert(s);
		}
		List<String> res = new ArrayList();
		String temps = "";
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				backtracing(board, trie, i, j, res, temps);
			}
		}
		
		return res;
	}
	
	public void backtracing(char[][] board, TrieTree words, int rowindex, int colindex, List<String> res, String temps){
		if(rowindex < 0 || colindex < 0 || rowindex >= board.length || colindex >= board[0].length){
			return;
		}
		if(board[rowindex][colindex] == '#'){
			return;
		}
		
		temps = temps + board[rowindex][colindex];
		
		if(!words.startWith(temps)){
			return;
		}
		
		if(words.search(temps)){
			if(!res.contains(temps)){
				res.add(temps);
			}
		}

		char c = board[rowindex][colindex];
		board[rowindex][colindex] = '#';
		
		backtracing(board, words, rowindex+1, colindex, res, temps);
		backtracing(board, words, rowindex-1, colindex, res, temps);
		backtracing(board, words, rowindex, colindex+1, res, temps);
		backtracing(board, words, rowindex, colindex-1, res, temps);
		
		board[rowindex][colindex] = c;
	}
	
	public void toString(List<String> res){
		for(String s : res){
			System.out.print(s+" ");
		}
	}
	
}

class TrieNode {
	boolean isEnd;
	Map<Character, TrieNode> children;
	
	public TrieNode() {
		this.isEnd = false;
		this.children = new HashMap<Character, TrieNode>();
	}
}

class TrieTree {
	private TrieNode root;
	
	public TrieTree() {
		this.root = new TrieNode();
	}
	
	public void insert(String word){
		TrieNode current = root;
		for(char c : word.toCharArray()){
			if(!current.children.containsKey(c)){
				current.children.put(c, new TrieNode());
			}
			current = current.children.get(c);
		}
		current.isEnd = true;
	}
	
	public TrieNode getLast(String word) {
		TrieNode current = root;
		for(char c : word.toCharArray()) {
			current = current.children.get(c);
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	
	public boolean search(String word) {
		TrieNode current = getLast(word);
		if(current != null && current.isEnd){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean startWith(String prefix){
		TrieNode current = getLast(prefix);
		if(current == null){
			return false;
		}else{
			return true;
		}
	}
}
