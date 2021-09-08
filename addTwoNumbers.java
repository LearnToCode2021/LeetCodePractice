import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class addTwoNumbers {
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

         /** Given a non-empty int[] vals, create a linked list with all values of the array */
         static ListNode createList(int[] vals) {
             ListNode retListNode = new ListNode();
             ListNode thisNode = retListNode;
             for (int i = 0; i < vals.length - 1; i++) {
                 thisNode.val = vals[i];
                 thisNode.next = new ListNode();
                 thisNode = thisNode.next;
             }
             thisNode.val = vals[vals.length - 1];
             return retListNode;
         }

         boolean equals(ListNode l) {
             ListNode thisNode = this;
             while (l != null) {
                 if (l.val != thisNode.val) { return false; }
                 l = l.next;
                 thisNode = thisNode.next;
             }
             return (thisNode == null);
         }
    }

    public ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else {
            if (l1.val + l2.val >= 10) {
                l1.next = refactorNext(l1.next);
                return new ListNode(l1.val + l2.val - 10, solution(l1.next, l2.next));
            } else {
                return new ListNode(l1.val + l2.val, solution(l1.next, l2.next));
            }
        }
    }

    public ListNode refactorNext(ListNode l1) {
        if (l1 == null) {
            return new ListNode(1);
        }
        l1.val++;
        if (l1.val >= 10) {
            l1.val -= 10;
            l1.next = refactorNext(l1.next);
        }
        return l1;
    }

    @Test
    public void test(){
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, null)))))));
        ListNode l9 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        assertTrue(ListNode.createList(new int[] {1, 2, 3, 4}).equals(ListNode.createList(new int[] {1, 2, 3, 4})));
        assertTrue(ListNode.createList(new int[] {9, 9, 9, 9}).equals(l9));
        ListNode l1 = ListNode.createList(new int[] {9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.createList(new int[] {9, 9, 9, 9});
        ListNode returnNode = solution(l1, l2);
        ListNode l3 = ListNode.createList(new int[] {2, 4, 3});
        ListNode l4 = ListNode.createList(new int[] {5, 6, 4});
        ListNode returnNode2 = solution(l3, l4);
        assertTrue(returnNode2.equals(ListNode.createList(new int[] {7, 0, 8})));
        assertTrue(returnNode.equals(ListNode.createList(new int[] {8, 9, 9, 9, 0, 0, 0, 1})));
    }
}
