package top150.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/?envType=study-plan-v2&envId=top-interview-150
public class RandomizedSet {

    HashSet<Integer>  set1 ;
    HashSet<Integer>  set2 ;
    Random random ;

    public RandomizedSet() {

        set1 = new HashSet<>();
        set2 = new HashSet<>();

        random = new Random();


    }

    public boolean insert(int val) {

        if(set2.contains(val)){
            return false ;
        }

        return set1.add(val);

    }

    public boolean remove(int val) {

        if(set1.contains(val)){
            return set1.remove(val);
        }

        return set2.remove(val);

    }

    public int getRandom() {

        if(set1.isEmpty()){
            set1 = set2 ;
            set2 = new HashSet<>();
        }

        int value = 0;
        Iterator<Integer> itr = set1.iterator();
        value = itr.next();

        if(random.nextInt(2) > 0 ){
            set1.remove(value);
            set2.add(value);

        }

        return value ;
    }
}
