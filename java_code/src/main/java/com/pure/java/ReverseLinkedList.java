package com.pure.java;

public class ReverseLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode reverseList(ListNode head) {
        // 2.1. Comments: Handle edge cases.
        if (head == null || head.next == null) {
            return head;
        }

        // 2.1. Comments: Initialize pointers.
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        // 2.1. Comments: Iterate through the list.
        while (current != null) {
            // 2.1. Comments: Store the next node.
            next = current.next;

            // 2.1. Comments: Reverse the current node's pointer.
            current.next = prev;

            // 2.1. Comments: Move prev to current.
            prev = current;

            // 2.1. Comments: Move current to next.
            current = next;
        }

        // 2.1. Comments: Return the new head of the reversed list.
        return prev;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.print("Test 1 (Original): ");
        printList(head1);
        ListNode reversedHead1 = reverseList(head1);
        System.out.print("Test 1 (Reversed): ");
        printList(reversedHead1); // Expected output: 5 4 3 2 1

        // Test case 2: 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.print("Test 2 (Original): ");
        printList(head2);
        ListNode reversedHead2 = reverseList(head2);
        System.out.print("Test 2 (Reversed): ");
        printList(reversedHead2); // Expected output: 2 1

        // Test case 3: 1
        ListNode head3 = new ListNode(1);
        System.out.print("Test 3 (Original): ");
        printList(head3);
        ListNode reversedHead3 = reverseList(head3);
        System.out.print("Test 3 (Reversed): ");
        printList(reversedHead3); // Expected output: 1

        // Test case 4: null
        System.out.print("Test 4 (Original): ");
        printList(null);
        ListNode reversedHead4 = reverseList(null);
        System.out.print("Test 4 (Reversed): ");
        printList(reversedHead4); // Expected output:
    }
}
