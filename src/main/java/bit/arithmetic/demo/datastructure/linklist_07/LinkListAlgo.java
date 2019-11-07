package bit.arithmetic.demo.datastructure.linklist_07;

/**
 * create at:  2019-11-04  16:43
 *
 * @author : js
 * @description:
 */
public class LinkListAlgo {
    static {

    }

    /**
     * 单链表的反转
     */
    public static Node reserve(Node list) {
        Node curr, pre = null;
        curr = list;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return list;
    }

    /**
     * 链表中环的的检测
     */
    public static boolean checkCircle(Node list) {
        if (list == null) return false;
        Node slow, fast = list;
        while (fast != null && fast.next != null) {
            slow = list.next;
            fast = list.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 两个有序的链表合并
     */
    private static Node mergeTwoLists(Node list1, Node list2) {
        Node solider = new Node(0, null);
        Node point = solider;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                point.next = list1;
                list1 = list1.next;
            } else {
                point.next = list2;
                list2 = list2.next;
            }
            point = point.next;
        }
        if (list1 != null) {
            point.next = list1;
        }
        if (list2 != null) {
            point.next = list2;
        }
        return solider.next;
    }

    /**
     * 删除倒数第K个结点
     */
    public static Node deleteLastKth(Node list, int k) {
        //一快一慢指针
        Node fast = list;
        int i = 1;
        while (i < k) {
            fast = fast.next;
            if (fast == null) {
                return list;
            }
            i++;
        }
        Node slow = list;
        Node prev = list;
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = list.next;
        }
        prev.next = prev.next.next;
        return list;
    }

    /**
     * 求链表的中间节点
     */
    public static Node findMiddleNode(Node list) {
        if (list == null) return null;
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static class Node {
        private int data;
        public Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }


    }

    public static void main(String[] args) {
        Node list1 = new Node(1, new Node(3, null));
        Node list2 = new Node(2, new Node(4, null));
        Node node = mergeTwoLists(list1, list2);
        System.out.println("-------" + node.data);

//        Node node1 = deleteLastKth(node, 3);
//        System.out.println(node1);
        Node middleNode = findMiddleNode(node);
        System.out.println(middleNode);

    }
}
