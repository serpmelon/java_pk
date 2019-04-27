package com.togo.java.data.structure.tree.binarytree;

public class BinarySearchTree<T extends Comparable<? super T>> {

	private BinaryNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {

		return root == null;
	}

	public boolean contains(T t) {
		return contains(t, root);
	}

	private boolean contains(T t, BinaryNode<T> root2) {
		// TODO Auto-generated method stub
		return false;
	}

	public T findMin() {

		// TODO
		return null;
	}

	public T findMax() {
		// TODO
		return null;
	}

	public void insert(T t) {

		root = insert(t, root);
	}

	private BinaryNode<T> insert(T t, BinaryNode<T> root2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(T t) {

		root = remove(t, root);
	}

	private BinaryNode<T> remove(T t, BinaryNode<T> root2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void printTree() {

		printTree(root);
	}

	private void printTree(BinaryNode<T> root2) {
		// TODO Auto-generated method stub

	}

}
