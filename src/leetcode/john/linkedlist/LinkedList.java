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
			System.out.print(temp.data);
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
	public Node removeNthFromEnd(Node head, int n) {
		Node temp1 = head;
		Node temp2 = head;
		Node result;
		int size = 1;
		// find length of list
		while(temp1.next != null) {
			temp1 = temp1.next;
			size++;
		}
		// traverse to length-n
		for(int i = 1; i < size - n; i++) {
			temp2 = temp2.next;
		}
		result = temp2.next;
		temp2.next = temp2.next.next;
		return result;
	}
	
//	public Node removeNthFromEnd2(Node head, int n) {
//		Node fast = head;
//		Node slow = head;
//		Node result = null;
//		for(int i = 0; i < n; i++) {
//			fast = fast.next;
//		}
//		while(fast.next != null) {
//			fast = fast.next;
//			slow = slow.next;
//		}
//		result = slow.next;
//		slow.next = slow.next.next;
//		return result;
//	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		
		System.out.println("Before:");
		list.show();
		list.removeNthFromEnd(list.head, 2);
		
		System.out.println("After:");
		list.show();
		
//		// For other solution 
//		System.out.println("For other solution:\n");
//		LinkedList list2 = new LinkedList();
//		list2.append(1);
//		list2.append(2);
//		list2.append(3);
//		list2.append(4);
//		list2.append(5);
//		
//		System.out.println("Before:");
//		list2.show();
//		list2.removeNthFromEnd2(list.head, 2);
//		
//		System.out.println("After:");
//		list2.show();
	}
}
