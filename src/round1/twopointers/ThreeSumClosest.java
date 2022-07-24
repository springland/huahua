package round1.twopointers;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = 0;
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0  ; i < nums.length-2 ; i++){
            int j = i+1 ;
            int k = nums.length-1 ;
            while(j < k){
                int diff = target - nums[i] - nums[j] - nums[k];

                if(Math.abs(diff) < minDiff){
                    minDiff = Math.abs(diff) ;
                    ans = nums[i] + nums[j] + nums[k];
                }
                if(diff == 0){
                    return target ;
                }
                else if(diff < 0)
                {
                    k--;
                }
                else{

                    j++;
                }
            }

        }
        return ans ;
    }

    public static void main(String[] args)
    {
        int nums[] ;
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();

        nums = new int[] {-1,2,1,-4};
        //System.out.println(threeSumClosest.threeSumClosest(nums , 1));

        nums = new int[] {-461,80,-437,-405,393,-653,-436,-493,-972,28,483,360,-810,857,508,-86,105,-930,-580,592,342,-476,373,-225,-171,-414,-247,-694,-674,161,624,-931,318,-107,-693,-221,685,-28,-853,872,-211,-608,284,-722,669,629,-246,848,-911,-8,-442};
        System.out.println(threeSumClosest.threeSumClosest(nums , -9708));

    }
}
