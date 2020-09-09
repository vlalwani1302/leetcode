package leetcode.alice.linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}*/
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

			ListNode fHalf = head;
			ListNode sHalf = slow.next;
			slow.next = null;
			sHalf = reverselist(sHalf);
			head = new ListNode(0);
			ListNode currNode = head;
			while (fHalf != null || sHalf != null) {
				if (fHalf != null) {
					currNode.next = fHalf;
					currNode = currNode.next;
					fHalf = fHalf.next;
				}
				if (sHalf != null) {
					currNode.next = sHalf;
					currNode = currNode.next;
					sHalf = sHalf.next;
				}
			}

			head = head.next;
		}
	}

	static ListNode reverselist(ListNode node) {
		ListNode prev = null, curr = node, next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node = prev;
		return node;
	}

}