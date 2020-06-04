package JavaBasic;

import java.math.BigDecimal;

/**
 * @author ll0a
 * @version V1.0
 * @className: BoxAndUnBox
 * @date 5/12/2020 2:35 PM
 * @description:
 */
public class BoxAndUnBox {

    public void process(){
        System.out.println("Java 中 == 和 equals() 的区别");
        testTwoEquals();

        System.out.print("------------------------------\n");
        System.out.println("Java Integer 类型的比较");
        testInteger();
        testBoxAndUnBox();
    }

    private void testTwoEquals() {
        int i1 = 333;
        int i2 = 333;
        System.out.println("i1 == i2 -> " + (i1 == i2));

        float f1 = 0.3f;
        float f2 = 0.3f;
        System.out.println("f1 == f2 -> " + (f1 == f2));

        String str1 = new String("hello");
        String str2 = new String("hello");

        //对 String 使用 == 直接对比的引用，String 的 equals 对比的是值
        System.out.println("str1 == str2 -> " + (str1 == str2));
        System.out.println("str1.equals(str2) -> " + (str1.equals(str2)));

        String str3 = new String("no hello");
        str1 = str3;
        str2 = str3;
        System.out.println("str1 == str2 -> " + (str1 == str2));

        Long l1 = 564L;
        Integer i3 = 564;
        System.out.println("l1 == i3 -> " + (l1.equals(i3)));

        Integer i4 = 564;
        Integer i5 = 564;
        System.out.println("i4.equals(i5) -> " + (i4.equals(i5)));
    }

    private void testInteger() {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println("提示：包装类型间的相等判断应该用equals，而不是'=='，此处是测试代码使用。");
        System.out.println("i1.equals(i2) -> " + (i1 == i2));
        System.out.println("i1 == i2 -> " + (i1.equals(i2)));
        System.out.println("i3 == i4 -> " + (i3 == i4));
        System.out.println("i3.equals(i4) -> " + (i3.equals(i4)));
        System.out.println("提示：Integer 初始化时针对范围在 -128 到 127 的数会直接从 IntegerCache.cache 中取用，所以引用是相同的。");
        Integer.valueOf(1);
    }

    private void testBoxAndUnBox() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(g.equals(a + h));
    }
}
