package top150.array;


import java.util.stream.IntStream;

// https://leetcode.com/problems/candy/?envType=study-plan-v2&envId=top-interview-150
public class Candy {

    public int candy(int[] ratings) {

        int[] candies = null;
        candies =  twoArries(ratings);
        return IntStream.of(candies).sum();
        //return solution3(ratings);
      }



      public int[] twoArries(int[] ratings){

        int[]   left2right = new int[ratings.length];
        int[]   right2left = new int[ratings.length];

        int[]   candies = new int[ratings.length];

        for(int index = 0 ; index < ratings.length ; index++){
            left2right[index] = 1;
            right2left[index] = 1;
        }

        for(int index = 1 ; index < ratings.length ; index++){
            if(ratings[index] > ratings[index-1]){
                left2right[index] = left2right[index-1]+1;
            }
        }

        for(int index = ratings.length -2 ; index >= 0 ; index --){
            if(ratings[index] > ratings[index+1]){
                right2left[index] = right2left[index+1]+1;
            }
        }

        for(int index = 0 ; index < ratings.length ; index++){

            int value =left2right[index] > right2left[index] ? left2right[index] : right2left[index];
            candies[index] =value ;
        }

        return candies;
      }

    public int solution3(int[] ratings){
        int total = 0;

        int min = Integer.MAX_VALUE ;
        int minIndex = 0 ;

        for(int index = 0 ; index < ratings.length ; index++){
            if(ratings[index] < min){
                min = ratings[index];
                minIndex = index ;
            }
        }
        int[] allocations = new int[ratings.length];

        allocations[minIndex] = 1;

        for(int index = minIndex-1 ; index >= 0 ; index--){
            if(ratings[index] > ratings[index+1]){
                allocations[index] = allocations[index+1]+1;
            }else if(ratings[index] < ratings[index+1]){
                allocations[index] = 1;
                if(allocations[index+1] == 1){
                    int k = index ;
                    while(k <= minIndex-1 && ratings[k] <= ratings[k+1] ){
                        allocations[k+1]++;
                        k++;
                    }
                }
            }else{
                allocations[index] = 1;
            }

        }

        for(int index = minIndex+1 ; index < ratings.length ; index++){
            if(ratings[index] > ratings[index-1]){
                allocations[index] = allocations[index-1]+1;
            }else if(ratings[index] < ratings[index-1]){
                allocations[index] = 1;
                if(allocations[index-1] == 1){
                    int k = index;
                    while(k >= minIndex+1 && ratings[k] <= ratings[k-1] ){
                        allocations[k-1]++;
                        k--;
                    }
                }
            }
            else{
                allocations[index] = 1;
            }
        }

        total = IntStream.of(allocations).sum();

        return total ;

    }
    public int  brutalForce(int[] ratings){

        return 0 ;

    }

    public static void main(String args[]){

          Candy candy = new Candy();

          int[] ratings = new int[] { 1 , 0 , 2};
         // ratings = new int[] { 1 , 2 , 2};
          ratings= new int[] { 1 , 3 , 2 , 2, 1};
          System.out.println(candy.candy(ratings));
      }
}
