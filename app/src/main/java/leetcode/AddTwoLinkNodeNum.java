package leetcode;

/**
 * Created by aiya on 17/11/1.
 */

public class AddTwoLinkNodeNum {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        boolean isTen = false;
        while (l1 != null || l2 != null) {
           int x = l1!=null?l1.val:0;
            int y = l2!=null?l2.val:0;
            int num = isTen ? x+ y + 1 : x+y;
            if (num >= 10) {
                temp.val = num - 10;
                isTen = true;
            } else {
                temp.val = num;
                isTen = false;
            }
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
            if (l1!=null||l2!=null){
                temp.next = new ListNode(0);
                temp =temp.next;
            }
        }
        if (isTen){
            temp.next = new ListNode(1);
        }
        return node;
    }

}
