public class TestStringIterator {

	public static void main(String[] args) {
		StringIterator iter = new StringIterator("");
		for (int i = 1; i < 9000; i = i + 1) {
			System.out.println(iter.next());
		}
	}

}
