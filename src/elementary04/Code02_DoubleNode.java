package elementary04;


/**
 * @PROJECT: 双链表的构建、反转、测试
 * @DESCRIPTION:
 * @USER: Elizabeth
 * @DATE: 2023/2/4 15:51
 */
public class Code02_DoubleNode {

    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data){
            value = data;
        }
    }

    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head!= null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    // for test
    public static void main(String[] args) {

        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode1 = new DoubleNode(1);
        doubleNode1.next = doubleNode2;
        doubleNode2.next = new DoubleNode(3);
        doubleNode1 = reverseDoubleList(doubleNode1);

        while(doubleNode1 != null){
            System.out.println(doubleNode1.value);
            doubleNode1 = doubleNode1.next;
        }

        System.out.println("test finish!");

    }
}
