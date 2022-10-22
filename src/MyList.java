/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class MyList<T> {

    Node<T> head;
    Node<T> tail;

    public MyList() {
        this.head = null;
        this.tail = null;
    }

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int length() {
        int length = 0;
        Node<T> current = this.head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     *
     * @param item
     */
    public void insertToHead(T item) {
        Node<T> newNode = new Node(item, head);
        head = newNode;
    }

    public void insertAfterPosition(int position, T item) {
        int i = 0;
        Node<T> current = this.head;
        while (current.next != null) {
            if (i == position) {
                Node<T> newNode;
                newNode = new Node(item, current.next);
                current.next = newNode;
                break;
            }
            current = current.next;
            i++;

        }
    }

    void addHead(T obj) {
        Node newNode = new Node(obj, null);
        if (this.head == null) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    // thêm một phần tử vào cuối danh sách
    void addTail(T obj) {
        Node newNode = new Node(obj, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void deleteElement(T item) {
        if (item == head.info) {
            head = head.next;
        } else {
            Node current = head;
            while (current.next != null) {
                if (current.next.info == item) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
            if (current.info == item) {
                current = null;
                tail = current;
            }
        }
    }

    /**
     *
     * @param firstNode
     * @param secondNode
     */
    public void swap(Node<T> firstNode, Node<T> secondNode) {
        T p = firstNode.info;
        firstNode.info = secondNode.info;
        secondNode.info = p;
    }

    public void clear() {
        head = null;
        tail = null;
    }
}
