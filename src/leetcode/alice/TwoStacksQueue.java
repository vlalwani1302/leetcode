package leetcode.alice;

import java.io.*;
import java.util.*;

public class TwoStacksQueue {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. FIFO*/ 
        Scanner scanner = new Scanner(System.in);
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);

            Stack stackA = new Stack();
            Stack stackB = new Stack();

            for(int i = 0; i < n ; i++){
               String[] str = scanner.nextLine().split(" ");
               int query = 0;
               int data = 0;
               query = Integer.parseInt(str[0]);
               if(str.length == 2) {
                   data = Integer.parseInt(str[1]);
               }

               switch(query){
               case 1: //enqueue element in queue
                   stackA.push(data);
                   break;
               case 2: // dequeue element from queue
                   
                   if(stackB.isEmpty()){
                    while(!stackA.isEmpty()){
                       stackB.push(stackA.pop());
                    }
                   }
                   
                   stackB.pop();
                   
                   break;
               case 3: // print first element
                   if(stackB.isEmpty()){

                    while(!stackA.isEmpty()){
                        stackB.push(stackA.pop());
                    }
                   }
                   System.out.println(stackB.peek());
                   
                   break;
               }
            }
        }
}
