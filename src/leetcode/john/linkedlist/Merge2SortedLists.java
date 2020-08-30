package leetcode.john.linkedlist;

public class Merge2SortedLists {

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
		mergeLists(list1.head, list2.head);
	}

	private static void mergeLists(Node l1, Node l2) {
		LinkedList result = new LinkedList();// using new list to add items from both lists one by one
		while(l1 != null && l2 != null) {
			if(l1.data < l2.data) {
				result.append(l1.data);
				l1 = l1.next;
//				result.show();
			} 
			else {
				result.append(l2.data);
				l2 = l2.next;
//				result.show();
			}
		}
		while(l1 != null) {
			result.append(l1.data);
			l1 = l1.next;
//			result.show();
		}
		while(l2 != null) {
			result.append(l2.data);
			l2 = l2.next;
//			result.show();
		}
		result.show();
	}
}
