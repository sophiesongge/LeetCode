package solution;

import java.util.*;

/**
 * Created by Sophie on 2019/2/23.
 */
class EvaluateDivision {

    public static void main(String[] args) {
        String[][] equations = {{"a","b"},{"b","c"}};
        double[] values = {2.0,3.0};
        String[][] queries = {{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};

        double[] res = calcEquation(equations, values, queries);

        Arrays.stream(res).forEach(System.out::println);
    }

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap();
        //constructe the graph
        for(int i = 0; i<equations.length; i++) {
            if(!graph.containsKey(equations[i][0])) {
                Map<String, Double> adj = new HashMap();
                adj.put(equations[i][1], values[i]);
                graph.put(equations[i][0], adj);
            }else {
                Map<String, Double> adj = graph.get(equations[i][0]);
                adj.put(equations[i][1], values[i]);
                graph.put(equations[i][0],adj);
            }
            if(!graph.containsKey(equations[i][1])) {
                Map<String, Double> adj = new HashMap();
                adj.put(equations[i][0], 1/values[i]);
                graph.put(equations[i][1], adj);
            }else {
                Map<String, Double> adj = graph.get(equations[i][1]);
                adj.put(equations[i][0], 1/values[i]);
                graph.put(equations[i][1], adj);
            }
        }

        double[] res = new double[queries.length];

        for(int i = 0; i<queries.length; i++) {
            res[i] = isValid(graph, queries[i][0], queries[i][1]);
        }
        return res;
    }

    public static double isValid(Map<String, Map<String, Double>> graph, String begin, String end) {
        if(graph.containsKey(begin) && begin.equals(end)) {
            return 1.0;
        }
        Queue<String> q = new LinkedList<>();
        Map<String, Double> visited = new HashMap();//这道题的难点在这里, 用广度优先搜索,每次到达某个位置之后要更新从开始一直到这里的乘积

        q.add(begin);
        visited.put(begin, 1.0);

        while(!q.isEmpty()) {
            int size = q.size();
            String top = q.poll();
            double res = visited.get(top);
            if(!graph.containsKey(top)) {
                return -1.0;
            } else {
                for(String k : graph.get(top).keySet()) {
                    if(!visited.containsKey(k)) {
                        visited.put(k, res * graph.get(top).get(k));
                        if(end.equals(k)){
                            return visited.get(k);
                        }
                        q.add(k);
                    }
                }
            }
        }
        return -1.0;
    }
}
