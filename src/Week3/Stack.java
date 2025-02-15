package Week3;

import java.util.ArrayList;

public class Stack {
     class Node{
         private int data;
        private  Node next;

        public Node(int x , Node next) {
            this.data = x;
            this.next = null;
        }
        public Node(int x){
            this(x,null);
        }
    }
    Node head;

    boolean isEmpty(){
        return head == null;
    }

   public void push(int x){
        if(isEmpty()){
            head = new Node(x);
        }
        else{
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
        }
    }

    public Node pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        else{
            Node temp = head;
            head = head.next;
            return temp;
        }
    }

    public int top(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }  else {
            return head.data;
        }
    }


    public void get(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        } else {
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
