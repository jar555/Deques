public class LLD {
	public static void main(String[] args) {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		lld1.addFirst(1);
		lld1.addLast(2);
		System.out.println(lld1.get(2));
		lld1.addFirst(0);
		System.out.println(lld1.get(1));
		lld1.addLast(3);
		System.out.println(lld1.get(4));
	}

	public void test(){
		//LinkedListDeque.addFirst(1);
	}
}