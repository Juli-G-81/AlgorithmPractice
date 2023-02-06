package elementary06;

/**
 * @author ：Juli
 * @date ： 2023/2/6 6:40 PM
 * @description：判断一棵树是否是镜面树
 * @modifiedBy ：
 * @version: 1.0.0
 */
public class Code04_SymmetricTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static boolean isSymmetricTree(Node root){
        return isMirror(root, root);
    }

    public static boolean isMirror(Node p, Node q){
        if (p == null ^ q==null){
            return false;
        }
        if (p == null && q == null){
            return true;
        }

        return p.value == q.value && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}
