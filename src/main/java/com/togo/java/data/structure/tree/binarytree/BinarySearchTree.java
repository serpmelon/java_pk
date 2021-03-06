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

	private boolean contains(T t, BinaryNode<T> r) {

		if (r == null)
			return false;

		int compareResult = t.compareTo(r.getElement());

		if (compareResult < 0)
			return contains(t, r.getLeft());
		if (compareResult > 0)
			return contains(t, r.getRight());

		return true;
	}

	public T findMin() {

		if (isEmpty())
			throw new NullPointerException("THE TREE IS NULL");

		return findMin(root).getElement();
	}

	private BinaryNode<T> findMin(BinaryNode<T> t) {

		if (t == null)
			return null;
		if (t.getLeft() == null)
			return t;

		return findMin(t.getLeft());
	}

	public T findMax() {

		if (isEmpty())
			throw new NullPointerException("THE TREE IS NULL");

		return findMax(root).getElement();
	}

	private BinaryNode<T> findMax(BinaryNode<T> t) {

		if (t == null)
			return null;

		while (t.getRight() != null)
			t = t.getRight();

		return t;
	}

	public void insert(T t) {

		root = insert(t, root);
	}

	private BinaryNode<T> insert(T t, BinaryNode<T> r) {

		if (r == null)
			return new BinaryNode<T>(t, null, null);

		int compareResult = t.compareTo(r.getElement());

		if (compareResult < 0)
			r.setLeft(insert(t, r.getLeft()));
		else if (compareResult > 0)
			r.setRight(insert(t, r.getRight()));

		return r;
	}

	public void remove(T t) {

		root = remove(t, root);
	}

	private BinaryNode<T> remove(T t, BinaryNode<T> r) {

		if (r == null)
			return r;

		int compareResult = t.compareTo(r.getElement());

		if (compareResult < 0) {
			r.setLeft(remove(t, r.getLeft()));
		} else if (compareResult > 0) {
			r.setRight(remove(t, r.getRight()));
		} else if (r.getLeft() != null && r.getRight() != null) {

			r.setElement(findMin(r.getRight()).getElement());
			r.setRight(remove(r.getElement(), r.getRight()));
		} else {
			r = r.getLeft() != null ? r.getLeft() : r.getRight();
		}

		return r;
	}

	public void printTree() {

		if (isEmpty()) {
			System.out.println("empty tree");
		} else {
			printTree(root);
		}
	}

	private void printTree(BinaryNode<T> r) {

		if (r != null) {

			printTree(r.getLeft());
			System.out.println(r.getElement());
			printTree(r.getRight());
		}
	}
}
