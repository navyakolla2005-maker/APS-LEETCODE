class Solution {
    private ListNode findKth(ListNode head, int k) {
        k -= 1;
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, prevLast = null;

        while (temp != null) {

            ListNode kth = findKth(temp, k);
            if (kth == null) {
                if (prevLast != null) prevLast.next = temp;
                break;
            }

            ListNode nextNode = kth.next;
            kth.next = null;

            ListNode newHead = reverse(temp);

            if (temp == head) {
                head = newHead;
            } else {
                prevLast.next = newHead;
            }

            temp.next = nextNode;
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }
}