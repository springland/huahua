package gucheng.algorithms.prefixsum;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        int[] suffixProducts = new int[nums.length];
        int[] products = new int[nums.length];

        int product = 1;
        for(int index = 0 ; index < nums.length ; index++){
            product = product * nums[index];
            prefixProducts[index] = product ;
        }

        product = 1 ;
        for(int index = nums.length-1 ; index >= 0 ; index --){
            product = product * nums[index];
            suffixProducts[index] = product ;
        }


        for(int index = 0 ; index < nums.length ; index ++){
            product = 1 ;
            if(index > 0){
                product = product * prefixProducts[index-1];
            }
            if(index <nums.length-1){
                product = product * suffixProducts[index+1];
            }
            products[index] = product ;
        }
        return products ;
    }
}
