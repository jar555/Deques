public class ArrayDeque2<Item> {
	private Item[] items;
	private int front;
	private int back;
	private int size;
	private int fill;
	private final int rfactor = 3;

	public ArrayDeque2() {
		items = (Item []) new Object[5];
		size = 5;
		front = 0;
		back = -1;
		fill = 0;
	}

	private void resize(int capacity) {
		Item[] newArray = (Item []) new Object[capacity];
		int index = 0;
		back += 1;
		int trueBack = Math.floorMod(back, size);

		while (back != front) {
			newArray[index] = items[trueBack];
			back += 1;
			index += 1;
			trueBack = Math.floorMod(back, size);
		}
		items = newArray;
		front = size;
		back = -1;
		size = capacity;
	}

	public void addFirst(Item item){
		if (fill == size) {
			resize(size * rfactor);
		}
		items[front] = item;
		front += 1;
		fill += 1;
	}

	public void addLast(Item item) {
		if (fill == size) {
			resize(size * rfactor);
		}
		int trueBack = Math.floorMod(back, size);
		items[trueBack] = item;
		back -= 1;
		fill += 1;
	}

	public boolean isEmpty(){
		if (size == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return this.size;
	}

	public void printDeque(){
		int index = 0;
		while (index <= items.length - 1) {
			System.out.print(" " + items[index]);
			index ++;
		}
		System.out.println();
	}

	public Item removeFirst(){
		if (front - 1 < 0) {
			return null;
		}
		front -= 1;
		Item item = items[front];
		items[front] = null;
		fill -= 1;

		return item;
	}

	public Item removeLast(){
		if (fill == 0) {
			return null;
		}
		back += 1;
		int trueBack = Math.floorMod(back, size);
		Item item = items[trueBack];
		items[trueBack] = null;
		fill -= 1;

		return item;
	}

	public Item get(int index){
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
      ad.addLast(7);
      ad.addFirst(8);
      ad.printDeque();
      ad.removeLast();
      ad.printDeque();
      ad.addLast(9);
      ad.printDeque();
      System.out.println(ad.removeLast());
      ad.printDeque();
      System.out.println(ad.removeLast());
      ad.printDeque();
      System.out.println(ad.removeLast());
      ad.printDeque();
      System.out.println(ad.removeFirst());
      ad.printDeque();
      ad.addFirst(11);
      ad.printDeque();
   }
}
