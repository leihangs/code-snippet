package cn.code.leetcode.base.add_two_numbers;


/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a2.next = a3;
        a1.next = a2;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b2.next = b3;
        b1.next = b2;
        Solution solution = new Solution();
        ListNode c = solution.addTwoNumbers(a1, b1);
        System.out.println("result:" + c.toString());

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int xx = l1.val + l2.val;
        int last = 0;
        int end;
        if (xx > 9) {
            last = 1;
            end = xx - 10;
        } else {
            end = xx;
        }
        ListNode thisNode = new ListNode(end);
        if (l1.next != null) {
            thisNode.next = getNext(l1.next, l2.next, last);
        }
        return thisNode;
    }

    public ListNode getNext(ListNode l1, ListNode l2, int num) {
        int xx = l1.val + l2.val + num;
        int last = 0;
        int end;
        if (xx > 9) {
            last = 1;
            end = xx - 10;
        } else {
            end = xx;
        }
        ListNode thisNode = new ListNode(end);
        if (l1.next != null) {
            thisNode.next = getNext(l1.next, l2.next, last);
        }
        return thisNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String s = val + "";
            if (this.next != null) {
                s = s + "-->" + this.next.toString();
            }
            return s;
        }
    }
}