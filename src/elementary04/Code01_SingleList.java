package elementary04;


import java.util.ArrayList;
import java.util.List;

/**
 * @PROJECT: 单链表的构建、反转、测试
 * @DESCRIPTION:
 * @USER: Elizabeth
 * @DATE: 2023/1/29 15:56
 */
public class Code01_SingleList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // for test
    public static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }

    // for test
    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    // for test
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    // for test
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // for test
    public static void main(String[] args) {

//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        node1.next = node2;
//        node2.next = node3;
//        Node head = reverseLinkedList(node1);
//        System.out.println(head.value);

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node = reverseLinkedList(node);

        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }


//        int len = 50;
//        int value = 100;
//        int testTime = 100000;
//        System.out.println("test begin!");
//        for (int i = 0; i < testTime; i++) {
//            Node node1 = generateRandomLinkedList(len, value);
//            List<Integer> list1 = getLinkedListOriginOrder(node1);
//            node1 = reverseLinkedList(node1);
//            if (!checkLinkedListReverse(list1, node1)) {
//                System.out.println("Oops1!");
//            }
//
//            Node node2 = generateRandomLinkedList(len, value);
//            List<Integer> list2 = getLinkedListOriginOrder(node2);
//            node2 = testReverseLinkedList(node2);
//            if (!checkLinkedListReverse(list2, node2)) {
//                System.out.println("Oops2!");
//            }

//            DoubleNode node3 = generateRandomDoubleList(len, value);
//            List<Integer> list3 = getDoubleListOriginOrder(node3);
//            node3 = reverseDoubleList(node3);
//            if (!checkDoubleListReverse(list3, node3)) {
//                System.out.println("Oops3!");
//            }
//
//            DoubleNode node4 = generateRandomDoubleList(len, value);
//            List<Integer> list4 = getDoubleListOriginOrder(node4);
//            node4 = reverseDoubleList(node4);
//            if (!checkDoubleListReverse(list4, node4)) {
//                System.out.println("Oops4!");
//            }
//
//        }
        System.out.println("test finish");


    }


}
