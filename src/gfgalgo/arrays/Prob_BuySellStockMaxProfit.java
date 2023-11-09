package gfgalgo.arrays;

public class Prob_BuySellStockMaxProfit {
    /*
    if the prices of current element is higher than price of previous then add it to the profit

     */

    public static void main(String[] args) {
        int[] stockPrice = {7,1,5,3,6,4};

        // set profit initial price
        int profit = 0;
        for(int i=1; i<stockPrice.length; i++) {
            if(stockPrice[i] > stockPrice[i-1]) {
                // add it to the current profit
                profit += (stockPrice[i] - stockPrice[i-1]);
            }
        }
        System.out.println(profit);
    }
}
