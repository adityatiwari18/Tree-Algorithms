package Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class DfsBfs {

	
	private class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}
	
	private Node head;
	
	void insert(int data) {
		this.head = attach(this.head, data);
	}
	
	Node attach(Node head, int data) {
		
		if(head == null) {
			Node n = new Node(data);
			return n;
		}
		else if(data<head.data)
			head.left = attach(head.left, data);
		else if(data>head.data)
			head.right = attach(head.right, data);
		
		return head;
	}
	
	void BreadthFirstSearch() {
		Node temp = head;
		Queue<Node> q = new LinkedList<>();
		q.add(temp);
        
		if(temp == null)
			System.out.println("No element present");
		else {
			while(!q.isEmpty()) {
				Node n = q.poll();
				System.out.print(n.data+" ");
				if(n.left!=null)
					q.add(n.left);
				if(n.right!=null)
					q.add(n.right);
			}
		}
		System.out.println();
	}
	
	void DepthFirstSearch(Node head) {
		if(head == null)
			return;
		
		System.out.print(head.data+" ");
		DepthFirstSearch(head.left);
		DepthFirstSearch(head.right);
	}
	
	public static void main(String[] args) {

		DfsBfs db = new DfsBfs();
		db.insert(4);
		db.insert(2);
		db.insert(5);
		db.insert(1);
		db.insert(3);
		
		db.BreadthFirstSearch();
		db.DepthFirstSearch(db.head);
	}

}
