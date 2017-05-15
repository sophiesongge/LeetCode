package solution;

/**
 * @author Sophie Song
 * @since 2017/5/15
 */
public class TrappingRain {
    public int trap(int[] height) {
        if(height.length < 3) {
            return 0;
        }

        int result = 0;

        int indexL = 0;
        int indexR = height.length - 1;

        while(indexL < indexR && height[indexL] < height[indexL + 1]) {
            indexL++;
        }

        while(indexL < indexR && height[indexR] < height[indexR - 1]) {
            indexR--;
        }

        while(indexL < indexR) {
            int leftValue = height[indexL];
            int rightValue = height[indexR];

            if(leftValue < rightValue) {
                while(indexL < indexR && leftValue >= height[indexL]) {
                    result = result + leftValue - height[indexL];
                    indexL++;
                }
            }else {
                while(indexL < indexR && rightValue >= height[indexR]) {
                    result = result + rightValue - height[indexR];
                    indexR--;
                }
            }
        }

        return result;
    }
}
