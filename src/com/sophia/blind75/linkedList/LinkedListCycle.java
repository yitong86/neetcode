package com.sophia.blind75.linkedList;



/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //start a slow pointer and fast pointer
        ListNode fast = head;
        ListNode slow = head;

        //advance both pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //if they meet, means we found a loop
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}