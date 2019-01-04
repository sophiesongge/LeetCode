package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Sophie Song
 * @since 23/11/2018
 */
public class LambdaStreamAPI {

    /**
     * Test Java 8 Stream API
     * @param args
     */
    public static void main(String[] args) {
        //The purpose of stream API is to avoid the use of iterator
        //Stream 是单向的，不可往复，数据只能遍历一次，遍历过一次后即用尽了
        //Stream可进行并行化操作，而iterator只能是串行的
        //Stream的另一个特点：数据源可以是无限的

        //使用流的三个步骤(Stream Pipeline)：获取一个数据源（source）-> 数据转换 -> 执行操作获取想要的结果

        List<String> list = Arrays.asList("Hello", "World", "This", "is", "a", "test", "!");

        //list.forEach(word -> System.out.print(word));
        //list.stream().forEach(System.out::println);

        //对 Stream 的使用就是实现一个 filter-map-reduce 过程

        List<String> output0 = list.stream().map(word -> word.toUpperCase()).collect(Collectors.toList());

        List<String> output1 = list.stream().filter(word -> word.contains("o")).collect(Collectors.toList());

        list.stream().filter(word -> word.length() > 4).peek(word -> System.out.println(word)).map(word -> word.toUpperCase()).peek(System.out::println).collect(Collectors.toList());

        //output1.stream().forEach(System.out::println);
    }
}
