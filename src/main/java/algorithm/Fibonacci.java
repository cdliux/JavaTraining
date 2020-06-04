package algorithm;

/**
 * @author ll0a
 * @version V1.0
 * @className: Fibonacci
 * @date 5/30/2020 1:48 PM
 * @description:
 */
public class Fibonacci {
    public static int getFibonacci(int num) {
        if (num <= 0) {
            return 0;
        }
        if (num == 1 || num == 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int third = 0;
        for (int n = 3; n <= num; n++) {
            third = first + second;
            first = second;
            second = third;
        }
        System.out.println(third);
        return third;
    }
    public static int getFibonacci2(int num) {
        if (num <= 1) {
            return 0;
        }
        if (num == 2 || num == 3) {
            return 1;
        }
        int third = getFibonacci2(num - 2) + getFibonacci2(num - 1);
        System.out.println(third);
        return third;
    }
}
