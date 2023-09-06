package ReverseNodesInKGroup;


import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static void main(String[] args) {
        int []a={1,2,3,4,5};
        ListNode head=new ListNode(1);
       ListNode temp=head;
        for(int i=1;i<a.length;i++){
            temp.next=new ListNode(a[i]);
            temp=temp.next;
        }
        Solution s=new Solution();
        //head=s.reverse(head);
        head=s.reverseKGroup(head,2);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        var consolidateList = new ArrayList<Integer>();
        var currList = new ArrayList<Integer>();
        var pointer=head;
        int freq=0;
        while(pointer!=null){
            freq++;
            currList.add(pointer.val);
            pointer=pointer.next;
            if(freq==k){
                Collections.reverse(currList);
                consolidateList.addAll(currList);
                freq=0;
                currList= new ArrayList<>();
            }
        }
        consolidateList.addAll(currList);
        pointer=head;
        freq=0;
        while(pointer!=null){
            pointer.val=consolidateList.get(freq);
            freq++;
            pointer=pointer.next;
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
