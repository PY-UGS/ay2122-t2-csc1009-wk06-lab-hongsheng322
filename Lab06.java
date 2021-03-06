import java.util.*;

class Lab06 {
    public static void main(String[] args)
    {
  
        LinkedList<Integer> ll = new LinkedList<>();
  
        // Adding elements to Linked List
        ll.add(10);
        ll.add(11);
        ll.add(13);
        ll.add(14);
        ll.add(15);

        //Question 1
        System.out.println("Question 1");
        addAndSort(ll, 12);
  

        //Question 2
        System.out.println("Question 2");
        System.out.println("Linked List Before Swapping :-");
  
        for (int i : ll) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Swapping the elements
        swapValues(ll, 11, 14);
        System.out.println();
  
        System.out.println("Linked List After Swapping :-");
  
        for (int i : ll) {
            System.out.print(i + " ");
        }

        System.out.println();

        // Question 3
        System.out.println("Question 3");
        System.out.println(findValue(1000, 9999, 500));

        // Question 4
        System.out.println("Question 4");
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 10);
        hm.put(2, 11);
        hm.put(3, 13);
        hm.put(4, 14);
        hm.put(5, 15);
        hashAndSort(hm, 12);

        // Question 5
        System.out.println("Question 5");
        System.out.println(hm);
        hashAndSwap(hm, 2, 3);
        System.out.println(hm);

        // Question 6
        System.out.println("Question 6");
        System.out.println(findValueHash(1000, 9999, 500));
    }

    // Question 1
    public static void addAndSort(LinkedList<Integer> list, int value){
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (value < list.get(i))
            {
                list.add(i, value);
                System.out.println(list);
                return;
            }
        }
        list.add(value);
        System.out.println(list);
    }

  
    // Question 2
    public static void swapValues(LinkedList<Integer> list, int indexOne, int indexTwo)
    {
  
        // Getting the positions of the elements
        int index1 = list.indexOf(indexOne);
        int index2 = list.indexOf(indexTwo);
  
        // Returning if the element is not present in the
        // LinkedList
        if (index1 == -1 || index2 == -1) {
            return;
        }
  
        // Swapping the elements
        list.set(index1, indexTwo);
        list.set(index2, indexOne);
    }

    // Question 3
    public static int findValue(int min, int max, int amount){
        LinkedList<Integer> templl = new LinkedList<>();
        for (int i=0; i < amount; i++){   
            Random r = new Random();
            templl.add(r.nextInt((max - min) + 1) + min); 
        }

        //new random variable
        Random r = new Random();
        int var = r.nextInt((max - min) + 1) + min;

        
        for (int i=0; i < amount; i++){   
            if (var == templl.get(i))
            {
                return i;
            }
        }

        return -1;
    }

    // Question 4 A TreeMap is always sorted by the keys. To sort by values, you have to extract them into a List and sort.
    public static void hashAndSort(HashMap<Integer, Integer> hashmap, int value){
        hashmap.put(hashmap.size()+1, value);
        System.out.println(hashmap);

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer> >(hashmap.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() 
        {public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        hashmap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            hashmap.put(aa.getKey(), aa.getValue());
        }
        System.out.println(hashmap);
    }

    //Question 5
    public static void hashAndSwap(HashMap<Integer, Integer> hm, int indexOne, int indexTwo){
        int temp1 = hm.get(indexOne);
        int temp2 = hm.get(indexTwo);
        // Swapping the elements
        hm.put(indexOne, temp2);
        hm.put(indexTwo, temp1);
    }

    //Question 6
    public static int findValueHash(int min, int max, int amount){
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (int i=0; i < amount; i++){   
            Random r = new Random();
            temp.put(i, r.nextInt((max - min) + 1) + min); 
        }

        //new random variable
        Random r = new Random();
        int var = r.nextInt((max - min) + 1) + min;

        Set<Integer> keys = temp.keySet();
        for (Integer key: keys){
            if (var == temp.get(key)){ 
                return key;
            }
        }

        return -1;
    }
}