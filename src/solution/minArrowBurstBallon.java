package solution;

import java.util.Arrays;

/**
 * @author Sophie Song
 * @since 06/07/2017
 */
public class minArrowBurstBallon {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> a[1] - b[1]);

        int currentArrow = points[0][1];
        int currentCount = 1;

        for(int i=1; i<points.length; i++) {
            if(currentArrow >= points[i][0]){
                continue;
            }
            currentCount++;
            currentArrow = points[i][1];
        }
        return currentCount;
    }
}
