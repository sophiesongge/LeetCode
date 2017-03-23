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

        assertEquals(test.largestRectangleArea0(heights), test.largestRectangleArea(heights));

        heights = new int[]{2, 1, 5, 6, 2, 3};

        assertEquals(test.largestRectangleArea0(heights), test.largestRectangleArea(heights));

        heights = new int[]{4, 2, 0, 3, 2, 5};

        assertEquals(test.largestRectangleArea0(heights), test.largestRectangleArea(heights));

        heights = new int[]{4,2,0,3,2,4,3,4};

        assertEquals(test.largestRectangleArea0(heights), test.largestRectangleArea(heights));

    }
}
