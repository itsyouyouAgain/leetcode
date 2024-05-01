
class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // pointers for traversing the two lists
        ListNode p1 = list1, p2 = list2;
        // dummy node to build result list
        ListNode dummy = new ListNode(-1);
        // pointer for building result list
        ListNode p = dummy;

        // traverse both lists and append the smaller value to the merged list
        while(p1 != null && p2 != null){
            if(p1.val >= p2.val){
                p.next = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        // if elements are left in list1, append them
        if(p1 != null){
            p.next = p1;
            p = p.next;
        }

        // if elements are left in list2, append them
        if(p2 != null){
            p.next = p2;
            p = p.next;
        }

        // return the head of the result list, skipping the dummy node
        return dummy.next;
    }

    public static void main(String[] args) {
        // create two lists
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        // merge the two lists
        Solution solution = new Solution();
        ListNode result = solution.mergeTwoLists(list1, list2);

        // print merge list
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}