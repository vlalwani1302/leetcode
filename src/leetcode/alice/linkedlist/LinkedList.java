package leetcode.alice.linkedlist;

public class LinkedList {
	Node head;

	public void append(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}

	public void prepend(int data) {
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}

	public void deleteWithValue(int data) {
		if (head == null) {
			return;
		}
		if (head.data == data) {
			head = head.next;
			return;
		}
		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	public Node insertNodeAtPosition(int data, int position) {
		if(position == 0 && head == null) {
			head= new Node(data);
			head.next = null;
			return head;
		}
		Node current = head;
		int currentPosition = 0;
		while(current.next != null) {
			if(currentPosition == position - 1) {
				Node newNode = new Node(data);
				newNode.next = current.next;
				current.next = newNode;
				return head;
			}
			current = current.next;
			currentPosition++;
		}
		return head;
	}
	
	public boolean hasCycle() {
		if(head == null) {
			return false;
		}
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		return false;


    }
}
