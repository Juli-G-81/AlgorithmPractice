package elementary06;

import class06.TraversalBinaryTree;

import javax.swing.undo.CannotUndoException;

/**
 * @author ：Juli
 * @date ： 2023/2/6 6:05 PM
 * @description：二叉树的先序、中序、后序遍历
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code02_BinaryTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    public static void cur(Node head){
        if (head == null) {
            return;
        }
        cur(head.left);
        System.out.println(head.value);
        cur(head.right);
    }

    public static void next(Node head){
        if (head == null) {
            return;
        }
        next(head.left);
        next(head.right);
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        cur(head);
        System.out.println("========");
        next(head);
        System.out.println("========");

    }

}
