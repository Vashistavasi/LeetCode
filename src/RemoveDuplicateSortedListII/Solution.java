package RemoveDuplicateSortedListII;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }
       public ListNode deleteDuplicates3(ListNode head){

           var hm = new HashMap<Integer, Integer>();
           ListNode temp=head;
           while(temp!=null){
               hm.put(temp.val,hm.getOrDefault(temp.val,0)+1);
               temp=temp.next;
           }
          Set<Map.Entry<Integer, Integer>> entrySet=hm.entrySet();
//           Stream<Map.Entry<Integer, Integer>> entrySetStream = hm.entrySet().stream();
//           entrySetStream.filter(e -> e.getValue() == 1).map(new MyMapper<Map<Integer,Integer>,HashSet>(){
//
//           }).collect(Collectors.toSet());
           var hs = new HashSet<Integer>();
           Iterator<Map.Entry<Integer,Integer>> iterator= entrySet.iterator();
           while(iterator.hasNext()){
               Map.Entry<Integer,Integer> curr=iterator.next();
               if(curr.getValue()==1){
                   hs.add(curr.getKey());
               }
           }
           temp=head;
           var al=new ArrayList<ListNode>();
           while(temp!=null){
               if(hs.contains(temp.val)){
                   al.add(temp);
               }
               temp=temp.next;
           }
           for(int i=1;i<al.size();i++){
               ListNode prev=al.get(i-1);
               prev.next=al.get(i);
           }
           al.get(al.size()-1).next=null;
           return al.get(0);
       }
    public ListNode deleteDuplicates1(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head.next;
        boolean flag=false;
        while(fast !=null && slow.val==fast.val){
            fast=fast.next;
            flag=true;
        }
        if(fast==null)
            return null;
        if(flag){
            slow=fast;
            fast=fast.next;
        }

        ListNode ans=slow;
        while(fast!=null){
            if(fast!=null && slow.val!=fast.val){
                prev=slow;
                slow=fast;
                fast=fast.next;
            }
            else{
                while(fast !=null && slow.val==fast.val){
                    fast=fast.next;
                }
                slow=fast;
                if(prev!=null)
                    prev.next=fast;
                if(fast!=null)
                    fast=fast.next;
            }
        }
        return ans;
    }
}
