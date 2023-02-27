package org.example.leedcode.practice;

public class AddTwoNumber {
    public static void main(String[] args) {
        // 十位数
//        System.out.println(2 / 10);
//        // 个位数
//        System.out.println(2 % 10);

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println("打印l3");
        printList(l3);
    }

    public static void printList(ListNode head) {
        while (null != head) {
            System.out.println("val :" + head.val);
            head = head.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode currentNode = head;
        int nextAdd = 0;
        while (null != l1 || null != l2) {
            int a = null == l1 ? 0 : l1.val;
            int b = null == l2 ? 0 : l2.val;

            int sum = (a + b + nextAdd);
            // 个位数
            int mm = sum % 10;
            currentNode.next = new ListNode(mm);
            // 十位数
            nextAdd = sum / 10;

            currentNode = currentNode.next;
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        if (nextAdd != 0) {
            currentNode.next = new ListNode(nextAdd);
        }
        return head.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode();
        ListNode current = head;
        int sum = l1.val + l2.val;
        current.val = sum % 10;
        int carry = sum / 10;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode listNode = new ListNode();
            listNode.val = val;
            current.next = listNode;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode listNode = new ListNode();
            sum = l1.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            listNode.val = val;
            current.next = listNode;
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode listNode = new ListNode();
            sum = l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            listNode.val = val;
            current.next = listNode;
            current = current.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            ListNode listNode = new ListNode();
            listNode.val = carry;
            current.next = listNode;
            current = current.next;
        }
        return head;
    }
}
