package top150.array;

import java.util.TreeMap;
// https://leetcode.com/problems/integer-to-roman/?envType=study-plan-v2&envId=top-interview-150
public class IntegerToRoman {
    public String intToRoman(int num) {

        //return treeMap(num);
        return simple(num);
    }

    public String simple(int num){
        int[]  divisors = new int[]{1000 , 100 , 10 , 1};
        char[][] romanChars = new char[][] {
                { 'M' , ' ' },
                {'C' , 'D'},
                {'X' , 'L'},
                {'I' , 'V'}
        };

        StringBuilder sb = new StringBuilder();

        int divisorIndex = 0;
        while(num > 0){
            while(divisors[divisorIndex] > num){
                divisorIndex++;
            }

            int count = num / divisors[divisorIndex];
            if(divisorIndex == 0){
                for(int index = 0 ; index < count; index++){
                    sb.append(romanChars[divisorIndex][0]);
                }
            }
            else{

                switch(count){
                    case 1:
                    case 2:
                    case 3:
                        for(int index = 0 ; index < count ; index++){
                            sb.append(romanChars[divisorIndex][0]);
                        }
                        break;
                    case 4:
                        sb.append(romanChars[divisorIndex][0]);
                        sb.append(romanChars[divisorIndex][1]);

                        break;
                    case 5:
                        sb.append(romanChars[divisorIndex][1]);
                        break;
                    case 6:
                    case 7:
                    case 8:
                        sb.append(romanChars[divisorIndex][1]);
                        for(int index = 0 ; index < count-5 ; index++){
                            sb.append(romanChars[divisorIndex][0]);
                        }
                        break;
                    case 9:
                        sb.append(romanChars[divisorIndex][0]);
                        sb.append(romanChars[divisorIndex-1][0]);
                        break;
                }

            }
            num -= divisors[divisorIndex]*count ;
        }

        return sb.toString();

    }
    public String treeMap(int num){
        StringBuilder builder = new StringBuilder();

        TreeMap<Integer , String> romanValueMap = new TreeMap<>();
        romanValueMap.put(1 , "I");
        romanValueMap.put(4 , "IV");
        romanValueMap.put(5 , "V");
        romanValueMap.put(9 , "IX");
        romanValueMap.put(10 , "X");
        romanValueMap.put(40 , "XL");
        romanValueMap.put(50 , "L");
        romanValueMap.put(90 , "XC");
        romanValueMap.put(100 , "C");
        romanValueMap.put(400 , "CD");
        romanValueMap.put(500 , "D");
        romanValueMap.put(900 , "CM");
        romanValueMap.put(1000 , "M");
        while(num > 0){
            int key = romanValueMap.floorKey(num);
            builder.append(romanValueMap.get(key));
            num -= key;
        }

        return builder.toString();

    }
}
