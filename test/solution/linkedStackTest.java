package solution;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sophie
 * @since 14/07/2017
 */
public class linkedStackTest {
    linkedStack<Integer> stack1 = new linkedStack<>();
    linkedStack<Integer> stack2 = new linkedStack<>();
    @Before
    public void setUp() throws Exception {
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void push() throws Exception {
        assertTrue(stack2.isEmpty());
        stack2.push(1);
        assertFalse(stack2.isEmpty());
    }

    @Test
    public void pop() throws Exception {
        assertEquals((long)3, (long)stack1.pop());
        assertEquals((long)2, (long)stack1.pop());
        assertEquals((long)1, (long)stack1.pop());
        assertEquals(null, stack2.pop());
    }


    @Test
    public void peek() throws Exception {
        assertEquals((long)3, (long)stack1.peek());
        assertEquals((long)3, (long)stack1.peek());
        assertEquals((long)3, (long)stack1.peek());
        assertEquals(null, stack2.peek());
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse(stack1.isEmpty());
        assertTrue(stack2.isEmpty());
    }

}