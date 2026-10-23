/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package riyadhmetroproject.MetroLines;

/**
 *
 * @author amany
 */
public class Node {
    Station data;
    Node next;
    Node prev;

    public Node(Station data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
