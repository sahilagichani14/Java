package comparable_vs_comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        /*
         * 1- Difference btw Comparable(compare objects based on single property) &
         * Comparator(can compare based on multiple property), if we pass Comparator object in sort then it has more priority
         */
        ArrayList<StudentComparable> ar = new ArrayList<StudentComparable>();
        ar.add(new StudentComparable(1, "Sahil", 16.60));
        ar.add(new StudentComparable(5, "Aditya", 15.00));
        ar.add(new StudentComparable(3, "Ritwik", 19.70));
        Collections.sort(ar);
//        Collections.sort(ar, new StudentComparator());
        System.out.println(ar);

        /*
         * 2 - Equals class do refernce comparision so compare 2707 ie 2707 --> hashcode
         * or address of obj stored, s1=new Obj so s1 is reference 2707 storing address
         * of obj
         */
        StudentComparable sc1 = new StudentComparable(2, "Sahil Agichani", 122);
        StudentComparable sc2 = new StudentComparable(4, "Sahil Singh", 142);
        System.out.println(sc1.equals(sc2)); //this will compare based on roll number not reference since we overrided

        /* 3 - hashmap has intial 16 buckets & 12 threshold value for initial map,
         * acc to key it cal hash value let say 112 then index is cal by hash&(n-1) let say 4 then at index 4
         * Node(hashval,key,val,next_node_addr) is stored as part of linked list
         * if hash got cal same then index also same then linked list node made & then key is checked by equals method
         * if more collisions occur for one index then in java 8 after the threshold it start creating binary tree instead of linked list
         */
    }
}
