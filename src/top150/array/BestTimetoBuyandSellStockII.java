package top150.array;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
public class BestTimetoBuyandSellStockII {

    // no dp needed
    public int maxProfit(int[] prices) {
        // take any profit

        int minPrice = prices[0];
        int total = 0 ;
        boolean downTrend = true ;
        for(int index = 1 ; index < prices.length ; index++){
            // find where price changes from dropping to increase

            if(prices[index] > prices[index-1] ){
                if(downTrend){
                    minPrice = prices[index-1];
                }
                downTrend = false ;
            }
            else{
                if(!downTrend){
                    total += prices[index-1] - minPrice ;
                }
                downTrend = true ;

            }
        }

        if(!downTrend){
            total += prices[prices.length-1] - minPrice ;
        }
        return total ;

    }


    public static void main(String args[]){

        int prices[] = new int[] { 7 , 6 , 4 , 3 , 1};
        BestTimetoBuyandSellStockII bestTimetoBuyandSellStockII = new BestTimetoBuyandSellStockII();
        System.out.println(bestTimetoBuyandSellStockII.maxProfit(prices));
    }
}
