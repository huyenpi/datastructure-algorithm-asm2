/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class MyStack<T> {

    Node<T> head;

    boolean isEmpty() {
        return (head == null);
    }

    // Hàm đẩy 1 phần tử vào stack
    void push(T x) {
        head = new Node(x, head);
    }

    // Hàm lấy 1 phần tử ra khỏi stack
    T pop() {
            T x = head.info;
            head = head.next;
            return x;
    }

    @Override
    public String toString() {
        while (!isEmpty()) {
            String st = "";
            st += this.pop();
            return st;
        }
        return null;
    }
}
