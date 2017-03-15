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
            //遇到一个start点，就把count + 1， 相反遇到一个end点，就把count - 1
            if(p.flag == 1) {
                count++;
            }else{
                count--;
            }
            //最终的结果
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