/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class Node<T> {

    T info;
    Node next;

    public Node() {
    }

    public Node(T info) {
        this.info = info;
        this.next = null;
    }

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }

    //Overriding to convert this node to String
    @Override
    public String toString() {
        return " ";
    }
}
