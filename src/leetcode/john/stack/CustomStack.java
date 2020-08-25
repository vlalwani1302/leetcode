package leetcode.john.stack;

public class CustomStack {

	private static class Node{
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node top; // add-remove from here
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		return top.data; // Exception if head is null -- can check exception if needed
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	public int pop() {
		int data = top.data; // check exception if top is null
		top = top.next;
		return data;
	}
}
