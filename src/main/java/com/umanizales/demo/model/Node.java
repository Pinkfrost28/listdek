package com.umanizales.demo.model;


import lombok.Data;

@Data
public class Node {
    private Boy data;
    private Node next;
    private Node previous;

    public Node(Boy data) {
        this.data = data;
    }
}
