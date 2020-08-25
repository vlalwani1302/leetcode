package leetcode.john.queue.queueusing2stacks;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();;
	
	public void enqueue(Integer item) {
		s1.push(item);
	}
	
	public Integer dequeue() {
		if(s2.empty()) {
			while(!s1.empty()) {
				s2.push(s1.pop()); //invert s1 into s2 if s2 was empty i.e. has no element to pop/peek
			}
		}
		return s2.pop();
	}
	
	public Integer poll() {
		if(s2.empty()) {
			while(!s1.empty()) {
				s2.push(s1.pop()); //invert s1 into s2 if s2 was empty i.e. has no element to pop/peek
			}
		}
		System.out.println(s2.peek());
		return s2.peek();
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int noElements = in.nextInt();
        QueueUsingTwoStacks obj = new QueueUsingTwoStacks();
        
        int query;
        
//        for (int i = 0 ; i < noElements ; i++) {
        while(true) {
            query = in.nextInt();
            if(query == 1) { // enqueue next element
            	obj.enqueue(in.nextInt());
            } else if(query == 2){ // dequeue
            	obj.dequeue();
            } else if(query == 3){ // print    
               obj.poll();
            }
        }
    }
}
