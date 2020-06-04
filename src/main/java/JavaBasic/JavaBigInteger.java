package JavaBasic;

import java.math.BigInteger;

public class JavaBigInteger {
    public void process() {
        System.out.println("Java 中 long 的极值\n");
        printMaxLongValue();

        System.out.print("------------------------------\n");
        System.out.println("BigInteger 转为 long\n");
        convertBigIntegerToLong();

        System.out.print("------------------------------\n");
        System.out.println("BigInteger 转为 float\n");
        convertBigIntegerToFloat();
    }

    /**
     * Java 中 long 类型数的极值，64位
     */
    private void printMaxLongValue() {
        System.out.println("long 的极大值: " + Long.MAX_VALUE);
        System.out.println("long 的极小值: " + Long.MIN_VALUE);
    }

    private void convertBigIntegerToLong() {
        BigInteger num1 = new BigInteger("9223372036854775807");
        BigInteger num2 = num1.add(num1);
        System.out.println(num1.longValue());
    }

    /**
     * BigInteger 转为 float 溢出
     */
    private void convertBigIntegerToFloat() {
        BigInteger n = new BigInteger("999999").pow(99);
        float f = n.floatValue();
        System.out.println(f);
    }
}
