package gucheng.algorithms.slidingwindow;

// https://leetcode.com/problems/count-number-of-nice-subarrays/
public class CountNumberofNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {


        return atMost(nums , k) - atMost(nums , k-1);

    }

    public int atMost(int[] nums , int k){
        int leftIndex = 0 ;
        int ans = 0 ;
        for(int rightIndex = 0 ; rightIndex < nums.length ; rightIndex++){
            k -= nums[rightIndex]%2 ;
            while( k < 0){
                k += nums[leftIndex]%2 ;
                leftIndex ++ ;
            }

            // still do not understand why this atMost K works
            /*
            还是不明白atMostK 中的res += i - left +1的逻辑 ,   用1248题举个例子
            atMostK([1 , 2 , 3] , 2) 应该返回5 , [1] , [3] , [1, 2] , [2,3] , [1 , 2, 3] 是解 ， [1 , 3]不是因为中间跳了2
            但 video中atMostK会返回6
            不知是不是我理解得不对？
             */
            ans += rightIndex - leftIndex +1;

            System.out.println(String.format("(%d , %d , k=%d) " , leftIndex , rightIndex , k));
        }


        // [1  , 2 , 3] k =2  , odd number <= k
        // [1] , [3] , [1, 2] , [2 , 3] , [1 , 2 , 3]
        return ans ;
    }

    public static void main(String[] args){

        int[] nums ;
        CountNumberofNiceSubarrays countNumberofNiceSubarrays = new CountNumberofNiceSubarrays();
        nums = new int[] {1,1,2,1,1};
     //   System.out.println(countNumberofNiceSubarrays.numberOfSubarrays(nums , 3));

        nums = new int[] {2 ,4 , 6};
     //   System.out.println(countNumberofNiceSubarrays.numberOfSubarrays(nums , 1));

        nums = new int[] {2,2,2,1,2,2,1,2,2,2};
      //  System.out.println(countNumberofNiceSubarrays.numberOfSubarrays(nums , 2));

        System.out.println(countNumberofNiceSubarrays.atMost(new int[]{ 1 , 2 , 3} , 2));

    }
}
