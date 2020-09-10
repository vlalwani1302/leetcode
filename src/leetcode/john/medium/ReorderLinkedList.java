package leetcode.john.medium;

import java.util.Stack;

import leetcode.john.linkedlist.ListNode;

public class ReorderLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		reorderList(head);
	}
	
	public static void reorderList(ListNode head) {
		if (head != null && head.next != null) {
			ListNode slow = head;
			ListNode fast = slow.next;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}

			ListNode start = head;
			ListNode mid = slow;
			Stack<ListNode> stack = new Stack<>();
			while(mid.next != null) {
				mid = mid.next;
				ListNode temp = new ListNode(mid.val);
				stack.push(temp);
			}
			slow.next = null;
			head = new ListNode(0);
			ListNode temp = head;
			while (start != null || !stack.isEmpty()) {
				if(start!=null) {
					temp.next = start;
					temp = temp.next;
					start = start.next;
				}
				if(!stack.isEmpty()) {
					temp.next = stack.pop();
					temp = temp.next;
				}
			}
			head = head.next;
		}
	}
}