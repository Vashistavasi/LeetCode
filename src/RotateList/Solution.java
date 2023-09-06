package RotateList;

import java.util.ArrayList;

public class Solution {
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
        head=s.rotateRight(head,4);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        else if(p==null && q!=null )return false;
        else if(q==null && p!=null)return false;
        else if(p.val!=q.val)return false;
        else return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root.left==null && root.right==null)return root;
        root.left=invertTree(root.right);
        root.right=invertTree(root.left);
        return root;
    }
    public ListNode partition(ListNode head, int x) {
        var less = new ArrayList<Integer>();
        var great=new ArrayList<Integer>();
        var pointer=head;
        while(pointer!=null){
            if(pointer.val<x)less.add(pointer.val);
            else great.add(pointer.val);
            pointer=pointer.next;
        }
        pointer=head;
        int k=0;
        while(pointer!=null && k<less.size()){
            pointer.val=less.get(k);
            k++;
            pointer=pointer.next;
        }
        k=0;
        while(pointer!=null && k<great.size()){
            pointer.val=great.get(k);
            k++;
            pointer=pointer.next;
        }
        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
    var pointer=head;
    var count=0;
    while(pointer!=null){
        count++;pointer=pointer.next;
    }
    ListNode prev=null,start=null;
    int val=count-k;
    pointer=head;
    while(val>0){
        prev=pointer;
        pointer=pointer.next;
        start=pointer;
        val--;
    }
    prev.next=null;
    var newHead=start;
    while(newHead.next!=null){
        newHead=newHead.next;
    }
    newHead.next=head;
    return start;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
