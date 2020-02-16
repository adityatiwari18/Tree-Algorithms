package Traversal;

import java.util.LinkedList;
import java.util.Queue;


public class PrePostIn {

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
	
	void printTree() {
		Node temp = head;
		Queue<Node> q = new LinkedList<>();
		q.add(temp);
		if(temp==null) {
			System.out.println("No Element Present");
		}
		else {
			while(!q.isEmpty()) {
				Node n = q.poll();
				System.out.print(n.data+" ");
				if(n.left!=null) {
					q.add(n.left);
				}
				if(n.right!=null) {
					q.add(n.right);
				}
			}
		}
		System.out.println();
	}
	
	void preorder(Node head) {
		
		if(head == null)
			return;
		
		System.out.print(head.data+" ");
		preorder(head.left);
		preorder(head.right);
	}
	
	void postorder(Node head) {
		
		if(head == null)
			return;
		
		postorder(head.left);
		postorder(head.right);
		System.out.print(head.data+" ");
	}

	void inorder(Node head) {
		
		if(head == null)
			return;
		
		inorder(head.left);
		System.out.print(head.data+" ");
		inorder(head.right);
	}	
	
	
	public static void main(String[] args) {
		PrePostIn ppi  = new PrePostIn();
		ppi.insert(4);
		ppi.insert(2);
		ppi.insert(5);
		ppi.insert(1);
		ppi.insert(3);

		ppi.printTree();
		ppi.preorder(ppi.head);
		System.out.println();
		ppi.postorder(ppi.head);
		System.out.println();
		ppi.inorder(ppi.head);
	}

}
