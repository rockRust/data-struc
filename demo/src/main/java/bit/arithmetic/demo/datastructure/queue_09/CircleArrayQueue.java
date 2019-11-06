package bit.arithmetic.demo.datastructure.queue_09;

/**
 * create at:  2019-11-06  11:43
 *
 * @author : js
 * @description: 循环数组队列
 */
public class CircleArrayQueue {

    private int head;
    private int tail;
    private int size;

    private static int[] arrayQueue;

    public CircleArrayQueue(int size) {
        this.size = size;
        arrayQueue = new int[size];
    }

    public boolean enqueue(int data) {
        if ((tail + 1) % size == head) return false;
        arrayQueue[tail] = data;
        tail = (tail + 1) % size;
        return true;
    }

    public int dequeue() {
        if (head == tail) return -1;
        int value = arrayQueue[head];
        head = (head + 1) % size;
        return value;
    }

    public static void main(String[] args) {
        CircleArrayQueue circle = new CircleArrayQueue(4);
        circle.enqueue(1);
        circle.enqueue(2);
        System.out.println(circle.dequeue());
        System.out.println(circle.dequeue());
        circle.enqueue(3);
        circle.enqueue(4);
        circle.enqueue(5);
        circle.enqueue(6);



    }
}
