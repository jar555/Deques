
public class LinkedListDeque<Item> {
	private class Node {
		public Item item;
		public Node next;
		public Node prev;

		public Node(Item i, Node h, Node p) {
			item = i;
			next = h;
			prev = p; 
		}
	}

	private Node sentinel;
	private int size;

	public LinkedListDeque(){
		size = 0;
		sentinel = new Node(null, sentinel, sentinel);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}
	
	/*
	public LinkedListDeque(Item x){
		size = 1;
		sentinel = new Node(null, null, null);
		sentinel.next = new Node(x, sentinel, sentinel);
		sentinel.prev = sentinel.next;
	}
	*/
	

	// Test constructor for testing later on on gradescope.
	private LinkedListDeque(Item x) {
		size = 1;
		sentinel = new Node(x, null, null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	} 

	public void addFirst(Item item) {
		size += 1;
		Node newNode = new Node(item, sentinel.next, sentinel);
		sentinel.next.prev = newNode;
		sentinel.next = newNode;
	}

	public void addLast(Item item) {
		size += 1;
		Node newNode = new Node(item, sentinel, sentinel.prev);
		sentinel.prev.next = newNode;
		sentinel.prev = newNode;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		Node originalPointer = sentinel.next;
		for (int i = 0; i != size; i++){
			System.out.print(" " + sentinel.next.item);
			sentinel.next = sentinel.next.next;
		}
		sentinel.next = originalPointer;
	}

	public Item removeFirst(){
		if (size == 0 ) {
			return null;
		}
		Item originalItem = sentinel.next.item;
		size -= 1;
		sentinel.next.item = null;
		sentinel.next = sentinel.next.next; 
		sentinel.next.prev = sentinel;
		return originalItem;
	}

	public Item removeLast(){
		if (size == 0) {
			return null;
		}
		Item originalItem = sentinel.prev.item;
		size -= 1;
		sentinel.prev.item = null;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		return originalItem;
	}

	public Item get(int index) {
		index += 1;
		if (index > size + 1) {
			return null;
		}
		Node originalPointer = sentinel;
		Item item;
		for (int i = 0; i != index; i++) {
			sentinel = sentinel.next;
		}
		item = sentinel.item;
		sentinel = originalPointer;
		return item;
	}
	
	private Item helperGet(int index, Node n){
		if (index == 0) {
			return n.item;
		} 
		n = n.next;
		return helperGet(index - 1, n);
	}

	public Item getRecursive(int index){
		return helperGet(index, sentinel.next);
	}
	
	
	public static void main(String[] args) {
   		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>(2);
    	lld1.addFirst(3);
    	lld1.addLast(5);
      	lld1.addFirst(10);
     	System.out.println(lld1.get(2));
      	lld1.addFirst(4);
      	System.out.println(lld1.get(4));
      	System.out.println(lld1.get(2));
      	System.out.println(lld1.get(1));
      	System.out.println(lld1.get(0));


   }

}
