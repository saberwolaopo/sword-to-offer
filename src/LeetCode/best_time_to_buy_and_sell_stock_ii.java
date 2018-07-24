package LeetCode;
/*
题目描述

Say you have an array for which the i th element is the price of a given stock on day i.
Design an algorithm to find the maximum profit.
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(prices == null || length<1){
            return 0;
        }
        int diff = 0;
        int currentdiff = 0;
        for(int i = 0 ;i<length-1;i++){
            if(prices[i]<prices[i+1]){
                currentdiff = prices[i+1]-prices[i];
                diff+=currentdiff;
            }
        }
        return diff;
    }
}
