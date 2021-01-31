package dkit.sd2.sets;
/**
 * Set  (part of the Java Collections Framework)       Revised:   January 2021
 *
 * A set is a collection that does not allow duplicate elements.
 *
 * There are two concrete class implementations of a set:
 * (1) HashSet and (2) TreeSet
 *
 * HashSet uses a Hash Table for storage,
 * so access, insert and delete are all very fast: O(1)
 * The hashCode() and equals() methods MUST be implemented in the
 * class of the elements being stored as they are both used by the
 * hash table.
 *
 * TreeSet uses a Binary Tree structure, so access is slower O(log n).
 * However, it maintains elements in their "natural ordering",
 * implementing Comparable or by supplying a Comparator.
 *
 * The "Set" interface defines a number of operations common to
 * all Sets.  It is good practice to use a reference of type Set to
 * refer to a HashSet or TreeSet object.
 */


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetsExamples
{

    public static void main(String[] args)
    {
        hashSetOfString();      // HashSet of String objects
//        treeSetOfString();      // TreeSet of String objects, sorts elements
//        treeSetOfBookObjects(); // TreeSet of Books sorted using Comparable - compareTo()
//        treeSetWithComparator();// TreeSet of Books, sorted using a Comparator "ComparatorBookTitleCode"
//        hashSetOfBookObjects(); // HashSet of Book object relies on hascCode() and equals() methods
    }

    public static void hashSetOfString()
    {
        Set<String> names = new HashSet<>();  // note reference of type Set

        // Note that the String class implements the hashCode() and the equals()
        // methods which are required to use a HashSet
        names.add("Zoe");
        names.add("Donald");
        names.add("John");
        names.add("Bill");
        names.add("Bill");  // duplicate element will not be added (nothing happens)
        names.add("Adam");
        names.add("Niamh");
        names.remove("Donald");

        // The contains() method gives fast 'hash table' access O(1)
        // It relies on hashCode() and equals() methods to match elements.
        if (names.contains("John"))
        {
            System.out.println("John is in the set");
        }

        System.out.println("Names from the HashSet - no duplicates, and NOT in order");
        display(names);
    }

    public static void treeSetOfString() // TreeSet - sorted order maintained
    {
        Set<String> cars = new TreeSet<>(); // TreeSet maintains sorted order
        // using a binary tree structure

        // The order of elements here is determined by the compareTo() method
        // of the String class,(String class implements the Comparable interface)
        cars.add("Nissan");
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Audi");  // duplicate will not be added
        cars.add("Jaguar");

        System.out.println("Cars (String) from the TreeSet - no duplicates, sorted in order");
        display(cars);
    }

    public static void treeSetOfBookObjects()
    {
        Set<Book> books = new TreeSet<>();  // TreeSet maintains sorted order
        // using the compareTo() of Book

        // To use a TreeSet to store Book objects, the Book class must implement
        // the Comparable interface and thus override compareTo().
        // (Alternatively, use a Comparator (shown below)).
        // See the compareTo() method in the Book class which compares first on book code
        // and then on title (i.e "title within code")
        books.add(new Book(9999, "Jaws"));
        books.add(new Book(9999, "Jaws"));     // won't be added, NO Duplicates in Set.....
        books.add(new Book(9999, "Stardust"));
        books.add(new Book(2222, "Heist"));
        books.add(new Book(4444, "Alien"));
        books.add(new Book(1111, "Tatoos"));
        books.add(new Book(3333, "Life on Earth"));

        System.out.println("Books from the TreeSet - no duplicates,  in order (by code then title)");

        for (Book book : books)
        {
            System.out.println(book);
        }
        System.out.println("");

//    TODO Add some additional books - Draw the tree that you expect

//        Book b1 = new Book(1111, "Jaws");
//        Book b2 = new Book(9999, "JAws");
//        books.add(b1);
//        books.add(b2);
//        for (Book book : books)
//        {
//            System.out.println(book);
//        }


    }

    public static void treeSetWithComparator()
    {
        // In this sample, TreeSet maintains sorted order
        // using a Comparator called "ComparatorBookTitleCode"
        // This takes priority over the compareTo() method implemented
        // in the Book class.

        Set<Book> books = new TreeSet<>(new ComparatorBookTitleCode());

        books.add(new Book(9999, "Jaws"));
        books.add(new Book(9999, "Jaws"));     // no duplicates, compareTo() used
        books.add(new Book(9999, "Stardust"));
        books.add(new Book(2222, "Heist"));
        books.add(new Book(4444, "Alien"));
        books.add(new Book(1111, "Tatoos"));
        books.add(new Book(3333, "Life on Earth"));

        System.out.println("Books from the TreeSet - no duplicates,  in order "
                + "(sorted by title then code) - Using Comparator");

        for (Book book : books)
        {
            System.out.println(book);
        }

        System.out.println("");

//    TODO Add some additional books - Draw the tree that you expect

//        Book b1 = new Book(1111, "Jaws");
//        Book b2 = new Book(9999, "JAws");
//        books.add(b1);
//        books.add(b2);
//        for (Book book : books)
//        {
//            System.out.println(book);
//        }
    }

    public static void hashSetOfBookObjects()
    {
        Set<Book> books = new HashSet<>();

        // The Book class must implement the hashCode() and equals() methods
        // if Book objects are to be stored in a HashSet. (Both methods
        // are used in the hashing process).
        // Note that NO sorted order is maintained, not even the order they were
        // added in.
        books.add(new Book(9999, "Jaws"));
        books.add(new Book(9999, "Jaws"));     // NO Duplicates allowed in Set
        books.add(new Book(9999, "Stardust"));
        books.add(new Book(2222, "Heist"));
        books.add(new Book(4444, "Alien"));
        books.add(new Book(1111, "Tatoos"));
        books.add(new Book(3333, "Life on Earth"));

        System.out.println("Books from the HashSet - no duplicates,  NO order");

        for (Book book : books)
        {
            System.out.println(book);
        }
    }

    public static void display(Set<String> set) // The interface type 'Set' is used
    {                                            // to accept either HashSet or TreeSet

        System.out.println("Display set using for() loop:");
        for (String s : set)
        {
            System.out.println(s);
        }

        // the above loop is equivalent to using the following iterator
//        System.out.println("Display set using Iterator:");
//
//         Iterator iter = set.iterator();
//         while (iter.hasNext())
//            System.out.println(iter.next());
    }
}
