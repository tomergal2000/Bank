import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilteredBankAccountsIterator implements Iterator<BankAccount> {

    private BinaryTreeInOrderIterator<BankAccount> iterator;
    private Filter<BankAccount> filter;
//    private BankAccount current;
    private BankAccountsBinarySearchTree filteredTree; //tree that contains only filtered accounts

    public FilteredBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree, Filter<BankAccount> filter) {
        this.filter = filter;
        filteredTree = new BankAccountsBinarySearchTree(bankAccountsTree.comparator);
        //initialize filtered tree
        for (BankAccount account : bankAccountsTree) {
            if (filter.accept(account))
                filteredTree.insert(account);
        }
        iterator = new BinaryTreeInOrderIterator<>(filteredTree.root);
        //note that we don't even need 'current' field because it's already in BinaryTreeInOrderIterator
    }


    //Complete the following method
    @Override
    public boolean hasNext() {
            return iterator.hasNext();
    }

    //Complete the following method
    @Override
    public BankAccount next() {
        return iterator.next();
    }
}
