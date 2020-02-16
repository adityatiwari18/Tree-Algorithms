package dataStructure;

import java.util.Scanner;

class Node{
	int Data;
	Node next;
}

class Operation{
	Node head;
	
	void insert(int data) {
		Node n = new Node();
		n.Data = data;
		
		if(head == null)
			head = n;
		else {
			Node temp = head;
			while(temp.next!=null)
				temp = temp.next;
			
			temp.next = n;
		}
	}
	
	void insertAt(int data, int pos) {
		Node temp = head;
		Node n = new Node();
		n.Data = data;
		Operation o = new Operation();
		int l = o.length();
		if(pos<l) {
			if(pos != 0) {
				while((pos-1)!=0) {
					temp = temp.next;
					pos--;
				}
				if(temp.next == null)
					temp.next = n;
				else {
					Node  temp2 = temp.next;
					n.next = temp2;
					temp.next = n;
				}
			}else {
				n.next = temp;
				head = n;
			}
		}else 
			System.out.println("Enter a valid position");
	}
	
	void delete() {
		if(head!=null)
			head = head.next;
		else
			System.out.println("No Data Available");
	}
	
	void deleteAt(int pos) {
		Node n = head;
		Operation o = new Operation();
		int l = o.length();
		if(pos<=l) {
			if(n!=null) {
				if(pos == 0) {
					head = n.next;
				}else {
					while((pos-1)!=0) {
						n = n.next;
						pos--;
					}
					n.next = n.next.next;
					
				}
			}else
				System.out.println("No Data Available");
		}else
			System.out.println("Enter a valid position");
	}
	
	int length() {
		Node n = head;
		int c = 1;
		
		if(n!=null) {
			while(n.next!=null) {
				++c;
				n = n.next;
			}
				return c;
		}else
			return 0;
	}
	
	void Ascend() {
		Node n = head;
		
	}
	
	void show() {
		
		if(head!=null) {
			Node n = head;
			while(n.next!=null) {
				System.out.print(n.Data+" ");
				n = n.next;
			}
			System.out.println(n.Data);
		}else
			System.out.println("No data available");
	}
}

public class LinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Operation op = new Operation();
		boolean flag = true;
		while(flag) {
			System.out.println("\nEnter Your choice...");
			System.out.println("1 - Insert At the End");
			System.out.println("2 - Insert At a position");
			System.out.println("3 - Delete from beginning ");
			System.out.println("4 - Delete At a position");
			System.out.println("5 - Length of the List");
			System.out.println("6 - Print List");
			System.out.println("7 - Exit");
			int n = sc.nextInt();
			
			switch(n) {
			
			case 1:
				System.out.println("Enter Number to insert");
				int n1 = sc.nextInt();
				op.insert(n1);
				break;
			case 2:
				System.out.println("Enter Number to insert and position");
				int n2 = sc.nextInt();
				int pos = sc.nextInt();
				op.insertAt(n2, pos);
				break;
			case 3:
				op.delete();
				break;
			case 4:
				System.out.println("Enter Position to Delete");
				int pos2 = sc.nextInt();
				op.deleteAt(pos2);
				break;
			case 5:
				System.out.println(op.length());
				break;
			case 6:
				op.show();
				break;
			case 7:
				flag = false;
				break;
			default:
				System.out.println("Enter valid choice");
				break;
			}
		}	
	}
}

