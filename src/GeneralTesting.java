import java.util.Comparator;

public class GeneralTesting {
    public static void main(String[] args) {
        test_4();
    }

    public static void test_4 () {
        Comparator<Integer> c = new IntegerComparator();

        BinarySearchTree<Integer> t1 = new BinarySearchTree<>(c);
        t1.insert(5);
        t1.insert(6);
        t1.insert(7);
        t1.insert(8);

        System.out.println("----------t1:----------" + "\n" + t1);



//        BinarySearchTree<Integer> t2 = new BinarySearchTree<>(c);
//        t2.insert(8);
//        t2.insert(6);
//        t2.insert(4);
//        t2.insert(2);
//        t2.insert(7);
//        t2.insert(5);
//        t2.insert(3);
//        t2.insert(1);
//        System.out.println("----------t2:----------\n" + t2);
    }
}
