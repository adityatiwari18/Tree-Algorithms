package AVL;

import java.util.LinkedList;
import java.util.Queue;


public class AvlTree {

	private class Node {

		int data;
		Node left;
		Node right;
		int height;

		public Node(int data) {
			this.data = data;
			this.height = 1;
		}
	}

	private Node root;

	public void insert(int item) {
		this.root = insert(this.root, item);
	}

	private Node insert(Node node, int item) {

		if (node == null) {
			Node nn = new Node(item);
			return nn;
		}

		if (item > node.data) {
			node.right = insert(node.right, item);
		} else if (item < node.data) {
			node.left = insert(node.left, item);
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		int bf = bf(node);

		// LL Case
		if (bf > 1 && item < node.left.data) {
			return rightRotate(node);
		}

		// RR Case
		if (bf < -1 && item > node.right.data) {
			return leftRotate(node);
		}

		// LR Case
		if (bf > 1 && item > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// RL Case
		if (bf < -1 && item < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;

	}

	private int height(Node node) {
		if (node == null) {
			return 0;
		}

		return node.height;
	}

	private int bf(Node node) {
		if (node == null) {
			return 0;
		}

		return height(node.left) - height(node.right);
	}

	private Node rightRotate(Node c) {

		Node b = c.left;
		Node T3 = b.right;

		b.right = c;
		c.left = T3;

		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;
	}

	private Node leftRotate(Node c) {

		Node b = c.right;
		Node T2 = b.left;

		// rotate
		b.left = c;
		c.right = T2;

		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;
	}

	public void display() {
		printTree();
	}

	

	void printTree() {
		
		Node temp = this.root;
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
	}
	public static void main(String[] args) {
		AvlTree avl = new AvlTree();
		avl.insert(1);
		avl.insert(2);
		avl.insert(3);
		avl.insert(4);

		avl.printTree();
	}
}