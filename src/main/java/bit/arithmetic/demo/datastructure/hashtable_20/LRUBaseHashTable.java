package bit.arithmetic.demo.datastructure.hashtable_20;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * create at:  2019-11-14  11:19
 *
 * @author : js
 * @description: 基于hash及链表的LRU算法
 */
public class LRUBaseHashTable<K, V> {

    private final static int INIT_CAPACITY = 10;

    private int capacity;

    private int size;

    private Map<K, Node<K, V>> table = new Hashtable();

    private Node head;

    private Node tail;

    public LRUBaseHashTable(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public LRUBaseHashTable() {
        this(INIT_CAPACITY);
    }

    public V select(K key) {
        //找到需要将此值挪到头部
        Node<K, V> node = table.get(key);
        if (node == null) return null;
        V value = node.value;
        deleteNode(node);
        moveToFirst(node);
        return value;
    }

    public void add(K key, V value) {
        Node<K, V> kNode = table.get(key);
        if (kNode == null) {
            Node<K, V> newNode = new Node(key, value);
            if (++size >= capacity) {
                //删掉尾部的node
                deleteNode(tail.prev);
                table.remove(tail.prev.key);
                --size;
            }
            table.put(key, newNode);
            moveToFirst(newNode);
        } else {
            kNode.value = value;
            moveToFirst(kNode);
        }
    }

    private void deleteNode(Node node) {
        if (node == null) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFirst(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public class Node<K, V> {
        public K key;
        public V value;
        public Node prev;
        public Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();
    }
}
