package leetcode.john.queue;

public class Queue {

	private static class Node{
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node head; // remove from here
	private Node tail; // add here
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int peek() {
		return head.data; // Exception if head is null -- can check exception if needed
	}
	
	public void add(int data) {
		Node node = new Node(data);
		if(tail != null) {
			tail.next = node;
		}
		tail = node;
		if(head == null) {
			head = node;
		}
	}
	
	public int remove() {
		int data = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return data;
	}
}
