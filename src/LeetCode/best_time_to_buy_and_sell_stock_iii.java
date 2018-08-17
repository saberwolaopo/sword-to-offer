package LeetCode;
/*
题目描述

Say you have an array for which the i th element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 */
public class best_time_to_buy_and_sell_stock_iii {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length<=1){
            return 0;
        }
        int firstbuy = Integer.MIN_VALUE;//第一次买的收益
        int firstsell = 0;//第一次卖的收益
        int secondbuy = Integer.MIN_VALUE;//第二次买的收益
        int secondsell = 0;//第二次卖的收益
        for(int curPrice : prices){
            firstbuy = Math.max(firstbuy,-curPrice);
            firstsell = Math.max(firstsell,curPrice+firstbuy);
            secondbuy = Math.max(secondbuy,firstsell-curPrice);
            secondsell = Math.max(secondsell,curPrice+secondbuy);
        }
        return secondsell;
    }
}
