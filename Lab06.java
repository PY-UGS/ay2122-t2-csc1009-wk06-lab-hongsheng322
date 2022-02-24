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
        addAndSort(ll, 14);
  

        //Question 2
        System.out.println("Linked List Before Swapping :-");
  
        for (int i : ll) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Swapping the elements
        // swapValues(ll, 11, 14);
        System.out.println();
  
        System.out.println("Linked List After Swapping :-");
  
        for (int i : ll) {
            System.out.print(i + " ");
        }

        System.out.println();

        // Question 3
        System.out.println(findValue(1000, 9999, 500));

        // Question 4
        Hashtable<Integer, Integer> hm = new Hashtable<>();
        hm.put(1, 10);
        hm.put(2, 11);
        hm.put(3, 13);
        hm.put(4, 14);
        hm.put(5, 15);
        hashAndSort(hm, 12);
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

    // Question 4 - Not a good idea, A map is not meant to be sorted, but accessed fast. To sort the map, We have to create a list to sort it then put it back to the hashmap.
    public static void hashAndSort(Hashtable<Integer, Integer> hashmap, int value){
        System.out.println(hashmap);
        hashmap.put(hashmap.size()+1, value);

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer> >(hashmap.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        System.out.println(hashmap);
    }
}