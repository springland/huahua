package gucheng.algorithms.binarysearch;

// https://leetcode.com/problems/find-peak-element/description/

import static org.junit.jupiter.api.Assertions.assertEquals;

// You must write an algorithm that runs in O(log n) time.
public class FindPeakElement {

    public static void main(String args[])
    {

        FindPeakElement  findPeakElement = new FindPeakElement();

        int[] nums = new int[] {1,2,3,1};
        assertEquals(findPeakElement.findPeakElement(nums) , 2);

        nums = new int[] {1,2,1,3,5,6,4};
        assertEquals(findPeakElement.findPeakElement(nums) , 5);

        nums = new int [] {6,5,4,3,2,3,2};
        assertEquals(findPeakElement.findPeakElement(nums) , 0);

        nums = new int[] {3 ,4 ,3 ,2 ,1};
        System.out.println(findPeakElement.findPeakElement(nums));

        nums = new int[] { 3 , 1 , 2};
        System.out.println(findPeakElement.findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {

        int beginIndex = 0 ;
        int endIndex = nums.length-1 ;

        if(nums.length == 1)
        {
            return 0 ;
        }

        if(nums.length == 2)
        {
            if(nums[0] > nums[1]){
                return 0 ;
            }
            else{
                return 1 ;
            }
        }

        while(beginIndex <= endIndex){
            int middleIndex = beginIndex + (endIndex-beginIndex)/2;
            if(middleIndex == 0)
            {
                if(nums[middleIndex] > nums[middleIndex+1])
                {
                    return middleIndex ;
                }
                else{
                    beginIndex = middleIndex+1;
                }
            }else  if(middleIndex == nums.length-1){
                if(nums[middleIndex] > nums[middleIndex-1])
                {
                    return middleIndex ;
                }
                else{
                    endIndex = middleIndex-1;
                }
            }else {

                if (nums[middleIndex] <= nums[middleIndex + 1]) {
                    beginIndex = middleIndex + 1;
                } else if (nums[middleIndex] <= nums[middleIndex - 1]) {
                    endIndex = middleIndex - 1;
                } else {
                    return middleIndex;
                }
            }
        }

        return -1 ;
    }



}
