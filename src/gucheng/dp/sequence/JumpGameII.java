package gucheng.dp.sequence;

// https://leetcode.com/problems/jump-game-ii/description/
public class JumpGameII {

    public int jump(int[] nums) {

        //return recursive(nums);
        return iterative(nums);
    }

    public int recursive(int[] nums){

        Integer[] memo = new Integer[nums.length];


        return recursive(nums , 0 , memo);
    }

    public int recursive(int[] nums , int index , Integer memo[]){
        if(index >= nums.length-1){
            return 0 ;
        }
        if(memo[index] != null) return memo[index];


        int ans = Integer.MAX_VALUE  ;
        for(int step = 1 ; step <= nums[index]  && step + index < nums.length ; step ++){

            int next = recursive(nums , index+step , memo);
            if(next >= 0) ans = Math.min(ans, 1 + next);
        }

        if(ans == Integer.MAX_VALUE) ans = -1 ;
        memo[index] = ans ;

        return memo[index] ;
    }

    public int iterative(int nums[]){

        int[] ans = new int[nums.length];

        ans[0] = 0;

        for(int index = 1 ; index < nums.length ; index++){

            int step = Integer.MAX_VALUE ;

            for(int j = index -1 ; j >= 0 ; j--){
                if(nums[j] + j >= index && ans[j] >= 0)  step = Math.min(step , ans[j] +1);
            }

            ans[index] = step == Integer.MAX_VALUE ? -1 : step ;
        }

        return ans[nums.length-1];
    }
    public static void main(String args[]){

        JumpGameII jumpGameII = new JumpGameII();

        System.out.println(jumpGameII.jump(new int[] {5,9,3,2,1,0,2,3,3,1,0,0}));

        System.out.println(jumpGameII.jump(new int[] {0 , 0 , 0}));
    }
}
