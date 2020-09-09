package leetcode.alice.linkedlist;

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

		if (head == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}
	
	// time and space complexity - O(n)
	public boolean hasCycle1(ListNode head) {
		if (head == null) {
			return false;
		}
		
		Set<ListNode> visited = new HashSet<ListNode>();
		
		while(head != null) {
			if(visited.contains(head)) {
				return true;
			}else {
				visited.add(head);
				head = head.next;
			}
		}
		return false;
	}
}