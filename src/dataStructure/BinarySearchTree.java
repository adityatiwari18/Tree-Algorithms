package dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node3{
	int data;
	Node3 rnext;
	Node3 lnext;
	
	Node3(int d) {
		data = d;
		rnext = lnext = null;
	}
}

class Operation2{
	Node3 head;
	
     
	Node3 atPosition(int data, Node3 root) {
		
		if(data<= root.data && root.lnext!=null) 
			root = atPosition(data, root.lnext);
		else if(data> root.data && root.rnext!=null)
			root = atPosition(data, root.rnext);
		
		return root;
	}
	
	void insert(int data) {
			 
		if(head==null) {
			head = new Node3(data);
		}else {
			Node3 pos = atPosition(data, head);
			if(data<= pos.data)
				pos.lnext = new Node3(data);
			else
				pos.rnext = new Node3(data);
		}
			
	}
	void printTree() {
		
		Node3 temp = head;
		Queue<Node3> q = new LinkedList<>(); 
		q.add(temp);
		if(temp==null) {
			System.out.println("No Element Present");
		}
		else {
			while(!q.isEmpty()) {
				Node3 n = q.poll();
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
public class BinarySearchTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		Operation2 op = new Operation2();
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
			
//			case 2:
//				System.out.println("Enter Data to be deleted");
//				int data2 = sc.nextInt();
//				op.delete(data2);
//				break;
				
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
