import static org.junit.Assert.assertEquals;

import org.junit.Test;

import solution.LargestRectangleInHistogram;

/**
 * @author Sophie Song
 * @since 21/03/2017
 */

public class LargestRectangleInHistogramTest {

    LargestRectangleInHistogram test = new LargestRectangleInHistogram();

    @Test
    public void largestRectangleInHistogramTest() {
        int[] heights = null;

        assertEquals(0, test.largestRectangleArea(heights));

        heights = new int[]{2, 1, 5, 6, 2, 3};

        assertEquals(10, test.largestRectangleArea(heights));

        heights = new int[]{4, 2, 0, 3, 2, 5};

        assertEquals(6, test.largestRectangleArea(heights));

        heights = new int[]{4,2,0,3,2,4,3,4};

        assertEquals(10, test.largestRectangleArea(heights));

        //System.out.println(test.largestRectangleArea(heights));

    }
}
