package solution;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sophie Song
 * @since 2017/5/2
 * https://leetcode.com/problems/max-points-on-a-line/#/description
 * 这道题要转换为，固定一个点，看其他点是否和这个点在一条直线上，这样可以省去对b的计算，只要算斜率即可
 * 首先，判断两点是否在同一直线上，要判断斜率是否相等，斜率的计算是(y2-y1)/(x2-x1)
 * 对没两个点进行斜率计算，然后将斜率作为key，斜率出现的次数作为value存入一个hashmap即可
 * 难点：计算斜率的时候涉及到分三种情况讨论：
 * （1）(x1, y1)和(x2, y2)是相同的点 -- samePoint
 * （2） x2 = x1， 即分母出现0了，斜率是无穷大
 * （3）可进行正常计算斜率
 */
public class MaxPoints {
    private class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        if(points.length <= 2) {
            return points.length;
        }

        int result = 0;

        for(int i=0; i<points.length-1; i++) {
            Map<BigDecimal, Integer> map = new HashMap<>();
            int samePoint = 0;
            int sameX = 1;

            for(int j = 0; j < points.length; j++) {
                if(j!=i){
                    if(points[j].x == points[i].x && points[j].y == points[i].y) {
                        samePoint++;
                    }
                    if(points[j].x == points[i].x){
                        sameX++;
                        continue;
                    }

                    //用BigDecimal来相除是为了保证计算结果的精度，其实如果不吹毛求疵，用double就可以

                    BigDecimal dy = new BigDecimal(points[j].y - points[i].y);
                    BigDecimal dx = new BigDecimal(points[j].x - points[i].x);
                    BigDecimal k = dy.divide(dx, MathContext.DECIMAL128);

                    if(map.containsKey(k)){
                        map.put(k, map.get(k) + 1);
                    }else{
                        map.put(k, 2);
                    }
                    result = Math.max(result, map.get(k) + samePoint);
                }
            }
            result = Math.max(result, sameX);
        }
        return result;
    }
}

