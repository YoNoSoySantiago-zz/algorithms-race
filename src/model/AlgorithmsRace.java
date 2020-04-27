package model;

import java.util.ArrayList;

public class AlgorithmsRace {
	private ArrayList<Long> arrayList;
	private LinkedList linkedList;
	private SearchBinaryTree binaryTree;
	
	public AlgorithmsRace() {
		arrayList=new ArrayList<Long>();
		linkedList=null;
		binaryTree=null;
	}
	
	public void addArrayList(long n) {
		arrayList.add(n);
	}
	public void addArrayListR(long n) {
		addArrayListR(n,0);
	}
	private void addArrayListR(long n, int i) {
		/*try {
			arrayList.get(i);
			addArrayListR(n,(i+1));
		}catch(NullPointerException e) {
			arrayList.set(i, n);
		}
		*/
		if(arrayList.get(i)==null) {
			arrayList.add(i,n);
		}else {
			addArrayListR( n,(i+1));
		}
				
	}
	public void addLinkedList(long n) {
		LinkedList nuevo = new LinkedList(n);
		if(linkedList==null) {
			linkedList = nuevo;
		}else {
			LinkedList actual = linkedList;
			while(actual.getNext()!=null) {
				actual = actual.getNext();
			}
			actual.setNext(nuevo);
		}
	}
	
	public void addLinkedListR(long n) {
		if(linkedList!=null) {
			addLinkedListR(n,linkedList);
		}else {
			LinkedList nuevo = new LinkedList(n);
			linkedList = nuevo;
		}
		
	}
	private void addLinkedListR(long n,LinkedList actual) {
		if(actual.getNext() == null) {
			LinkedList nuevo = new LinkedList(n);
			actual.setNext(nuevo);
		}else {
			actual = actual.getNext();
			addLinkedListR(n,actual);
		}
	}
	
	public void addBinaryTree(long n) {
		SearchBinaryTree nuevo = new SearchBinaryTree(n);
		if(binaryTree==null) {
			binaryTree = nuevo;
		}else {
			SearchBinaryTree actual = binaryTree;
			if(n<actual.getNum()) {
				
			}
		}
	}
	public ArrayList<Long> getArrayList() {
		return arrayList;
	}

	public LinkedList getLinkedList() {
		return linkedList;
	}

	public SearchBinaryTree getBinaryTree() {
		return binaryTree;
	}
}
