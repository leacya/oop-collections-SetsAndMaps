package dkit.sd2.maps;


/**
 * Map Interface Updated: Jan 2021 Implemented by HashMap and TreeMap classes
 *
 * A Map is a Data Structure that allows us to associate a Key with a Value.
 * e.g. A name with a favorite film "John" -> "StarWars" or a class group with a
 * list of students: "SD2A" -> "Anne", "John",.. When we add an entry to a map
 * we provide both the Key and the Value. To retrieve a Value, we must provide
 * the Key.
 *
 * This is often called a "Key:Value" pair.
 *
 * A Map stores both the Keys and the Values. Key and Value must be object types
 * (not primitive types, so Integer rather than int) The Key class must
 * implement methods hashCode() and equals() [or inherit them]
 *
 * String and Integer are the most effective and preferred Key types. Keys must
 * be unique (no duplicate keys are allowed) A Map can be implemented as a
 * HashMap or a TreeMap.
 *      HashMap is fastest for put() and get() (but no ordering) O(1)
 *      TreeMap maintains a sorted order based on the "natural
 *              ordering" of the Key elements (defined by compareTo()) or based on a
 *              Comparator supplied in the Map constructor O(log n)
 *
 * Maps are commonly used to pass data around within a program, so it is
 * important to understand them.
 */
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MapSamples
{

    public static void main(String[] args)
    {
        map1();     // HashMap: String=>String
//        map2();     // HashMap: String=>Integer
//        map3();     // HashMap: Long=>Book
//        map4();     // HashMap: String=>ArrayList
//        map5();     // Passing Map as argument into a method
//        map6();     // TreeMap: Long=>Book
//        map7();     // HashMap: (Student=>Book)
//        map8();     // HashMap: (String=>HashMap<String,String>
    }

    public static void map1()  // HashMap: String => String
    {
        Map<String, String> map = new HashMap<>();

        map.put("John", "Alien");
        map.put("Anne", "LaLa Land");
        map.put("Zoe", "Alien");
        map.put("Zoe", "Trainspotting");  // replaces previous entry


        String favourite = map.get("Anne");  // use Key to get Value
        System.out.println("Anne's favourite film is: " + favourite);

        // Get all keys from the Map (Set used because keys are unique)
        Set<String> keySet = map.keySet();  // get all keys

        //Print the contents of the keySet
        System.out.println("Contents of Keyset");
        for (String name : keySet)
        {
            System.out.print(name + ", ");
        }

        //Use keys from keySet to get each value from the Map
        System.out.println("\n\nMap<Key:Value> pairs");
        for (String key : keySet)
        {
            String film = map.get(key);   // get value associated with key
            System.out.println(key + " : " + film);
        }

        System.out.println("\nAlternative way to output all entries in a Map");
        // note that a map stores both the key and the value as a entry
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            String name = entry.getKey();
            String film = entry.getValue();
            System.out.println("Person: " + name + ", Film: " + film);
        }

//        TODO
//       1 How would you remove "John" from the Map?
//       2 What happens when you put an entry into map but use a "key" that is already there?
//       3 What happens when you put an entry into map but use a "value" that is already there?
//       4 What happens when you remove an entry from the keySet of a map (e.g. on line# 67)

//        Examine Java API for Map Interface and HashMap Class

//       5 (a) Write code to prompt user to enter a name and display the corresponding favourite film.
//         (b) Display appropriate message if name's film details are not in the map

//       6 (a) Write code to prompt for entry of a film name and display IF anyone has this a a favourite film.
//         (b) Display the name of the person.
//         (c) Is this a good use of a Map - explain.

    }

    public static void map2()
    {
        // Keys and Values must be object types.
        // Primitive types such as 'int' values will be converted
        // automatically to Integer objects. (called Autoboxing)
        Map<String, Integer> ageMap = new HashMap<>();

        ageMap.put("John", 18); // int values automatically converted to Integer
        ageMap.put("Anne", 19);
        ageMap.put("Adam", 17);
        ageMap.put("Adam", 99);   // repeated key, value 99 replaces 17

        Set<String> keySet = ageMap.keySet();  // get all keys

        // Retrieve all values using key values
        for (String key : keySet)
        {
            int value = ageMap.get(key);
            System.out.println(key + " : " + value);
        }

        String key = "Anne";
        if (ageMap.containsKey(key))
        {
            System.out.println("ageMap contains the key" + key + " with value " + ageMap.get(key));
        }
        else
        {
            System.out.println("ageMap does NOT contain the key " + key);
        }
    }

    public static void map3()
    {
        // Map a Long integer (8-bytes) to a Book object
        Map<Long, Book> bookMap = new HashMap<>();

        bookMap.put(200034L, new Book(30004, "Fight Club")); // long values automatically converted to Long
        bookMap.put(600035L, new Book(40023, "Jaws"));
        bookMap.put(222222L, new Book(55523, "White Teeth"));
        bookMap.put(222222L, new Book(66623, "Ted"));  // repeated key, Book entry is updated with new value

        Set<Long> keySet = bookMap.keySet();

        for (Long key : keySet)
        {
            Book book = bookMap.get(key);
            System.out.println(key + " Title: "
                    + book.getTitle() + ", Code:" + book.getCode());
        }
    }

    public static void map4()
    {
        // Map: Name (String) => ArrayList object (containing list of names)
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();

        // each entry will require a separate ArrayList
        ArrayList<String> listOfFriends = new ArrayList<>();
        listOfFriends.add("Kylie");
        listOfFriends.add("Donald");
        friendsMap.put("John", listOfFriends);  // put entry (String->ArrayList)

        listOfFriends = new ArrayList<>();  // new arraylist for Julie's friends
        listOfFriends.add("Barak");
        listOfFriends.add("James");
        listOfFriends.add("Megan");
        friendsMap.put("Julie", listOfFriends);

        // Print all keys and values in the map
        for (Map.Entry<String, ArrayList<String>> entry : friendsMap.entrySet())
        {
            String key = entry.getKey();
            ArrayList<String> list = entry.getValue();
            System.out.println("Person: " + key + ", Friends: " + list);
        }

        // Print all keys and values in the map (alternative way)
         Set<String> keySet = friendsMap.keySet(); // get all keys

         List<String> list;  // reference for returned list of friends

         for (String key : keySet)
         {
             list = friendsMap.get(key); // gets back a List
             System.out.println(key + " : " + list);
         }


//      TODO
//      7  Add another friend to Julie's list
//      8 Display name of person who has most friends; Also display their friends names



    }

    public static void map5()   // demonstrates passing a Map as an argument
    {
        Map<Long, Book> bookMap = new HashMap<>();

        bookMap.put(200034L, new Book(30004, "Fight Club")); // long int values automatically converted to Integer
        bookMap.put(600035L, new Book(40023, "Jaws"));
        bookMap.put(222222L, new Book(55523, "White Teeth"));
        bookMap.put(222222L, new Book(66623, "Ted"));  // duplicate, overwrites existing one

        ArrayList<Book> bookList;

        bookList = getShortTitledBooks(bookMap, 4); // pass a Map as an argument

        System.out.println("Books with short titles (<=4 characters)");
        for (Book book : bookList)
        {
            System.out.println(" Title: "
                    + book.getTitle() + ", Code:" + book.getCode());
        }
    }

    public static ArrayList<Book> getShortTitledBooks(Map<Long, Book> bookMap, int maxLengthOfTitle)
    {
        // parameter bookMap is a reference to the original map

        ArrayList<Book> bookList = new ArrayList<>(); // list to store the result

        Set<Long> keySet = bookMap.keySet();

        for (Long key : keySet)
        {
            Book book = bookMap.get(key);
            if (book.getTitle().length() <= maxLengthOfTitle)
            {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public static void map6()   // TreeMap - maintains sorted order based on compareTo() of String class
    {
        TreeMap<Long, Book> bookMap = new TreeMap<>();

        bookMap.put(200034L, new Book(30004, "Fight Club")); // long values automatically converted to Long
        bookMap.put(600035L, new Book(40023, "Jaws"));
        bookMap.put(222222L, new Book(55523, "White Teeth"));
        bookMap.put(222222L, new Book(66623, "Ted"));  // duplicate

        System.out.println("TreeMap");
        System.out.println("Note that output should be in order of Key");

        Set<Long> keySet = bookMap.keySet();

        for (Long key : keySet)
        {
            Book book = bookMap.get(key);
            System.out.println("Key: " + key
                    + book.getTitle() + ", Code:" + book.getCode());
        }
    }

    public static void map7()  // Map (Student => Book )
    {
        // Student class is used as the Key in this case,
        // so, it must implement hashCode() and equals()

        Map<Student, Book> favouriteBook = new HashMap<>();

        Student tom = new Student(1001, "Tom Malone");
        Book book1 = new Book(30004, "Lazy Days");
        favouriteBook.put(tom, book1);

        Student zoe = new Student(2002, "Zoe Salanda");
        Book book2 = new Book(40023, "Columbiana");
        favouriteBook.put(zoe, book2);

        Set<Student> keySet = favouriteBook.keySet(); // get keys

        System.out.println("Student=>Book mappings");
        // Print all keys and values in the map
        for (Student key : keySet)
        {
            Book book = favouriteBook.get(key);
            System.out.println(key + " loves : " + "Title: "
                    + book.getTitle() + ", Code:" + book.getCode());
        }
    }

    /**
     * This sample maps String to HashMap<String,String>
     * representing a mapping of a name to a Map of attributes [ 1 : Many ]
     */
    public static void map8()   // map: Name (String) => Attributes (Map)
    {
        HashMap<String, HashMap<String, String>> userMap = new HashMap<>();

        HashMap<String, String> attributesMap = new HashMap<>();
        // HashMap for John's attributes
        attributesMap.put("Hair", "Red");
        attributesMap.put("Height", "1.76");
        userMap.put("John", attributesMap);

        attributesMap = new HashMap<>();    // new hashmap for Alice's attributes
        attributesMap.put("Hair", "Black");
        attributesMap.put("Height", "1.76");
        attributesMap.put("Age", "21");
        userMap.put("Alice", attributesMap);

// Note: if you use Map interface type, then you will have to cast the
// reference to a HashMap type.
//  i.e.  userMap.put("Alice", (HashMap<String,String>)attributesMap);
        // Print all keys and values in the map
        Set<String> keySet = userMap.keySet(); // get all keys

        for (String userName : keySet)
        {
            attributesMap = userMap.get(userName);
            System.out.println("User: " + userName);

            Set<String> attributeSet = attributesMap.keySet();

            for (String attributeName : attributeSet)
            {
                System.out.println(attributeName
                        + " : " + attributesMap.get(attributeName));
            }

            attributesMap.clear();
        }
    }
}

