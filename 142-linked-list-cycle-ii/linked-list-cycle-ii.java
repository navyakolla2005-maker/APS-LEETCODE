/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head)
    {
        ListNode f=head;
        ListNode s=head;
        while(f!=null && f.next!=null)
        {
            s=s.next;
            f=f.next.next;
            if(f==s)        
            break;
        }
        if (f == null || f.next == null)
        return null;
        f=head;
        while(f!=s) //now increase both the pointers, you will be pointitng to the start node.
        {
            f=f.next;
            s=s.next;
        }
        return f;
    }
}