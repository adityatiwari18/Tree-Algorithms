package dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node2{
	int data;
	Node2 rnext;
	Node2 lnext;
}

class Operation1{
	static Node2 head;
	

	void insert(int data) {
		Node2 temp = head;
		Node2 n = new Node2();
		n.data = data;
		n.lnext = null;
		n.rnext = null;
		Queue<Node2> q = new LinkedList<>();
		q.add(temp);
		if(temp == null) {
			head = n;
		}else {
			while(!q.isEmpty()) {
				
				Node2 n1 = q.poll();
			    if(n1.lnext==null) {
					n1.lnext = n;
					break;
				}else
					q.add(n1.lnext);
			    if(n1.rnext ==null) {
			    	n1.rnext = n;
			    	break;
			    }else
			    	q.add(n1.rnext);
			}
		}
	}
	
	
	void delete(int data) {
		Node2 temp = head;
		Node2 keyNode=null;
		Queue<Node2> q = new LinkedList<>();
		q.add(temp);
		if(temp == null)
			System.out.println("List is empty..!");
		else {
			while(!q.isEmpty()) {
				Node2 n = q.poll();
				if(n.data == data) {
					keyNode = n;
					break;
				}
				if(n.lnext == null) {
					System.out.println("No such Element");
				}else
					q.add(n.lnext);
				if(n.rnext == null) {
					System.out.println("No such Element");
				}else
					q.add(n.rnext);
			}
			if(keyNode!=null) {
				Node2 dNode = DeepestNode();
				if(dNode.rnext!=null) {
				    keyNode.data = dNode.rnext.data;
				    dNode.rnext = null;
				}
				else {
					keyNode.data = dNode.lnext.data;
					dNode.lnext =null;
				}
				
			}
		}
	}
	
	static Node2 DeepestNode() {
		Node2 temp = head;
		Node2 dNode = null;
		Queue<Node2> q = new LinkedList<>();
		q.add(temp);
		
		if(temp == null)
			return temp;
		else {
			while(!q.isEmpty()) {
				Node2 n = q.poll();
				if(n.lnext!=null)
					dNode = n;
				if(n.lnext==null) {
					break;
				}else
					q.add(n.lnext);
			    if(n.rnext ==null) {
			    	break;
			    }else
			    	q.add(n.rnext);
			}
		}
		return dNode;
	}
	
	void printTree() {
		Node2 temp = head;
		Queue<Node2> q = new LinkedList<>();
		q.add(temp);
		if(temp==null) {
			System.out.println("No Element Present");
		}
		else {
			while(!q.isEmpty()) {
				Node2 n = q.poll();
				System.out.print(n.data+" ");
				if(n.lnext!=null) {
					q.add(n.lnext);
				}
				if(n.rnext!=null) {
					q.add(n.rnext);
				}
			}
		}
	}
}


public class BinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		Operation1 op = new Operation1();
		while(flag) {
			System.out.println("Enter your choice \n");
			System.out.println("1 - Insert Data");
			System.out.println("2 - Delete Data");
			System.out.println("3 - Print Data");
			System.out.println("4 - Exit");
			int ch = sc.nextInt();
			
			switch(ch) {
			
			case 1:
				System.out.println("Enter Data to be inserted");
				int data = sc.nextInt();
				op.insert(data);
				break;
			
			case 2:
				System.out.println("Enter Data to be deleted");
				int data2 = sc.nextInt();
				op.delete(data2);
				break;
				
			case 3:
				System.out.println("The Elements in the Tree are : ");
				op.printTree();
				break;
				
			case 4:
				flag = false;
				break;
			}
		}
	}
}
