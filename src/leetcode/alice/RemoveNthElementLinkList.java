package leetcode.alice;

import leetcode.alice.linkedlist.Node;

public class RemoveNthElementLinkList {

	public Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node slow = dummy;
        Node fast = dummy;
        
        for(int i=0; i<n ; i++){
            if(fast != null && fast.next != null){
                fast = fast.next;
            }
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}
