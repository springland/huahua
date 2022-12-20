package gucheng.algorithms.divideandconquer;

// https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/
public class InversionCount {


    public int countInversion(int nums[]){


        return countInversion(nums , 0 , nums.length-1) ;
    }

    public int countInversion(int nums[] , int beginIndex , int endIndex){

        // use a merge sort  from big to small , then only need to find the first number less than
        // the value.
        if(beginIndex >= endIndex){
            return 0 ;
        }

        int middle = beginIndex + (endIndex - beginIndex)/2 ;

        int left = countInversion(nums , beginIndex , middle) ;
        int right = countInversion(nums , middle+1 , endIndex);

        int count = 0 ;

        // left and right are all sorted

        for(int leftIndex = beginIndex ; leftIndex <= middle ; leftIndex++){

            int rightIndex = middle+1;
            while(rightIndex <= endIndex && nums[rightIndex] >= nums[leftIndex]){
                rightIndex ++;
            }
            count +=  endIndex+1 - rightIndex ;
        }



        int leftIndex = beginIndex ;
        int rightIndex = middle+1;


        int[] temp = new int[endIndex - beginIndex+1];
        int index = 0;
        while(leftIndex <= middle && rightIndex <= endIndex){
            if(nums[leftIndex] > nums[rightIndex]){
                temp[index++] = nums[leftIndex ++];
            }
            else{
                temp[index++] = nums[rightIndex++];
            }
        }
        while(leftIndex <= middle){
            temp[index++] = nums[leftIndex ++];
        }
        while(rightIndex <= endIndex){
            temp[index++] = nums[rightIndex++];
        }
        System.arraycopy(temp , 0 , nums , beginIndex , temp.length);


        return left + right + count ;

    }

    public static void main(String args[]){
        int[] nums ;
        InversionCount  inversionCount = new InversionCount();

        nums = new int[] {8 , 4 , 2 , 1};

        System.out.println(inversionCount.countInversion(nums));

        // Output: 6
        // Explanation: Given array has six inversions: (8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).
        nums = new int[] {1, 20, 6, 4, 5} ;

        System.out.println(inversionCount.countInversion(nums));

        //Output: 5
        //Explanation: Given array has five inversions: (20, 6), (20, 4), (20, 5), (6, 4), (6, 5).
    }
}
