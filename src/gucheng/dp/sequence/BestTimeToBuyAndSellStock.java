package gucheng.dp.sequence;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        //return recursive(prices);
        return iterative(prices);

    }

    public int recursive(int[] prices){

        Integer[][] memo = new Integer[prices.length][2];
        return recursive(prices , 0 , false , 0 ,  memo);
    }

    public int recursive(int[] prices , int index , boolean hasStock , int boughtPrice ,  Integer[][] memo){

        if(index == prices.length){
            return 0 ;
        }

        int ans = 0;

        if(hasStock){

            if(prices[index] <= boughtPrice) return 0 ;
            if(memo[index][1] != null){
                return memo[index][1];
            }

            ans = Math.max(prices[index] - boughtPrice   , recursive(prices , index+1 , true , boughtPrice , memo));
            ans = Math.max(ans , 0);

            memo[index][1] = ans ;

        }else{
            if(memo[index][0] != null){
                return memo[index][0];
            }
            ans = Math.max(
                    recursive(prices , index+1 , true , prices[index] , memo),
                    recursive(prices , index+1 , false , 0 , memo)
            );
            ans = Math.max(ans , 0);
            memo[index][0] = ans ;

        }

        return ans ;

    }
    public int iterative(int[] prices){
        int[][] dp = new int[prices.length][2];

        // 0 is does not have  stock
        // 1 is has stock

        dp[0][0] = 0 ;
        dp[0][1] = -prices[0];

        for(int index = 1 ; index < prices.length ; index++){
            // today does not have stock = yesterday does not have stoack or yesterday has stock and sell it today
            dp[index][0] =  Math.max(dp[index-1][0] , dp[index-1][1] + prices[index]);
            // today has stock = yesterday has stock  or just bought stock today
            dp[index][1] = Math.max(dp[index-1][1] , -prices[index]);
        }
        return dp[prices.length-1][0] ;
    }

    public static void main(String args[]){

        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(bestTimeToBuyAndSellStock.iterative(prices));
    }
}
