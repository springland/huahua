package misc;

public class BinarySearch {

    public int basicBinarySearch(int nums[] , int value)
    {

        return basicBinarySearch(nums , 0 , nums.length-1 , value);
    }

    public int basicBinarySearch(int nums[] , int beginIndex ,int endIndex , int value)
    {
        if(beginIndex > endIndex){
            return -1 ;
        }

        int middleIndex = beginIndex + (endIndex - beginIndex)/2 ;
        if(nums[middleIndex] == value){
            return middleIndex ;
        }else if ( nums[middleIndex] > value){
            endIndex = middleIndex-1;
        }
        else{
            beginIndex = middleIndex+1;
        }

        return basicBinarySearch(nums , beginIndex , endIndex , value);
    }


    public int searchFirstOccurance(int nums[] , int value){

        return searchFirstOccurance(nums , 0 , nums.length-1 , value);
    }

    public int searchFirstOccurance(int nums[] , int beginIndex , int endIndex , int value){

        while(beginIndex < endIndex)
        {
            int middleIndex =  beginIndex + ( endIndex - beginIndex)/2;

            if(nums[middleIndex] == value){
                endIndex = middleIndex ;
            }else if ( nums[middleIndex] < value){
                beginIndex = middleIndex +1 ;
            }else {
                endIndex = middleIndex -1 ;
            }
        }

        return nums[beginIndex] == value ? beginIndex: -1;

    }


    public static void main(String args[]){
        int[] nums ;

        BinarySearch  search = new BinarySearch();
/*
        nums = new int[] { 1 , 3 , 5 , 7 };
        System.out.println( search.basicBinarySearch(nums , 3) );
        System.out.println( search.basicBinarySearch(nums , 4) );

        nums = new int[] { 1 , 3 , 5 , 9};
        System.out.println(search.basicBinarySearch(nums , 5));
        System.out.println( search.basicBinarySearch(nums , 6) );
*/
        nums = new int[] {1 , 1 , 1 };
      //  System.out.println( search.searchFirstOccurance(nums , 1) );

        nums = new int[] {1 , 2 , 2 ,2 ,2 , 3 , 3, 3, 3,3,4 };
        System.out.println( search.searchFirstOccurance(nums , 1) );
        System.out.println( search.searchFirstOccurance(nums , 2) );
        System.out.println( search.searchFirstOccurance(nums , 3) );
        System.out.println( search.searchFirstOccurance(nums , 4) );
    }
}
