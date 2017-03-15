package solution;
/**
 * @author Sophie Song
 * @since 14/03/2017
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberOfAirplaneInTheAir {

    public int countOfAirplanes(List<Interval> airplanes) {
        List<Point> list = new ArrayList<>(airplanes.size());
        for(Interval i : airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }

        Collections.sort(list, Point.PointComparator);

        int count = 0;
        int ans = 0;
        for(Point p : list) {
            //遇到一个start点，说明两个灰机在天上重叠了，所以就把count + 1； 相反遇到一个end点，可以理解为一个重叠区域结束了，就把count - 1
            if(p.flag == 1) {
                count++;
            }else{
                count--;
            }
            //在当前状态下，结果应该是在当前这个点的位置，重叠的飞机有多少，如果当前点是个start点，则这个数目应该是count的数目，如果当前点是个end点，则这个数目则应该是前一状态的点数，前一状态又是由ans记录的，所以
            //总体来说ans应该是ans和count中大的那个
            ans = Math.max(ans, count);
        }
        return ans;
    }
}

class Point {
    int time;
    int flag;//1 == start time, 0 == end time

    Point(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }

    //对所有的区间的起始点按大小排序（由小到大），如果两个点一样，则把开始的点放前面
    public static Comparator<Point> PointComparator = new Comparator<Point>(){
        public int compare(Point p1, Point p2) {
            if(p1.time == p2.time) {
                return p1.flag - p2.flag;
            }else {
                return p1.time - p2.time;
            }
        }
    };
}

class Interval {
    int start;
    int end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}