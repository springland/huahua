package gucheng.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchBasic {


    public static void main(String args[])
    {

        int nums[] = new int [] { 1  , 3 , 5,6 ,7 , 9 , 10 , 13};

        int targetIndex = search(nums , 5);


        assertEquals(targetIndex , 2);
        targetIndex = search(nums , 7);
        assertEquals(targetIndex , 4);

        targetIndex = search(nums , 4) ;
        assertEquals(targetIndex ,-2 );
        targetIndex = search(nums , 8) ;
        assertEquals(targetIndex ,-5 );
        targetIndex = search(nums , 0) ;
        assertEquals(targetIndex ,0 );

        targetIndex = search(nums , 14) ;
        assertEquals(targetIndex ,-8 );



        nums = new int[] { 1 , 2 , 2, 2 , 3 ,3 ,3 ,3 ,3 , 6 , 9 , 12};
        targetIndex = searchFirstOccurance(nums , 1);
        assertEquals(targetIndex , 0);
        targetIndex = searchFirstOccurance(nums , 2);
        assertEquals(targetIndex , 1);

        targetIndex = searchFirstOccurance(nums , 3);
        assertEquals(targetIndex , 4);

        targetIndex = searchFirstOccurance(nums , 0);
        assertEquals(targetIndex , -1);

        targetIndex = searchFirstOccurance(nums , 8);
        assertEquals(targetIndex , -1);

        targetIndex = searchFirstOccurance(nums , 13);
        assertEquals(targetIndex , -1);


        targetIndex = searchLastOccurance(nums, 1);
        assertEquals(targetIndex , 0);
        targetIndex = searchLastOccurance(nums , 2);
        assertEquals(targetIndex , 3);
        targetIndex = searchLastOccurance(nums , 3);
        assertEquals(targetIndex , 8);

        targetIndex = searchLastOccurance(nums , 6);
        assertEquals(targetIndex , 9);

        targetIndex = searchLastOccurance(nums , 0);
        assertEquals(targetIndex , -1);

        targetIndex = searchLastOccurance(nums , 13);
        assertEquals(targetIndex , -1);

        nums = new int[] { 2 , 6 , 8 , 9  , 12};

        targetIndex = searchClosest(nums , 0);
        assertEquals(targetIndex , 0);
        targetIndex = searchClosest(nums , 2);
        assertEquals(targetIndex , 0);
        targetIndex = searchClosest(nums , 3);
        assertEquals(targetIndex , 0);
        targetIndex = searchClosest(nums , 4);
        assertEquals(targetIndex , 0);
        targetIndex = searchClosest(nums , 5);
        assertEquals(targetIndex , 1);
        targetIndex = searchClosest(nums , 7);
        assertEquals(targetIndex , 1);
        targetIndex = searchClosest(nums , 8);
        assertEquals(targetIndex , 2);
        targetIndex = searchClosest(nums , 11);
        assertEquals(targetIndex , 4);
        targetIndex = searchClosest(nums , 15);
        assertEquals(targetIndex , 4);


    }

    public static int search(int nums[]  , int target)
    {
        int low = 0 ;
        int high = nums.length-1;

        while(low <= high)
        {
            int middle = low + (high - low)/2;
            if(nums[middle] == target){
                return middle ;
            }

            if(nums[middle] < target){
                low = middle+1;
            }
            else{
                high = middle -1 ;
            }
        }

        return -low ;
    }

    public static int searchFirstOccurance(int nums[] , int target)
    {
        int low = 0 ;
        int high = nums.length-1 ;
        while(low < high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                high = mid ;
            }
            else if(nums[mid] < target)
            {
                low = mid +1 ;
            }
            else{
                high = mid -1 ;
            }

        }

        return nums[low] == target ? low : -1 ;

    }

    public static int searchLastOccurance(int nums[] , int target){
        int low = 0 ;
        int high = nums.length-1 ;
        while(low < high)
        {
            int mid = low + (high - low+1)/2;
            if(nums[mid] == target){
                low = mid ;
            }
            else if(nums[mid] < target)
            {
                low = mid +1 ;
            }
            else{
                high = mid -1 ;
            }

        }

        return nums[high] == target ? high : -1 ;

    }

    public static int searchClosest(int nums[] , int target){

        int l = 0 ;
        int r = nums.length-1 ;

        while(l < r-1)
        {
            int mid = l + (r -l)/2;
            if(nums[mid] == target){
                return mid ;
            }else if ( nums[mid] < target){
                l = mid ;
            }
            else{
                r = mid ;
            }
        }

        return Math.abs(nums[r] - target) < Math.abs(nums[l] - target) ? r : l ;
    }
}
