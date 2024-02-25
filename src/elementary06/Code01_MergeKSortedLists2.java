package elementary06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ：Juli
 * @date ： 2024/2/26 00:15
 * @description：
 * @modifiedBy ：
 * @version:
 */
public class Code01_MergeKSortedLists2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKListsSolution2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());

        // 初始化优先队列，将每个链表的头节点加入队列
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }

        // 使用一个哑节点(dummy)来简化头节点的处理
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll(); // 取出当前最小节点
            tail.next = minNode; // 将最小节点连接到结果链表
            tail = minNode; // 更新尾节点

            if (minNode.next != null) {
                heap.add(minNode.next); // 将最小节点的下一个节点加入优先队列
            }
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}

