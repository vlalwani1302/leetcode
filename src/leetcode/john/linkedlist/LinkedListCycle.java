package leetcode.john.linkedlist;

import java.util.HashSet;
import java.util.Set;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LinkedListCycle {
	
	public boolean hasCycle(ListNode head) {
		if(head == null) return false;
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast != null && fast.next != null && slow != null) {
			if(fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}
	
}