import java.util.*;
class Runner{
	
	static class Node{
		String Name;
		int Time;
		String Category;
		Node nxt;
		
		Node(String a,int b,String c){
			Name=a;
			Time=b;
			Category=c;
		}
		Node(){}

	}

	static class Linkedlist{
		Node head;
		int size;
		Linkedlist(){
			head = new Node();
		}

		void addInto(String a,int b,String c){
			Node x = new Node(a,b,c);
			Node cur = head;
			while(cur.nxt!=null){
				cur=cur.nxt;
			}
			size++;
			cur.nxt = x;
		}

		void display(){
			Node cur = head;
			if(size!=0){
				cur=cur.nxt;
				while(cur!=null){
					System.out.println(cur.Name+"\t"+cur.Time+"\t"+cur.Category);
					cur=cur.nxt;
				}
			}
			else{
				System.out.println("Empty Linked List!!");
			}
		}
	}

	
}