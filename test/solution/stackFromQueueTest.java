package solution;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sophie Song
 * @since 07/07/2017
 */
public class stackFromQueueTest {
    stackFromQueue stack1 = new stackFromQueue();
    stackFromQueue stack2 = new stackFromQueue();

    @Before
    public void setUp() throws Exception {
        stack2.push(1);
        stack2.push(2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void push() throws Exception {
        assertTrue(stack1.isEmpty());
        stack1.push(1);
        assertFalse(stack1.isEmpty());
    }

    @Test
    public void peek() throws Exception {
        try{
            stack1.peek();
        } catch (NullPointerException e) {
            assertTrue(e.getMessage().contains("The Stack is empty"));
        }
        assertEquals(2, stack2.peek());
    }

    @Test
    public void pop() throws Exception {
        try{
            stack1.pop();
        } catch (NullPointerException e) {
            assertTrue(e.getMessage().contains("The Stack is empty"));
        }
        assertEquals(2, stack2.pop());
        assertEquals(1, stack2.pop());
        assertTrue(stack2.isEmpty());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(stack1.isEmpty());
        assertFalse(stack2.isEmpty());
    }

}