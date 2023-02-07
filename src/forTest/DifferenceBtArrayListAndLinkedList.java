package forTest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;

/**
 * @author ：Juli
 * @date ： 2023/2/7 11:41 AM
 * @description：
 * ArrayList和LinkedList的区别
 * ArrayList插入用时 442    107271
 * LinkedList插入用时 3     76
 * 因此ArrayList比LinkedList插入耗时的多，代价大。
 * ArrayList底层是数组，LinkedList底层是双向链表。
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class DifferenceBtArrayListAndLinkedList {
    public static void main(String[] args) {
        int testTime = 1000000;
        long start;
        long end;

        System.out.println("Start!");
        ArrayList<Integer> arr1 = new ArrayList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i ++){
            arr1.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        LinkedList<Integer> arr2 = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i ++){
            arr2.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }

}
