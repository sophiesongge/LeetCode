import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import solution.WordLadderII;

public class WordLadderIITest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		WordLadderII wl = new WordLadderII();
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReplace() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdjacent() {
		fail("Not yet implemented");
	}

	@Test
	public void testWordLadderHelper() {
		fail("Not yet implemented");
	}

	@Test
	public void testBacktracing() {
		fail("Not yet implemented");
	}

	@Test
	public void testWordLadderII() {
		fail("Not yet implemented");
	}

}
