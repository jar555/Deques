public class ArrayDeque<Item> {
	private Item[] items;
	private int front;
	private int back;
	private int size;
	private int rfactor = 3;

	public ArrayDeque() {
		items = (Item []) new Object[5];
		size = 0;
		front = 0;
		back = 1;
	}

	private void resize(int capacity) {
		Item[] newArray = (Item []) new Object[capacity];
		if (front >= back) {
			System.arraycopy(items, front, newArray, 1, size-front);
			System.arraycopy(items, 0, newArray,size-front+1, front);
         items = newArray;
         front = 0;
         back = size+1;
		} else {
			System.arraycopy(items, front, newArray, 0, size);
         items = newArray;
         back = size+1;
		}
	}

	public void addFirst(Item item){
		if (items[front] == null){
			items[front] = item;
			size += 1;
		} else if (front != back) {
			if (front == 0) {
				front = items.length - 1;
				items[front] = item;
				size += 1;
			} else {
				front -= 1;
				items[front] = item;
				size += 1;
			}
		} else {	
			resize(size*rfactor);
			items[0] = item;
		}
	}

	public void addLast(Item item) {
		if (items[back] == null) {
			items[back] = item;
			size += 1;
			if (back == items.length - 1) {
				back = 0;
			} else {
				back += 1;
			}
		} else if (back - 1 == front) {
			resize(size*rfactor);
         items[size] = item;
         size += 1;
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
				index = front;
			} else {
				index += 1;
			}
		}

		return items[index];
	}
	
   public static void main(String[] args) {
      ArrayDeque2<Integer> ad = new ArrayDeque2<Integer>();
      ad.addLast(1);
      ad.addLast(2);
      ad.addFirst(3);
      ad.addFirst(4);
      ad.addLast(5);
      ad.addFirst(6);

   }	
   

}