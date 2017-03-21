import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import solution.WordBreak;

public class WordBreakTest {
	

	WordBreak wb = new WordBreak();
	
	@Test
	public void testWordBreak() {
		String word = "LeetCode";
		String notWord = "LintCode";
		List<String> wordDict = new ArrayList();
		
		assertFalse(wb.wordBreak(word, wordDict));
		
		wordDict.addAll(Arrays.asList("Leet", "Code"));
		
		assertTrue(wb.wordBreak(word, wordDict));
		
		assertFalse(wb.wordBreak(notWord, wordDict));
		
		
		
	}
	
	

}
