package elementary06;

/**
 * @author ：Juli
 * @date ： 2023/2/6 6:26 PM
 * @description：100.判断两棵树是否完全相等
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code03_SameTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static boolean isSameTree(Node p, Node q){

        if (p == null ^ q==null){
            return false;
        }
        if (p == null && q == null){
            return true;
        }
        return p.value == q.value && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
