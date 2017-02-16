public class ArrayDeque<Item> {
	private Item[] items;
	private int front;
	private int back;
	private int size;

	public ArrayDeque() {
		items = (Item []) new Object[8];
		size = 0;
		front = 0;
		back = 1;
	}

	public void addFirst(Item item){
		size += 1;
		items[front] = item;
		if (front == 0) {
			front = items.length-1;
		} else {
			front -= 1;
		}
	}

	public void addLast(Item item) {
		size += 1;
		items[back] = item;
		if (back == items.length-1) {
			back = 0;
		} else {
			back += 1;
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
		if (front + 1 >= items.length) {
			front = 0;
			Item item = items[front];
			items[front] = null;
			size -= 1;
			return item;
		} 
		Item item = items[front + 1];
		items[front + 1] = null;
		front += 1;
		size -= 1;
		return item;
	}

	public Item removeLast(){
		if (back - 1 >= items.length) {
			back = 0;
			Item item = items[back];
			items[back] = null;
			size -= 1;
			return item;
		} 
		Item item = items[back - 1];
		items[back - 1] = null;
		back -= 1;
		size -= 1;
		return item;
	}

	public Item get(int index){
		while (items[index] == null) {
			if (index > items.length - 1) {
				index = fron;
			} else {
				index += 1;
			}
		}

		return items[index];
	}
	/*
   public static void main(String[] args) {
      ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
      ad.addFirst(2);

   }	
   */

}