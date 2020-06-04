import JavaBasic.*;
import algorithm.Fibonacci;
import com.fasterxml.jackson.core.JsonProcessingException;
import pojo.Seller;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author ll0a
 * @version V1.0
 * @className: Application
 * @date 5/12/2020 2:29 PM
 * @description:
 */
public class Application {
    public static void main(String[] args) throws JsonProcessingException, ParseException, InterruptedException, CloneNotSupportedException {



        // System.out.println(Math.round(2.6));
        // Fibonacci.getFibonacci2(10);
        // final Seller a = new Seller("lewis", "a", "sa");
        // Seller a2 = new Seller("lewis", "a", "sa");
        // ArrayList<String> la = new ArrayList<>();
        // HashMap ma = new HashMap();
        // HashSet<Seller> sa = new HashSet();
        //
        //
        // JavaBigDecimal bigDecimal = new JavaBigDecimal();
        // bigDecimal.process();
        // JavaBigInteger bigInteger = new JavaBigInteger();
        // bigInteger.process();
        // BoxAndUnBox boxAndUnBox = new BoxAndUnBox();
        // boxAndUnBox.process();
        // JavaJsonProcess jsonProcess = new JavaJsonProcess();
        // jsonProcess.process();
        // JavaObject javaObject = new JavaObject();
        // javaObject.process();
        //
        // ObjectRelive.invokeObjectRealive();

        System.out.print("Xmx =");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");

        System.out.print("free mem =");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");

        System.out.print("total mem =");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
    }



    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }

    public static int getInt() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            System.out.println("catch a:" + a);
            return a;
            /*
             * return a 在程序执行到这一步的时候，这里不是return a 而是 return 30；这个返回路径就形成了
             * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的路径,继续走return 30，形成返回路径之后，这里的a就不是a变量了，而是常量30
             */
        } finally {
            a = 40;
            System.out.println("finally a:" + a);
            // return a; //如果这样，就又重新形成了一条返回路径，由于只能通过1个return返回，所以这里直接返回40
        }

     return a;
    }
}
