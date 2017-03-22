package solution;

/**
 * @author Sophie Song
 * @since 21/03/2017
 * Largest Rectangle in Histogram: https://leetcode.com/problems/largest-rectangle-in-histogram/?tab=Description#/solutions
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int maxSurface = 0;

        if(heights == null || heights.length == 0) {
            return maxSurface;
        }

        int min = heights[0];

        for(int i=0; i<heights.length; i++) {
            if(heights[i] == 0) {
                maxSurface = Math.max(maxSurface, min * (i+1));
                if(i != heights.length - 1) {
                    min = heights[i+1];
                }
            }else{
                min = Math.min(min, heights[i]);
            }


            int counterBack = 1;
            int counterForward = 1;
            int j = i;
            int k = i;
            while(j < heights.length - 1 && heights[j+1] >= heights[j]) {
                j++;
                counterBack++;
            }
            int surfaceBack = heights[i] * counterBack;
            maxSurface = Math.max(maxSurface, surfaceBack);

            while(k > 0 && heights[k-1] >= heights[k]) {
                k--;
                counterForward++;
            }
            int surfaceForward = heights[i] * counterForward;
            maxSurface = Math.max(maxSurface, surfaceForward);
        }
        return Math.max(maxSurface, min * heights.length);
    }

}
