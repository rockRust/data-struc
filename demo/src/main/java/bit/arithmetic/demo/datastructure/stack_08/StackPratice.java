package bit.arithmetic.demo.datastructure.stack_08;

/**
 * create at:  2019-11-05  14:18
 *
 * @author : js
 * @description: 基于链表实现的栈
 */
public class StackPratice {

    private Node head = null;

    public int pop() {
        if (head == null) return -1;
        int value = head.data;
        head = head.next;
        return value;
    }

    public void push(int data) {
        Node list = new Node(data, head);
        head = list;
//        Node newNode = new Node(data, null);
//        // 判断是否栈空
//        if (head == null) {
//            head = newNode;
//        } else {
//            newNode.next = head;
//            head = newNode;
//        }
    }


    public class Node {
        private int data;
        private Node next;

        public Node(int data, Node list) {
            this.data = data;
            this.next = list;
        }
    }

    public String print() {
        Node point = head;
        String value = new String();
        while (point != null) {
            value += point.data + ",";
            point = point.next;
        }
        return value;
    }

    public static void main(String[] args) {
        StackPratice stackPratice = new StackPratice();
        stackPratice.push(1);
        stackPratice.push(2);
        stackPratice.push(3);
        System.out.println(stackPratice.print());
        System.out.println(stackPratice.pop());
        System.out.println(stackPratice.pop());
        System.out.println(stackPratice.pop());
    }
}
