package gucheng.algorithms.recurison;

// https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public int search(int[] nums, int target) {

        int left = 0 ;
        int right = nums.length-1;
        while(left <= right){
            int middle = left + (right-left)/2;
            if(nums[middle] == target){
                return middle ;
            }
            if(nums[middle] < target){
                left = middle+1;
            }
            else{
                right = middle-1 ;
            }
        }
        return -1 ;
    }

    public int searchFirst(int nums[] , int target){
        int left = 0 ;
        int right = nums.length-1;
        while(left < right){
            int middle =  left + ( right -left)/2 ;
            if(nums[middle] == target){
                right = middle ;
            }else if (nums[middle] < target){
                left = middle+1;
            }
            else{
                right = middle -1 ;
            }
        }

        return nums[right] == target? right : -1 ;
    }

    public int searchLast(int[] nums , int target){
        int left = 0 ;
        int right = nums.length-1;
        while(left < right){
            int middle = left + ( right -left +1)/2 ;
            if(nums[middle] == target){
                left = middle ;
            }else if ( nums[middle] < target){
                left = middle+1;
            }else{
                right = middle -1 ;
            }

        }

        return nums[right] == target ? right : -1 ;
    }

    public int searchClosest(int nums[] , int target){
        int left = 0 ;
        int right = nums.length-1 ;
        while(left < right -1){

            int middle = left + ( right - left)/2;
            if(nums[middle] == target){
                return middle ;
            }else if(nums[middle] < target){
                left = middle ;
            }else{
                right = middle ;
            }
        }

        if (Math.abs(nums[left] - target) < Math.abs(nums[right] - target)) {

            return left ;
        }else{
            return right ;
        }
    }

    public static void main(String args[]){
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.searchFirst(new int[] { 2 , 3 , 4 , 4, 4 , 4 , 5} , 4));
        System.out.println(binarySearch.searchFirst(new int[] { 2 , 3 , 4 , 4, 4 , 4 , 5} , 8));
        System.out.println(binarySearch.searchLast(new int[] { 2 , 3 , 4 , 4, 4 , 4 , 5} , 4));
        System.out.println(binarySearch.searchLast(new int[] { 2 , 3 , 4 , 4, 4 , 4 , 5} , 8));

        System.out.println(binarySearch.searchClosest(new int[] { 2 , 3 , 8} , 4));
        System.out.println(binarySearch.searchClosest(new int[] { 2 , 3 , 8} , 6));
    }
}
