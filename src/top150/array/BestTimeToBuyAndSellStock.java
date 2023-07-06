package top150.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {


        return iterative(prices);

    }

    public int iterative(int[] prices){
        int maxProfit = 0 ;

        int  minPrice = prices[0];

        for(int index = 1 ; index < prices.length ; index++){
            if(prices[index] < minPrice){
                minPrice = prices[index];
            }else{
                maxProfit = maxProfit > prices[index] - minPrice ? maxProfit :prices[index] - minPrice;
            }
        }

        return maxProfit;

    }

}
