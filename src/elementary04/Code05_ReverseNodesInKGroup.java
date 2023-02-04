package elementary04;

/**
 * @PROJECT: 25. K 个一组翻转链表
 * @DESCRIPTION: 单链表实现组内逆序:
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @USER: Elizabeth
 * @DATE: 2023/2/4 21:11
 */
public class Code05_ReverseNodesInKGroup {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverse(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroup(k, head);
        while(end == null){
            return head;
        }
        head = end;
        reverseKList(start, end);
        ListNode lastEnd = start;
        while(lastEnd.next != null){
            start = lastEnd.next;
            end = getKGroup(k, start);
            if (end == null){
                return head;
            }
            reverseKList(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }

        return head;
    }

    public static void reverseKList(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode next = null;

        while (start != end) {
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
        start.next = end;
    }

    // 不够K个返回null
    public static ListNode getKGroup(int k, ListNode start) {
        while(--k != 0 && start != null){
            start = start.next;
        }
        return start;
    }


}
