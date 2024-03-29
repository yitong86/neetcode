package com.sophia.blind75.linkedList;


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node,Node> mp = new HashMap<>();
        Node curr = head;

        while(curr!=null){
            Node temp = new Node(curr.val);
            mp.put(curr,temp);
            curr = curr.next;
        }

        curr = head;
        while(curr!=null){
            Node temp = mp.get(curr);
            temp.next = mp.get(curr.next);
            temp.random = mp.get(curr.random);
            curr = curr.next;
        }

        return mp.get(head);
    }
}