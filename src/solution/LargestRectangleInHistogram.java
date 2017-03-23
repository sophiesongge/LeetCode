package solution;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Sophie Song
 * @since 21/03/2017
 * Largest Rectangle in Histogram: https://leetcode.com/problems/largest-rectangle-in-histogram/?tab=Description#/solutions
 * 非常好的一道stack的题！思路非常巧妙，我自己只写出了一个基础的TLE方法。
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

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        //搞一个stack用来排序，如果当前元素比stack最后栈顶的元素大就压进栈；要不然就出栈，知道比栈顶元素小为止；
        //栈里装的是index，而不是具体的高度
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int maxSurface = 0;

        int[] h = new int[heights.length + 1];
        h = Arrays.copyOf(heights, heights.length + 1);

        while(i<h.length) {
            if(stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i);
                i++;
            }else {
                //如果栈顶元素比当前元素大，就让栈顶元素出栈，因为这个时候栈顶元素就不能喝当前元素组成矩形了，出了栈之后，为这个出栈的元素算面积
                int index = stack.pop();
                //这里是比较难理解的点，算面积的时候，只有前后的高度都比当前大，才能算，而从栈顶元素后面的一位开始一直到i都是比刚出栈的这个元素大的
                maxSurface = Math.max(maxSurface, h[index] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxSurface;
    }

}
