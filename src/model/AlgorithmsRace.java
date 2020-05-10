package model;

import java.util.ArrayList;
import java.util.Random;

public class AlgorithmsRace {
	private ArrayList<Long> arrayList;
	private LinkedList linkedList;
	private SearchBinaryTree binaryTree;
	
	//private ArrayList<Long> listLongN;
	private double progress;
	
	public AlgorithmsRace() {
		arrayList=new ArrayList<Long>();
		//listLongN=new ArrayList<Long>();
		linkedList=null;
		binaryTree=null;
		progress = 0;
	}
	
	public void startRace(int algorithm, int mode, int data,long n) {
		/*System.out.println("Teoria:");
		System.out.println("algotirhm "+algorithm);
		System.out.println("data:"+data);
		System.out.println("N:"+n);
		*/
		Random rnd = new Random();
		long k=0;
		if(mode ==1) {
			switch(data) {
			case 1:
				switch(algorithm) {
				case 1:
					
					for (int i = 0; i < n; i++) {
						
						k= rnd.nextLong();
						addArrayList(k);
					}
					break;
				case 2:
					for (int i = 0; i < n; i++) {
						
						k= rnd.nextLong();
						searchArrayList(k);
					}
					break;
				case 3:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						delateArrayList(k);
					}
					break;
				}
				break;	
			case 2:
				switch(algorithm) {
				case 1:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						addLinkedList(k);
					}
					break;
				case 2:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						searchLinkedList(k);
					}
					break;
				case 3:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						delateLinkedList(k);
					}
					break;
				}
				break;
			case 3:
				switch(algorithm) {
				case 1:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						addBinaryTree(k);
					}
					break;
				case 2:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						searchBinaryTree(k);
					}
					break;
				case 3:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						delateBinaryTree(k);
					}
					break;
				}
			}
		}else if(mode ==2) {
			switch(data) {
			case 1:
				switch(algorithm) {
				case 1:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						addArrayList(k);
					}
					break;
				case 2:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						searchArrayListR(k);
					}
					break;
				case 3:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						delateArrayListR(k);
					}
					break;
				}
				break;
			case 2:
				switch(algorithm) {
				case 1:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						addLinkedListR(k);
					}
					break;
				case 2:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						searchLinkedListR(k);
					}
					break;
				case 3:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						delateLinkedListR(k);
					}
					break;
				}
				break;
			case 3:
				switch(algorithm) {
				case 1:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						addBinaryTreeR(k);
					}
					break;
				case 2:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						searchBinaryTreeR(k);
					}
					break;
				case 3:
					for (int i = 0; i < n; i++) {
						k= rnd.nextLong();
						delateBinaryTreeR(k);
					}
					break;
				}
			}
		}
		if(algorithm==1) {
			arrayList = new ArrayList<Long>();
		}else if(algorithm==2) {
			linkedList = null;
		}else {
			binaryTree = null;
		}
	}
	
	public void prepareRace(long n) {
		Random rnd = new Random();
		
		
		for (int i = 0; i < n; i++) {
			long k = rnd.nextLong();
			arrayList.add(k);
			addLinkedList(k);
			addBinaryTree(k);
		}
		
	}
	
	public void addArrayList(long n) {
		arrayList.add(n);
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
			
			while(true) {
				if(n<actual.getNum()) {
					if(actual.getLeft()!=null) {
						actual = actual.getLeft();
					}else {
						actual.setLeft(nuevo);
						break;
					}
				}else {
					if(actual.getRight()!=null) {
						actual = actual.getRight();
					}else {
						actual.setRight(nuevo);
						break;
					}
				}
			}
		}
	}
	
	public void addBinaryTreeR(long n) {
		if(binaryTree==null) {
			binaryTree = new SearchBinaryTree(n);
		}else {
			addBinaryTreeR(n,binaryTree);
		}
		
	}
	private void addBinaryTreeR(long n,SearchBinaryTree actual) {
		SearchBinaryTree nuevo = new SearchBinaryTree(n);
		if(n<actual.getNum()) {
			if(actual.getLeft()!=null) {
				addBinaryTreeR(n,actual.getLeft());
			}else {
				actual.setLeft(nuevo);
			}
		}else {
			if(actual.getRight()!=null) {
				addBinaryTreeR(n,actual.getRight());
			}else {
				actual.setRight(nuevo);
			}
		}
	}
	
	public boolean searchArrayList(long n) {
		boolean result = false;
		for (int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i)==n) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public boolean searchArrayListR(long n) {
		if(arrayList.size()==0) {
			return false;
		}else {
			return searchArrayListR(n,arrayList.size()-1);
		}
	}
	
	private boolean searchArrayListR(long n, int i) {
		if(arrayList.get(i)==n) {
			return true;
		}else {
			if(i>0) {
				return searchArrayListR(n,i-1);
			}
			return false;
		}
	}
	
	public boolean searchLinkedList(long n) {
		LinkedList actual = linkedList;
		boolean result = false;
		while(actual!=null) {
			if(actual.getNum()==n) {
				result = true;
				break;
			}else {
				actual = actual.getNext();
			}
		}
		return result;
	}
	
	public boolean searchLinkedListR(long n) {
		if(linkedList==null) {
			return false;
		}else {
			LinkedList actual = linkedList;
			return searchLinkedListR(n,actual);
		}
	}
	
	private boolean searchLinkedListR(long n, LinkedList actual) {
		if(actual==null) {
			return false;
		}
		if(actual.getNum()==n) {
			return true;
		}else {
			actual = actual.getNext();
			return searchLinkedListR(n,actual);
		}
	}
	
	public boolean searchBinaryTree(long n) {
		Boolean result = false;
		if(binaryTree==null) {
			return false;
		}else {
			SearchBinaryTree actual = binaryTree;
			while(actual!=null) {
				if(n<actual.getNum()) {
					actual = actual.getLeft();
				}else if(n>actual.getNum()){
					actual = actual.getRight();
				}else {
					result = true;
				}
			}
		}
		return result;
	}
	
	public boolean searchBinaryTreeR(long n) {
		return searchBinaryTreeR(n,binaryTree);
	}
	
	private boolean searchBinaryTreeR(long n,SearchBinaryTree actual) {
		if(actual==null) {
			return false;
		}
		if(n<actual.getNum()) {
			actual = actual.getLeft();
		
		}else if(n>actual.getNum()){
			actual = actual.getRight();
		}else {
			return true;
		}
		return searchBinaryTreeR(n,actual);
	}
	
	public boolean delateArrayList(long n) {
		boolean result = false;
		for (int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i)==n) {
				arrayList.remove(i);
				result = true;
				break;
			}
		}
		return result;
	}
	
	public boolean delateArrayListR(long n) {
		if(arrayList.size()>0) {
			return delateArrayListR(n,arrayList.size()-1);
		}else {
			return false;
		}
	}
	
	private boolean delateArrayListR(long n,int i) {
		if(arrayList.get(i)==n) {
			return true;
		}
		if(i>0) {
			return delateArrayListR(n,i-1);
		}else {
			return false;
		}
		
		
	}
	
	public boolean delateLinkedList(long n) {
		LinkedList actual = linkedList;
		boolean result = false;
		if(actual.getNum()==n) {
			linkedList = linkedList.getNext();
		}else {
			LinkedList prev = actual;
			actual = actual.getNext();
			while(actual!=null && result ==false) {
				if(actual.getNum()==n) {
					prev.setNext(actual.getNext());
					result = true;
				}else {
					prev = actual;
					actual = actual.getNext();
				}
			}
		}
		return result;
		
	}
	
	public boolean delateLinkedListR(long n) {
		if(linkedList==null) {
			return false;
		}else {
			if(linkedList.getNum()==n) {
				linkedList = linkedList.getNext();
				return true;
			}else {
				LinkedList actual = linkedList.getNext();
				LinkedList prev = linkedList;
				return delateLinkedListR(n,actual,prev);
			}	
		}
	}
	
	private boolean delateLinkedListR(long n, LinkedList actual,LinkedList prev) {
		if(actual == null) {
			return false;
		}
		if(actual.getNum()==n) {
			prev.setNext(actual.getNext());
			return true;
		}else {
			prev = actual;
			actual = actual.getNext();
			return delateLinkedListR(n,actual,prev);
		}
	}
	
	public boolean delateBinaryTree(long n) {
		SearchBinaryTree actual = binaryTree;
		boolean result = false;
		SearchBinaryTree delate=null; 
		while(actual!=null && result ==false) {
			if(actual.getNum()==n){
				delate = actual;
			}
		}
		SearchBinaryTree prev=null;
		if(actual.getRight()!=null) {
			actual = actual.getRight();
		}else if(actual.getLeft()!=null) {
			actual = actual.getLeft();
		}else {
			actual = null;
			delate = null;
		}
		if(delate!=null) {
			while(actual.getRight()!=null) {
				prev = actual;
				actual = actual.getRight();
			}
			if(prev!=null) {
				prev.setRight(actual.getLeft());
				actual.setLeft(delate.getLeft());
				actual.setRight(delate.getRight());
				delate = null;
				if(binaryTree==null) {
					binaryTree = actual;
				}
			}else {
				binaryTree = null;
			}
			result = true;
		}
		
		return result;
	}
	
	public boolean delateBinaryTreeR(long n) {
		boolean result = false;
		if(binaryTree==null) {
			return false;
		}else {
			SearchBinaryTree delate = delateBinaryTreeRB(n,binaryTree);
			if(delate!=null) {
				result = true;
				SearchBinaryTree actual = delate;
				if(actual.getRight()!=null) {
					actual = actual.getRight();
				}else if(actual.getLeft()!=null) {
					actual = actual.getLeft();
				}else {
					actual = null;
					delate = null;
				}
				if(delate!=null) {
					actual = delateBinaryTreeRR(actual,delate);
					actual.setLeft(delate.getLeft());
					actual.setRight(delate.getRight());
					delate = null;
				}
				
			}
		}
		return result;
	}
	
	private SearchBinaryTree delateBinaryTreeRB(long n,SearchBinaryTree actual) {
		if(actual==null) {
			return actual;
		}
		if(n<actual.getNum()) {
			actual = actual.getLeft();
		
		}else if(n>actual.getNum()){
			actual = actual.getRight();
		}else {
			return actual;
		}
		return delateBinaryTreeRB(n,actual);
	}
	
	private SearchBinaryTree delateBinaryTreeRR(SearchBinaryTree actual, SearchBinaryTree prev) {
		if(actual.getRight()==null) {
			prev.setRight(actual.getLeft());
			return actual;
		}
		prev = actual;
		actual = actual.getRight();
		return delateBinaryTreeRR(actual,prev);
	}
	
	public double progressBar(long n, long k) {
		return n/k;
	}

	public double getProgress() {
		return progress;
	}
	
	
}
