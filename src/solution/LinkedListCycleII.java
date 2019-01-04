package solution;

/**
 * @author Sophie Song
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * @since 04/01/2019
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {//there is a cycle
                //next step is to find the entrance of the cycle, fast = slow is the point of meet, not the point of the entrance of the cycle
                //to find the entrance, the method is that the fast pointer walk 2 times the distance than the slow pointer
                //let a be the distance before the entrance, b be the distance from the entrance to the meeting point, c be the distance from the meeting point to the entrance point
                //then:
                //distance(slow) = a + m(b+c) + b
                //distance(fast) = a + n(b+c) + b
                //distance(fast) = 2distance(slow) =>
                //a + n(b+c) + b = 2[a + m(b+c) + b] =>
                //a = (n - 2m - 1) (b+c) + c
                //b+c is the distance of the cycle, so let a pointer walk from the head, another pointer walk from the meeting point, then they must meet at the entrance point
                while(head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }


}
