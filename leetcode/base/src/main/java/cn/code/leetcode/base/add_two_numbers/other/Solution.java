package cn.code.leetcode.base.add_two_numbers.other;


/**
 * @author: leihang@live.cn
 * @date: 2016-09-30 16:52
 * @description:
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
        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        int sum = 0;
        while (true) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.val = sum % 10;
            sum /= 10;

            if (l1 != null || l2 != null || sum != 0) {
                cur = (cur.next = new ListNode(0));
            } else {
                break;
            }

        }

        return ret;
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
