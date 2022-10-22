/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class MyQueue<T> {

    Node<T> head;
    Node<T> tail;

    public boolean isEmpty() {
        return (head == null);
    }

    T front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return (head.info);
    }

    public T dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        T x = head.info;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return (x);
    }

    void enqueue(T x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }
}
