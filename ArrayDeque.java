public class ArrayDeque<Item> {
	private Item[] items;
	private int front;
	private int modFront;
	private int back;
	private int modBack;
	private int size;
	private int rfactor = 2;
	private double r;

	public ArrayDeque() {
		items = (Item []) new Object[8];
		size = 0;
		front = 0;
		back = 0;
	}

	private void resize(int capacity) {
		Item[] newArray = (Item[]) new Object[capacity];
		System.arraycopy(items, 0, newArray, back, size);

	}


	private void usage(){
		r = size/items.length;
	}

	private void usageCheck(){
		usage();
		if  (r < 0.25 && items.length > 16) {
			resize(items.length/2);
		}
	}

	private static int mod(int dividend, int divisor) {
			return java.lang.Math.floorMod(dividend, divisor);
	}

	public void addFirst(Item item){
		if (size == 0 && front == back) {
			items[front] = item;
			frontCheck();
			backCheck();
		} else if (front == back) {
			resize(size*rfactor);
			items[front] = item;
			frontCheck();
		} else {
			items[front] = item;
			frontCheck();
		}
		size += 1;
	}

	public void addLast(Item item) {
		if (size == 0 && front == back) {
			items[front] = item;
			frontCheck();
			backCheck();
		} else if (front == back) {
			resize(size*rfactor);
			items[back] = item;
			backCheck();
		} else {
			items[back] = item;
			backCheck();
		}
		size += 1;
	}

	private void frontCheck(){
		front -= 1;
		if (front < 0) {
			front = items.length - 1;
		}
	}

	private void backCheck(){
		back += 1;
		if (back >= items.length -1) {
			back = 0;
		} 
	}


	public boolean isEmpty(){
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return size;
	}

	public void printDeque(){
		int index = 0;
		while (index < items.length-1) {
			System.out.print(" " + items[index]);
			index ++;
		}

	}

	public Item removeFirst(){
		Item item;
		modFront = ((front+1) % items.length);
		item = items[modFront];
		items[modFront] = null;
		size -=1;
		front = modFront;
		usageCheck();
		return item;
	}

	public Item removeLast(){
		Item item;
		if (items[back] == null) {
			if (back >= items.length) {
				back = 0;
			} else {
				back -= 1;
			}
		}
		item = items[back];
		items[back] = null;
		size -= 1;
		usageCheck();
		return item;
		
	}

	public Item get(int index){
		modFront = ((front+1) % items.length);
		return items[(modFront + 1) % items.length];
	}
	
	//java visualiser tests
	

   public static void main(String[] args) {
      	ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        ad.addLast(0);
      	ad.addLast(4);
      	ad.addLast(5);
      	ad.addFirst(1);
      }
      
}