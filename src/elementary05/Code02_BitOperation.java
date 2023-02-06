package elementary05;

/**
 * @author ：Juli
 * @date ： 2023/2/6 2:09 PM
 * @description：使用位运算进行加减乘除 解决系统最小值转绝对值
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code02_BitOperation {
    public static int add(int a, int b) {
        int sum = a;
        // 当进位信息为0时结束循环
        while (b != 0) {
            sum = a ^ b;  // 异或等同于无进位相加
            b = (a & b) << 1;  // 进位信息
            a = sum;
        }
        return sum;
    }

    public static int negNum(int num) {
        return add(~num, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multiple(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add(ans, a);
            }
            a <<= 1;
            // b >>>= 1  --->  b不带符号右移1位
            // 因为负数的最高位为1，不能带符号右移。
            b >>>= 1;
        }
        return ans;
    }

    public static boolean isNeg(int num) {
        return num < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                ans |= (1L << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(ans) : ans;
    }

    /**
     * 1) a和b都是系统最小
     * 2) b是系统最小
     * 3) a是系统最小
     * 4）a和b都不是系统最小
     **/
    public static int divide(int a, int b) {

        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)){
                return Integer.MAX_VALUE;
            }else {
                // 要算 a/b
                // (a + 1) / b = c
                // a - (b * c) = d
                // d / b = e
                // c + e

                int c = divide(add(a, 1), b);
                int d = minus(a, multiple(b, c));
                int e = div(d, b);
                return add(c, e);
            }
        }else {
            return div(a, b);
        }
    }

    // 在所有数值当中，系统最小值是没办法转的
    // b = -2147483648;
    // -b = -2147483648;

    public static void main(String[] args) {
        System.out.println(add(2, 5));
        System.out.println(minus(2, 5));
        System.out.println(multiple(2, 5));
        System.out.println(divide(-2147483648, -1));
        int a = Integer.MIN_VALUE;
        int b = -2147483648;
        System.out.println(-b);
    }
}
