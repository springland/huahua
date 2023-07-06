package top150.array;
//https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];

        int zeroCount = 0 ;
        int total = 1;

        for(int index = 0 ; index < nums.length ; index++){

            if(nums[index] == 0){
                zeroCount++;
            }
            else{
                total *= nums[index];
            }
        }

        if(zeroCount < 2){
            for(int index = 0 ; index < nums.length ; index++){
                if(zeroCount == 0){
                    ans[index] = total/nums[index];
                }
                else{
                    if(nums[index] == 0){
                        ans[index] = total ;
                    }
                }
            }
        }
        return ans ;
    }
}
