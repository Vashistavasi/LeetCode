package MergeSortLinkedList;


import java.util.List;

class Solution {
    public static void main(String[] args) {
        ListNode curr=new ListNode(4);
        ListNode temp=curr;
        curr.next=new ListNode(3);curr.next.next=new ListNode(2);
        curr.next.next.next = new ListNode(1);
        Solution s=new Solution();
        curr=s.sortList(curr);

        while (curr != null) {
            System.out.println(curr.val);
            curr=curr.next;
        }

    }
    public ListNode sortList(ListNode head) {
        if(head==null|| head.next==null)return head;
        ListNode middle=getMidde(head);
        ListNode nextMiddle=middle.next;
        middle.next=null;
        ListNode left=sortList(head );
        ListNode right=sortList(nextMiddle);
        return merge(left,right);
    }

    public ListNode getMidde(ListNode head) {
        ListNode slow, fast;
        slow = head;
        fast = head;
        while (fast!=null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode first, ListNode second) {
        ListNode ans = new ListNode(0);
        ListNode temp=ans;
        while (first != null && second != null) {
            if (first.val > second.val) {
                ans.next = new ListNode(second.val);
                second = second.next;
                ans = ans.next;
            } else {
                ans.next = new ListNode(first.val);
                first = first.next;
                ans = ans.next;
            }
        }
        while (first != null) {
            ans.next = new ListNode(first.val);
            first = first.next;
            ans = ans.next;
        }
        while (second != null) {
            ans.next = new ListNode(second.val);
            second = second.next;
            ans = ans.next;
        }
        return temp.next;
    }


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
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

}
