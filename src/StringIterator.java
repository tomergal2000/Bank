import java.util.Iterator;

public class StringIterator implements Iterator<String> {
    //Fields
    private String next;
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //Complete the following methods
    public StringIterator(String start) {
        // task 0
        //input check:
        for (char c : start.toCharArray()) {
            if (!(letter(c)))
                throw new IllegalArgumentException("One of the characters is not a letter");
        }
        next = start;
    }

    //function that helps to make sure input is legal
    private boolean letter(char c) {
        return alphabet.indexOf(c) != -1;
    }

    public boolean hasNext() {
        // task 0
        if (next.length() < Integer.MAX_VALUE)
            return true;

        else {
            for (char c : next.toCharArray()) {
                if (c != 'Z')
                    return true;
            }
            return false;
        }
    }

    public String next() {

        String current = next;

        if (!hasNext())
            throw new UnsupportedOperationException("reached end");

        if (next.isEmpty())
            next = "a";

        else {
            char lastChar = next.charAt(next.length() - 1);
            if (lastChar != 'Z')
                next = next.substring(0, next.length() - 1) + incrementSimple(lastChar);
            else
                incrementComplex();
        }

        return current;
    }

    //function that "increments" last character in next
    private char incrementSimple(char current) {

        char incremented;

        if (current == 'z')
            incremented = 'A';
        else
            incremented = (char) (current + 1);

        return incremented;
    }

    //function that "increments" when last character of next is 'Z'
    private void incrementComplex() {

        char[] arr = next.toCharArray();
        boolean isZ = true;
        boolean allIsZ = false;

        for (int i = arr.length - 1; i >= 0 & isZ; i = i - 1) {

            //treat first letter reached that is not 'Z'
            if (arr[i] != 'Z') {
                arr[i] = incrementSimple(arr[i]);
                isZ = false; // --> exit loop
            } else {
                arr[i] = 'a';
            }

            if (i == 0 && isZ)
                allIsZ = true;
        }

        next = new String(arr);

        if (allIsZ) //if next began as "ZZZ...Z", we need to return 'a' + "aaa...a"
            next = "a" + next;
    }

}
