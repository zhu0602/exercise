package lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ZhuGangGang
 * @Date 2020/3/6 20:41
 */
public class LambdaTest {

    @Test
    public void test1(){
        String[] s=new String[10];
        consumerSomething("刘德华", (name)->
                {System.out.println("香港演员"+name);}
                );
    }

    public void consumerSomething(String name, Consumer<String> consumer){
        consumer.accept(name);
    }

}
