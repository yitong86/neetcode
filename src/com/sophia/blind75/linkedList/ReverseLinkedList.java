package com.sophia.blind75.linkedList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;value
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
//base case
        if(head == null) return null;
//defin curr and pre

            ListNode prev = null;
            //while cur is nor null, continue to traverse list
            while(head != null){


                // prev->head->next_node
                // null->1   -> 2->     3->4
                //null<-pre<-head
                //null-1-2
//                  null <-1<-2
                //head.next = 1
                //
                ListNode next_node = head.next;
               head.next = prev;//null
               prev=head;//1
               head = next_node;//2
            }
            return prev;
    }
}
