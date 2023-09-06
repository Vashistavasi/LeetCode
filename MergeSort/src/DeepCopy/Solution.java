package DeepCopy;


//Definition for a Node.
class Node {
 int val;
 Node next;
 Node random;

 public Node(int val) {
     this.val = val;
     this.next = null;
     this.random = null;
 }
}


class Solution {
 public Node copyRandomList(Node head) {
     if(head==null)return null;
     Node root=new Node(head.val);
  {
         if(head.random!=null)
         root.random=copyRandomList(head.random);
         if(head.next!=null)
         root.next=copyRandomList(head.next);
     }
     return root;
 }
}