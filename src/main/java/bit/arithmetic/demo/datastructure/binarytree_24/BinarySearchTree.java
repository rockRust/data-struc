package bit.arithmetic.demo.datastructure.binarytree_24;

import javax.naming.NameNotFoundException;

/**
 * create at:  2019-11-19  15:54
 *
 * @author : js
 * @description: 二叉查找树
 */
public class BinarySearchTree {

    public Node head;

    /**
     * 查找
     *
     * @param value
     * @return
     */
    public Node search(int value, Node node) {
        Node point = head;
        if (value == point.data || point == null) return point;
        if (value > point.data) point = point.right;
        if (value < point.data) point = point.left;

        return search(value, point);
    }

    /**
     * 插入
     *
     * @param value
     */
    public void insert(int value, Node top) {
        if (top == null) {
            top = new Node(value);
            return;
        }
        Node point = top;
        if (value > point.data) {
            if (point.right == null) {
                Node nNode = new Node(value);
                point.right = nNode;
            } else {
                insert(value, point.right);
            }
        }

        if (value < point.data) {
            if (point.left == null) {
                Node nNode = new Node(value);
                point.left = nNode;
            } else {
                insert(value, point.left);
            }
        }

    }

    /**
     * 删除
     *
     * @param value
     */
    public void delete(int value) {
        //先找到这个节点，还要记录下父节点
    }


    /**
     * 计算深度
     *
     * @param top
     * @return
     */
    public int calcDepth(Node top) {
        return -1;
    }

    public class Node {
        public int data;
        private Node left;
        private Node right;

        public Node(int value) {
            data = value;
        }

    }
}
