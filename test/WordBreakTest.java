package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import solution.WordBreak;

import org.junit.Test;

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
