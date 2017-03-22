package solution;

/**
 * @author Sophie Song
 * @since 21/03/2017
 * Largest Rectangle in Histogram: https://leetcode.com/problems/largest-rectangle-in-histogram/?tab=Description#/solutions
 */
public class LargestRectangleInHistogram {

    //这个解法对了，但是过不了大集合，会有TLE
    public int largestRectangleArea0(int[] heights) {
        int maxSurface = 0;

        if(heights == null || heights.length == 0) {
            return maxSurface;
        }

        for(int i=0; i<heights.length; i++) {
            int counterBack = 0;
            int counterForward = 0;
            int j = i;
            int k = i;
            while(j < heights.length - 1 && heights[j+1] >= heights[i]) {
                j++;
                counterBack++;
            }

            int surfaceBack = heights[i] * counterBack;

            while(k > 0 && heights[k-1] >= heights[i]) {
                k--;
                counterForward++;
            }

            int surfaceForward = heights[i] * counterForward;

            int surface = surfaceBack + surfaceForward + heights[i];

            maxSurface = Math.max(maxSurface, surface);
            //System.out.println("%%%%%%%%%%" + heights[i] + " : " + maxSurface + "%%%%%%%%%%%");
        }
        return maxSurface;
    }

}
