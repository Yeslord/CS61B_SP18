/** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class LinkedListDeque<T> {	
	private class Node {
		public T item;
		public Node next;
		public Node prev;

		public Node(Node m, T i, Node n) {
			prev=m;
			item = i;
			next = n;
		}
	} 

	/* The first item (if it exists) is at sentinel.next. */
	private Node sentinel;
	private int size;

	/** Creates an empty SLList. */
	public LinkedListDeque() {
		sentinel = new Node(null,null, null);
		sentinel.prev=sentinel;
		sentinel.next=sentinel;
		size = 0;
	}

	public LinkedListDeque(T item) {
		sentinel = new Node(null, null, null);
		Node newNode=new Node(sentinel,item,sentinel);
		sentinel.next = newNode;
		sentinel.prev= newNode;
		size = 1;
	}

 	/** Adds x to the front of the list. */
 	public void addFirst(T item) {
 		Node newFirst = new Node(sentinel,item,sentinel.next);
 		sentinel.next = newFirst;
 		sentinel.next.next.prev = newFirst;
 		size = size + 1;
 	}
 	/** Adds x to the last of the list. */
 	public void addLast(T item) {
 		Node newLast = new Node(sentinel.prev,item,sentinel);
 		sentinel.prev = newLast;
 		sentinel.prev.prev.next = newLast;
 		size = size + 1;
 	}
 	/**Returns true if deque is empty, false otherwise**/
 	public boolean isEmpty() {
 		if (size==0) {
 			return true;
 		}
 		return false;
 	}
 	/**Prints the items in the deque from first to last, separated by a space.**/
 	public void printDeque(){
 		Node p=sentinel;
 		while (p.next!=sentinel) {
 			System.out.println(p.next.item+" ");
 			p=p.next;
 		}

 	}
 	/** Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
 	public T removeFirst(){
 		if (sentinel.next==sentinel){
 			return null;
 		}
 		T out=sentinel.next.item;
 		sentinel.next.next.prev=sentinel;
 		sentinel.next=sentinel.next.next;
 		size=size-1;
 		return out;
 	}
 	/** Removes and returns the item at the last of the deque. If no such item exists, returns null.*/
 	public T removeLast(){
 		if (sentinel.prev==sentinel){
 			return null;
 		}
 		T out=sentinel.prev.item;
 		sentinel.prev.prev.next=sentinel;
 		sentinel.prev=sentinel.prev.prev;
 		size=size-1;
 		return out;
 	}
 	/** Returns the size of the list. */
 	public int size() {
 		return size;
 	}
 	public T get(int index){
 		Node p=sentinel;
 		if (index>=size) {
 			return null;
 		}
 		while (index!=0) {
 			p=p.next;
 			index--;
 		}
 		return p.next.item;
 	}
 	public T getRecursive(int index){
 		Node p=sentinel;
 		if (index>=size) {
 			return null;
 		}
 		else if (index==0) {
 			return p.next.item;
 		}
 		p=p.next;
 		index--;
 		return getRecursive(index);
 	}
	/**public static void main(String[] args) {
 		SLList L = new SLList();
 		L.addLast(20);
 		System.out.println(L.size());
 	}  
 	*/
}