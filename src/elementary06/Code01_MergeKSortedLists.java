package elementary06;

import javax.swing.text.html.HTMLWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ：Juli
 * @date ： 2023/2/6 5:31 PM
 * @description：23：合并k个升序链表
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code01_MergeKSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static class ListNodeCompatator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeCompatator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
            pre = cur;
        }
        return head;
    }
}
