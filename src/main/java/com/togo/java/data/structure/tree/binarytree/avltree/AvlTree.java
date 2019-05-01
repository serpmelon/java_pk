package com.togo.java.data.structure.tree.binarytree.avltree;

import com.togo.java.data.structure.tree.binarytree.BinaryNode;

public class AvlTree<T extends Comparable<? super T>> {

	private static final int ALLOWED_IMBALANCE = 1;

	private AvlNode<T> root;

	public AvlTree() {
		root = null;
	}

	public AvlNode<T> insert(T element) {

		return insert(element, root);
	}

	private AvlNode<T> insert(T element, AvlNode<T> tree) {

		if (tree == null)
			return new AvlNode<T>(element);

		int compareResult = element.compareTo(tree.element);

		if (compareResult < 0) {
			tree.left = insert(element, tree.left);
		} else if (compareResult > 0) {
			tree.right = insert(element, tree.right);
		}

		return balance(tree);
	}

	public AvlNode<T> remove(T element) {

		return remove(element, root);
	}

	private AvlNode<T> remove(T element, AvlNode<T> t) {

		if (t == null)
			return t;

		int compareResult = element.compareTo(t.element);

		if (compareResult < 0)
			t.left = remove(element, t.left);
		else if (compareResult > 0)
			t.right = remove(element, t.right);
		else if (t.left != null && t.right != null) {

			t.element = findMin(t.right).element;
			t.right = remove(element, t.right);
		} else {
			t = t.left != null ? t.left : t.right;
		}

		return balance(t);
	}

	public boolean isEmpty() {

		return root == null;
	}

	public T findMin() {

		if (isEmpty())
			throw new NullPointerException("THE TREE IS NULL");

		return findMin(root).element;
	}

	private AvlNode<T> findMin(AvlNode<T> t) {

		if (t == null)
			return null;
		if (t.left == null)
			return t;

		return findMin(t.left);
	}

	private AvlNode<T> balance(AvlNode<T> tree) {

		if (tree == null)
			return tree;

		if (height(tree.left) - height(tree.right) > ALLOWED_IMBALANCE) {

			if (height(tree.left.left) >= height(tree.left.right)) {

				tree = rotateWithLeftChild(tree);
			} else {

				tree = doubleWithLeftChild(tree);
			}
		} else if (height(tree.right) - height(tree.left) > ALLOWED_IMBALANCE) {

			if (height(tree.right.right) >= height(tree.right.left)) {

				tree = rotateWithRightChild(tree);
			} else {

				tree = doubleWithRightChild(tree);
			}
		}

		tree.height = Math.max(height(tree.left), height(tree.right)) + 1;

		return tree;
	}

	private AvlNode<T> doubleWithRightChild(AvlNode<T> tree) {

		tree.right = rotateWithLeftChild(tree.right);
		return rotateWithRightChild(tree);
	}

	private AvlNode<T> rotateWithRightChild(AvlNode<T> tree) {

		AvlNode<T> right = tree.right;
		tree.right = right.left;
		right.left = tree;

		tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
		right.height = Math.max(height(right.right), height(tree)) + 1;

		return right;
	}

	private AvlNode<T> doubleWithLeftChild(AvlNode<T> tree) {

		tree.left = rotateWithRightChild(tree.left);
		return rotateWithLeftChild(tree);
	}

	private AvlNode<T> rotateWithLeftChild(AvlNode<T> tree) {

		AvlNode<T> left = tree.left;
		tree.left = left.right;
		left.right = tree;

		tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
		left.height = Math.max(height(left.left), tree.height) + 1;

		return left;
	}

	private int height(AvlNode<T> tree) {

		return tree == null ? -1 : tree.height;
	}

	private static class AvlNode<T> {

		private T element;
		private AvlNode<T> left;
		private AvlNode<T> right;
		private int height;

		public AvlNode(T t) {

			this(t, null, null);
		}

		public AvlNode(T t, AvlNode<T> left, AvlNode<T> right) {

			this.element = t;
			this.left = left;
			this.right = right;
		}
	}
}
