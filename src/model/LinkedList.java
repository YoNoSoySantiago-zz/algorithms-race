package model;

public class LinkedList {
	private long num;
	private LinkedList next;
	
	public LinkedList(long n) {
		num = n;
		next = null;
		
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

}
