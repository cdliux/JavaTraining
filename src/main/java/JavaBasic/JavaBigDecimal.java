package JavaBasic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class JavaBigDecimal {


    public void process() {

        System.out.println("Java 中不精确的数值计算\n");
        inaccurateCalculation();

        System.out.print("------------------------------\n");
        System.out.println("Java BigDecimal 的 3 种构造方式\n");
        useBigDecimalConstuctor();

        System.out.print("------------------------------\n");
        System.out.println("Java BigDecimal 如何正确构造源为 Double 类型的数据\n");
        converDoubleToStringWhenUseBigDecimal();

        System.out.print("------------------------------\n");
        bigDecimalOpration();

        System.out.print("------------------------------\n");
        System.out.println("Java BigDecimal 获取小数位数\n");
        useScaleInBigDecimal();


        System.out.print("------------------------------\n");
        System.out.println("Java BigDecimal 使用 StripTrailingZeros 去掉尾部的0\n");
        useStripTrailingZeros();

        System.out.print("------------------------------\n");
        System.out.println("Java BigDecimal 的除法运算的正确使用\n");
        useBigDecimalDivideCorrectly();


        System.out.print("------------------------------\n");
        System.out.println("Java BigDecimal 如何正取比较两个 BigDecimal\n");
        compareTwoBigDecimal();

        // testSetScale();
    }


    /**
     * Java 中不精确的数值计算
     */
    private void inaccurateCalculation() {
        System.out.print("0.2 + 0.1 = ");
        System.out.println(0.2 + 0.1);
        System.out.print("0.2 - 0.1 = ");
        System.out.println(0.3 - 0.1);
        System.out.print("0.2 * 0.1 = ");
        System.out.println(0.2 * 0.1);
        System.out.print("0.3 / 0.1 = ");
        System.out.println(0.3 / 0.1);
    }

    /**
     * 正确使用 BigDecimal 的构造函数
     */
    private void useBigDecimalConstuctor() {
        int intvalue = 3;
        double doubleValue = 3.3;
        String stringValue = "3.3";
        BigDecimal decimalInt = new BigDecimal(intvalue);
        BigDecimal decimalDouble = new BigDecimal(doubleValue);
        BigDecimal decimalString = new BigDecimal(stringValue);

        System.out.println("new BigDecimal(intvalue) => " + decimalInt);
        System.out.println("new BigDecimal(doubleValue) => " + decimalDouble);
        System.out.println("new BigDecimal(stringValue) => " + decimalString);
    }

    /**
     * 如何正确构造源为 Double 类型的数据,将 Double 值转为 String
     */
    private void converDoubleToStringWhenUseBigDecimal() {
        double doubleValue = 3.3;

        BigDecimal decimalDouble1 = new BigDecimal(doubleValue);
        BigDecimal decimalDouble2 = new BigDecimal(String.valueOf(doubleValue));
        BigDecimal decimalDouble3 = new BigDecimal(Double.toString(doubleValue));
        BigDecimal decimalDouble4 = BigDecimal.valueOf(doubleValue);

        System.out.println("doubleValue: " + doubleValue);
        System.out.println("new BigDecimal(doubleValue) => " + decimalDouble1);
        System.out.println("new BigDecimal(String.valueOf(doubleValue)) => " + decimalDouble2);
        System.out.println("new BigDecimal(Double.toString(doubleValue)) => " + decimalDouble3);
        System.out.println("BigDecimal.valueOf(doubleValue) => " + decimalDouble4);
    }

    /**
     * BigDecimal 的四则运算，请使用对应的方法而不是操作符
     * 注意：除法运算无法除尽时会产生异常
     */
    private void bigDecimalOpration() {
        BigDecimal oprator1 = new BigDecimal("4.5");
        BigDecimal oprator2 = new BigDecimal("1.3");

        BigDecimal addResult = oprator1.add(oprator2);
        BigDecimal subResult = oprator1.subtract(oprator2);
        BigDecimal multipyResult = oprator1.multiply(oprator2);
        try {
            BigDecimal divideResult = oprator1.divide(oprator2);
            System.out.println("4.5 / 1.3 = " + divideResult);
        } catch (Exception ex) {
            System.out.println("4.5 / 1.3 = " + ex.getMessage());
        }

        System.out.println("4.5 + 1.3 = " + addResult);
        System.out.println("4.5 - 1.3 = " + subResult);
        System.out.println("4.5 * 1.3 = " + multipyResult);
    }


    /**
     * 使用 Scale 获取小数的位数
     */
    private void useScaleInBigDecimal() {
        BigDecimal num1 = new BigDecimal("123.12");
        BigDecimal num2 = new BigDecimal("123.1200");
        BigDecimal num3 = new BigDecimal("1234");


        System.out.println("123.12 的小数位数: " + num1.scale());
        System.out.println("123.1200 的小数位数: " + num2.scale());
        System.out.println("1234 的小数位数: " + num3.scale());
    }

    /**
     * 使用 useStripTrailingZeros 去除尾部的0
     */
    private void useStripTrailingZeros() {
        BigDecimal num1 = new BigDecimal("123.1200");
        BigDecimal num2 = new BigDecimal("1231200");
        BigDecimal num3 = num1.stripTrailingZeros();
        BigDecimal num4 = num2.stripTrailingZeros();
        System.out.println("123.1200 的小数位数: " + num1.scale());
        System.out.println("1231200 的小数位数: " + num2.scale());
        System.out.println("123.1200 去掉尾部0后的小数位数: " + num3.scale());
        System.out.println("1231200 去掉尾部0后的小数位数: " + num4.scale() + ",变成了科学计数法，-2 表示是整数且尾部有 2 个 0");
    }

    /**
     * 在进行除法运算指定保留的位数和截断方式
     */
    private void useBigDecimalDivideCorrectly() {
        BigDecimal oprator1 = new BigDecimal("1");
        BigDecimal oprator2 = new BigDecimal("0.33");
        BigDecimal divideResult = oprator1.divide(oprator2, 4, RoundingMode.DOWN);
        BigDecimal divideResult2 = oprator1.divide(oprator2, 4, RoundingMode.HALF_DOWN);
        System.out.println("直接截断，1 / 3 = " + divideResult);
        System.out.println("四舍五入，1 / 3 = " + divideResult2);
    }

    /**
     * 如何正取比较两个 BigDecimal,
     * 请使用 compareTo 进行比较，返回值是 负数，正数，0，分别表示小于，大于，等于
     */
    private void compareTwoBigDecimal() {
        BigDecimal num1 = new BigDecimal("123.12");
        BigDecimal num2 = new BigDecimal("123.1200");
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("num1.equals(num2) => " + num1.equals(num2));
        System.out.println("num1.equals(num2.stripTrailingZeros()) => " + num1.equals(num2.stripTrailingZeros()));
        System.out.println("num1.compareTo(num2) => " + num1.compareTo(num2));
    }


    private  void testSetScale() {
        BigDecimal expectedUnitPrice = new BigDecimal("3.12");
        // BigDecimal discountInstant = new BigDecimal("3.12");
        BigDecimal discountInstant = null;
        BigDecimal suggestedSellingPrice = expectedUnitPrice.subtract(discountInstant).setScale(2, 1);
        System.out.println("testSetScale ->" + suggestedSellingPrice);
    }
}
