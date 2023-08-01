package top150.hashmap;

import java.util.HashSet;

// https://leetcode.com/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150
public class HappyNumber {

    public boolean isHappy(int n) {

        HashSet<Integer> visited = new HashSet<>();


        while(n != 1 && !visited.contains(n)){

            visited.add(n);

            int sum = 0 ;
            while(n > 9){
                int value = n %10;
                sum += value * value ;
                n /= 10 ;
            }
            sum += n*n ;
            n = sum ;
        }

        return n == 1;

    }
}

/*
2
4
16   1 + 36
37   9  + 49
58   25 + 64
89   64  81
145  1  16  25
42    16  4
20     4



 */