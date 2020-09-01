package Stream;

import org.junit.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ZhuGangGang
 * @Date 2020/3/9 14:06
 */
public class StreamTest {

    @Test
    public void test1(){
        List<String> ss =new ArrayList<>();
        ss.add("4");
        ss.add("5");
        ss.stream().filter(s->s.equals("4")).forEach(s->System.out.println(s));
    }
    @Test
    public void test2(){
        String[] strings = {"12", "25", "36"};
        Stream<String> stream = Arrays.stream(strings);
        //Stream<Stream<Character>> streamStream = stream.map(StreamTest::getStream);
       // streamStream.forEach(s->s.forEach(System.out::println));
        Stream<Character> stream1 = stream.flatMap(StreamTest::getStream);
        stream1.forEach(System.out::println);
    }

    public static Stream<Character> getStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character s: str.toCharArray()) {
            list.add(s);
        }
        return  list.stream();
    }

    @Test
    public void  test(){
        List<Employee> employees = EmployeeData.getEmployees();
        //count: 计算流中的个数
        long count = employees.stream().count();
        System.out.println("count = " + count);
        //max: 返回流中最大值
        Optional<Integer> max = employees.stream().map(Employee::getAge).max(Integer::compare);
        //min: 返回流中最小值
        Optional<Double> min = employees.stream().map(Employee::getSalary).min(Double::compare);
        //findFirst 返回流的第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        //findAny: 返回流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
        //anyMatch: 对流中的元素逐一进行匹配,匹配到任意一个即返回
        boolean match = employees.stream().anyMatch((e) -> e.getName().contains("李"));
        System.out.println(match);
        //allMatch: 对流中的所有元素进行匹配,流中所有数据进行匹配
        boolean allMatch = employees.stream().allMatch((e) -> e.getName().contains("李"));
        System.out.println(allMatch);
    }

    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //方法一:  reduce(T identity, BinaryOperator<T> accumulator);
        //参数一: 指初始化值  参数二: 函数式接口将流中的元素进行相加
        Integer num = list.stream().reduce(0, Integer::sum);
        System.out.println(num);
        //方法二: reduce(BinaryOperator<T> accumulator)
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> sum = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(sum);
    }

}
