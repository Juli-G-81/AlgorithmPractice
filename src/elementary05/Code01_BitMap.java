package elementary05;

import class05.Code01_BitMap1;

import java.util.HashSet;

/**
 * @author ：Juli
 * @date ： 2023/2/6 1:45 PM
 * @description：单个位图的增、删、查
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code01_BitMap {

    public static class BitMap {

        private long[] bits;

        public BitMap(int max) {
            // (max + 64) >> 6  --->  (max + 64) / 64
            // num右移n位  等同于  num除以(2的n次方)
            bits = new long[(max+64) >> 6];
        }

        public void add(int num) {
            // 1L 和 1 的区别在于，如果此处写的是 (1 << (num & 63)) 会被当作 (int)1左移
            // 但是 (int)1 只有32位，一定会报错
            // num & 63  --->  num % 64   与运算 比 模运算 效率高
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        System.out.println((2 + 64) >> 6);

        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

}
