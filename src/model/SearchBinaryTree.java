package model;

public class SearchBinaryTree {
	private long num;
	private SearchBinaryTree left;
	private SearchBinaryTree right;
	
	public SearchBinaryTree(long n) {
		num = n;
		left = null;
		right = null;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public SearchBinaryTree getLeft() {
		return left;
	}

	public void setLeft(SearchBinaryTree left) {
		this.left = left;
	}

	public SearchBinaryTree getRight() {
		return right;
	}

	public void setRight(SearchBinaryTree right) {
		this.right = right;
	}
}
