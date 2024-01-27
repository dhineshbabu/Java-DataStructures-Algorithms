package gfgalgo.module04arrays;

public class Prob_08BuySellStockMaxProfit {
    /*
    if the prices of current element is higher than price of previous then add it to the profit

     */

    public static void main(String[] args) {
        int[] stockPrice = {7, 1, 5, 3, 6, 4};

        // set profit initial price
        int profit = 0;
        for (int i = 1; i < stockPrice.length; i++) {
            // add it to the profit only if it is greater than current profit
            if (stockPrice[i] > stockPrice[i - 1]) {
                // add it to the current profit
                profit += (stockPrice[i] - stockPrice[i - 1]);
                System.out.println(profit);
            }
        }
        System.out.println(profit);
    }
}
