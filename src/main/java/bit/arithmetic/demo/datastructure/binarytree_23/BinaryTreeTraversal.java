package bit.arithmetic.demo.datastructure.binarytree_23;

/**
 * create at:  2019-11-15  11:36
 *
 * @author : js
 * @description:
 */
public class BinaryTreeTraversal {
    /**
     * 二叉树遍历：前中后序遍历
     * <p>
     * 卡特兰数：给定指定的节点，求解有多少种二叉树
     */
    public void preTraversal(Node top) {
        if (top == null) return;
        System.out.println(top.data);
        preTraversal(top.left);
        preTraversal(top.right);
    }

    public void midTraversal(Node top) {
        if (top == null) return;
        midTraversal(top.left);
        System.out.println(top.data);
        midTraversal(top.right);
    }

    public void afterTraversal(Node top) {
        if (top == null) return;
        afterTraversal(top.left);
        afterTraversal(top.right);
        System.out.println(top.data);
    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int value) {
            data = value;
        }
    }

    public static void main(String[] args) {
        Node top = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        top.left = left;
        top.right = right;
        Node left1 = new Node(4);
        Node left2 = new Node(5);
        left.left = left1;
        left.right = left2;
        Node right1 = new Node(6);
        Node right2 = new Node(7);
        right.left = right1;
        right.right = right2;
        BinaryTreeTraversal b = new BinaryTreeTraversal();
        b.preTraversal(top);
        System.out.println("---------");
        b.midTraversal(top);
        System.out.println("---------");
        b.afterTraversal(top);
    }
}
