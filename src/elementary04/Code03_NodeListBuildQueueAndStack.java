package elementary04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @PROJECT:
 * @DESCRIPTION:
 * @USER: Elizabeth
 * @DATE: 2023/2/4 16:34
 */
public class Code03_NodeListBuildQueueAndStack {
    public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V data) {
            value = data;
            next = null;
        }
    }

    public static class MyQueue<V> {
        public Node<V> head;
        public Node<V> tail;
        public int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public Boolean isEmpty() {
            return size == 0;
        }
        public int size(){
            return size;
        }
        public void offer(V value){
            Node<V> node = new Node<V>(value);
            if (tail == null){
                head = node;
                tail = node;
            }else {
                tail.next = node;
                tail = node;
            }
            size++;
        }
        public V popNode(){
            V ans = null;
            if (head != null){
                ans = head.value;
                head = head.next;
                size--;
            }
            if (head == null){
                tail = null;
            }
//            else {
//                tail = null;
//            }
            return ans;
        }

        public V peekNode(){
            V ans = null;
            if (head != null ){
                ans = head.value;
            }
            return ans;
        }
    }

    public static class MyStack<V>{

        public Node<V> head;
        public int size;

        public MyStack() {
            head = null;
            size = 0;
        }

        public Boolean isEmpty() {
            return size == 0;
        }
        public int size(){
            return size;
        }

        public void push(V value){
            Node<V> node = new Node<V>(value);
            if (head == null){
                head = node;
            }else {
                node.next = head;
                head = node;
            }
            size++;
        }

        public V pop(){
            V ans = null;
            if (head != null){
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }
        public V peek() {
            return head != null ? head.value : null;
        }
    }


    public static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myQueue.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myQueue.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueue.offer(num);
                test.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.popNode();
                    int num2 = test.poll();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.peekNode();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myQueue.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myQueue.isEmpty()) {
            int num1 = myQueue.popNode();
            int num2 = test.poll();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }


    public static void testStack() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myStack.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myStack.push(num);
                test.push(num);
            } else if (decide < 0.66) {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.pop();
                    int num2 = test.pop();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myStack.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myStack.isEmpty()) {
            int num1 = myStack.pop();
            int num2 = test.pop();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    // for test
    public static void main(String[] args) {
//        MyQueue<Integer> queue = new MyQueue<>();
//
//        for (int i = 0; i < 20; i++){
//            queue.offer(i);
//        }
//
//        while (queue.head!= null){
//            System.out.println(queue.popNode());
//        }
//        System.out.println(queue.popNode());
//        System.out.println("finish!");

//        testQueue();
        testStack();
    }

}
