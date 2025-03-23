package com.pure.java;

class MergeTwoLists {
    /**
     * Merges two sorted linked lists.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Handle empty lists.
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // Initialize dummy node and current node.
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge lists.
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // Append node from list1
                list1 = list1.next; // Move list1 pointer
            } else {
                current.next = list2; // Append node from list2
                list2 = list2.next; // Move list2 pointer
            }
            current = current.next; // Move current pointer
        }

        // Append remaining nodes.
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return merged list.
        return dummy.next;
    }

    // ListNode class (for testing).
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                sb.append(current.val).append(" -> ");
                current = current.next;
            }
            sb.append("null");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        MergeTwoLists solution = new MergeTwoLists();

        // Example 1:
        ListNode list1_1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2_1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("Example 1: " + solution.mergeTwoLists(list1_1, list2_1)); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null

        // Example 2:
        ListNode list1_2 = null;
        ListNode list2_2 = null;
        System.out.println("Example 2: " + solution.mergeTwoLists(list1_2, list2_2)); // Output: null

        // Example 3:
        ListNode list1_3 = null;
        ListNode list2_3 = new ListNode(0);
        System.out.println("Example 3: " + solution.mergeTwoLists(list1_3, list2_3)); // Output: 0 -> null

        // Example 4:
        ListNode list1_4 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2_4 = new ListNode(2, new ListNode(4, new ListNode(6)));
        System.out.println("Example 4: " + solution.mergeTwoLists(list1_4, list2_4)); // Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

        // Example 5:
        ListNode list1_5 = new ListNode(5);
        ListNode list2_5 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("Example 5: " + solution.mergeTwoLists(list1_5, list2_5)); // Output: 1 -> 2 -> 3 -> 4 -> 5 -> null

        // Example 6:
        ListNode list1_6 = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode list2_6 = new ListNode(1, new ListNode(1, new ListNode(1)));
        System.out.println("Example 6: " + solution.mergeTwoLists(list1_6, list2_6)); // Output: 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> null
    }
}
