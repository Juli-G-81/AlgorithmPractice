package elementary04;

import class04.Code05_AddTwoNumbers;

/**
 * @author ：Juli
 * @date ： 2023/2/5 9:29 PM
 * @description：两个链表对应位置数值相加
 * 给定两个链表的头节点head1和head2. 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 * 例子 4 ->3 ->6 2 -> 5 -> 3
 * 返回 6->8->9
 * 解释 634 +352 = 986
 * @modifiedBy ：
 * @version: 1.0
 */
public class Code06_AddTwoNumList {
    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoListNums(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        ListNode headL = len1 >= len2 ? l1 : l2;
        ListNode s = headL == l1 ? l2 : l1;
        ListNode curL = headL;
        ListNode curS = s;
        ListNode last = curL;
        int carry = 0;
        int curNum = 0;
        // 第一阶段 L有 S有
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            curL.val = (curNum % 10);
            carry = (curNum / 10);
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        // 第二阶段 L有 S没有
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        // 第三阶段 L没有 S没有
        if (carry != 0) {
            last.next = new ListNode(carry);
        }
        return headL;
    }

    public static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(7);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(2);

        ListNode addTwoListNums = addTwoListNums(listNode1, listNode2);
        while (addTwoListNums != null){
            System.out.println(addTwoListNums.val);
            addTwoListNums = addTwoListNums.next;
        }
    }
}
