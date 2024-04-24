public class Leetcode {


//    Definition for singly-linked list.
     public static class ListNode {
          int val;
          ListNode next;

          ListNode() {}

          ListNode(int val) { this.val = val; }

          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }



    class Solution {
         ListNode head;

        public ListNode reverseList(ListNode head) {
            ListNode prevNode = null;
            ListNode currentNode = head;
            ListNode nextNode = null;

            while(currentNode != null) {
                nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
            }
            return prevNode;
        }

        public Solution(ListNode head) {
            this.head = head;
        }
    }

    Leetcode(){
        System.out.println();
    }
}
