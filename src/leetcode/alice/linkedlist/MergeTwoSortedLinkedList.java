package leetcode.alice.linkedlist;


public class MergeTwoSortedLinkedList {

	public static Node mergeTwoLists(Node l1, Node l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {

			return l1;
		}
		if (l1.data < l2.data) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.append(1);
		list1.append(2);
		list1.append(4);
		
		System.out.println("list1:");
		list1.show();
		
		LinkedList list2 = new LinkedList();
		// For other solution 
		list2.append(1);
		list2.append(3);
		list2.append(4);
		
		System.out.println("list2:");
		list2.show();
		
		System.out.println("Merged List:");
		Node l = mergeTwoLists(list1.head, list2.head);
		System.out.println();
	}

}
