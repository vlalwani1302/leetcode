package leetcode.john.linkedlist;

import java.util.Stack;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		reverseListStack(head);
	}
	
	static ListNode reverseListStack(ListNode node) {
		if (node == null) return node;
		Stack<ListNode> st = new Stack<>();
		ListNode temp = node;
		while(temp != null) {
			st.push(temp);
			temp = temp.next;
		}
		temp = st.pop();
		node = temp;
		while(!st.empty()) {
			temp.next = st.pop();
			temp = temp.next;
		}
		return node;
	}

}