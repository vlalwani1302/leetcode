package leetcode.alice.linkedlist;

public class Queue {
	private static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	private Node head; //remove from here
	private Node tail; //Add here

	public boolean isEmpty() {
		return head == null;
	}
	public int peek() {
		if(head != null) {
			return head.data;
		}
		return 0;
	}
	public void add(int data) {
		Node newTail = new Node(data);
		if(tail != null) {
			tail.next = newTail;
		}
		tail = newTail;
		if(head == null) {
			head = newTail;
		}
	}
	public int remove() {
		int data = 0;
		if(head != null) {
			data = head.data;
			if(head.next != null) {
				head = head.next;
			}else {
				head = null;
			}
		}
		if(head == null) {
			tail = null;
			return data;
		}
		return data;
	}
	
}
