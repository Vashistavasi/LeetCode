package ReverseLinkedList;
  class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public static void main(String[] args) {
        int []a={1,2};
        ListNode head=new ListNode(1);
        ListNode temp=head;
         for(int i=1;i<a.length;i++){
             temp.next=new ListNode(a[i]);
             temp=temp.next;
         }
         Solution s=new Solution();
         //head=s.reverse(head);
         head=s.reverseBetween(head,0,1);
         while(head!=null){
             System.out.print(head.val+" ");
             head=head.next;
         }
    }

public ListNode reverse(ListNode head){
        ListNode prev=null,next=null,curr=null;
        curr=head;
        next=head.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null)
            next=next.next;
        }
        return prev;
}


        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left==right)
                return head;
            int k=0;
            ListNode curr=head;
            ListNode prev=null;
            ListNode nex=null;
            ListNode end = null;
            while(k<=right && curr!=null){
                if(k==left-1 )
                prev=curr;
                if(k==right)
                    end=curr.next;
                curr=curr.next;
                k++;
            }
            if(prev!=null)
            curr=prev.next;
            else curr=head;
            ListNode st=prev;
            k=0;
            nex=curr.next;
            prev=null;
            while(k<right-left+1 && curr!=null){
                curr.next=prev;
                prev=curr;
                curr=nex;
                if(nex!=null)
                    nex=nex.next;
                k++;
            }
            if(st!=null){
                st.next=prev;
            }
            ListNode temp=prev;
            while(temp.next!=null)temp=temp.next;
            temp.next=end;
            if(st!=null)
            return head;
            else return prev;
        }
}
