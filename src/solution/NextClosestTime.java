package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sophie on 2019/2/22.
 */
public class NextClosestTime {
    /**
     * @param time: the given time
     * @return: the next closest time
     */

    String res = "";
    int diff = Integer.MAX_VALUE;

    public String nextClosestTime(String time) {
        // write your code here

        Set<Integer> set = new HashSet();

        for(char c : time.toCharArray()) {
            if(c != ':') {
                set.add(Character.getNumericValue(c));
            }
        }

        if(set.size() == 1) {
            return time;
        }

        int target = toNumber(time);

        List<Integer> num = new ArrayList(set);

        dfs(num, "", 0, target);

        return res;
    }

    //convert time to a comparable Number time = HH * 60 + MM

    public int toNumber(String time) {
        String[] timeArray = time.split(":");
        int HH = Integer.parseInt(timeArray[0]);
        int MM = Integer.parseInt(timeArray[1]);

        return HH * 60 + MM;
    }

    //get all the possible combination of time
    public void dfs(List<Integer> num, String temp, int pos, int target) {

        if(temp.length() == 4) {
            int mm = Integer.parseInt(temp.substring(0,2)) * 60 + Integer.parseInt(temp.substring(2,4));
            int d = mm - target > 0 ? (mm - target) : (24 * 60 + mm - target);
            if(diff > d) {
                diff = d;
                res = temp.substring(0, 2) + ":" + temp.substring(2, 4);
            }
            return;
        }

        for(int i = 0; i<num.size(); i++) {
            if(pos == 0 && num.get(i) > 2) {
                continue;//小时的十位不能大于二
            }
            if(pos == 1 && num.get(i) + Integer.parseInt(temp) * 10 > 23 ) {
                continue;
            }
            if(pos == 2 && num.get(i) > 5) {
                continue;
            }
            if(pos == 3 && num.get(i) + Integer.parseInt(temp.substring(2)) * 10 > 59) {
                continue;
            }
            //We can use this to replace the following 3 lines: dfs(num, temp+num.get(i), pos+1, target);
            temp = temp + num.get(i);
            dfs(num, temp, pos+1, target);
            temp = temp.substring(0, temp.length()-1);
        }

    }
}



