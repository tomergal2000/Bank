import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount> {

    public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
        super(myComparator);
    }

    // Complete the following methods
    public void balance() {
        //create inOrder list & remove all accounts from tree
        List<BankAccount> list = new DynamicArray<>();
        for (BankAccount account : this) {
            list.add(account);
            remove(account);
        }
        // send list to recursive function
        buildBalancedTree(list, 0, list.size() - 1);
    }

    private void buildBalancedTree(List<BankAccount> list, int low, int high) {
        if (low <= high) { //base case
            int middle = (low + high) / 2;
            insert(list.get(middle)); // insert subtree's root
            buildBalancedTree(list, low, middle - 1); // insert left subtree
            buildBalancedTree(list, middle + 1, high); // insert right subtree
        }
    }
}
