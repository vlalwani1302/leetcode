package leetcode.john.linkedlist;

public class LinkedList {
	Node head;
	
	public void append(Integer data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	public void show() {
		Node temp = head;
		while(temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
	
	public void prepend(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void deleteWithValue(int data) {
		if(head == null) return;
		if(head.data == data) head = head.next;
		Node current = head;
		while(current.next != null) {
			if(current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	public boolean hasCycles(Node head) {
		if(head == null) return false;
		Node fast = head.next;
		Node slow = head;
		while(fast != null && fast.next != null && slow != null) {
			if(fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}
	
	public void insertAtIndex(Integer index, Integer data) {
		Node newNode = new Node(data);
		Node current = head;
		if(index == 0) {
			prepend(data);
		}
		for(int i = 0; i < index-1; i++) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
	}
}
