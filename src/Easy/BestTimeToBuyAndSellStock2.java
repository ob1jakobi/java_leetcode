import java.util.Arrays;

/**
 * You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock
 * on the <code>i<sup>th</sup></code> day.<br>
 * On each day, you may decide to buy/or sell stock. You can only hold <strong>at most one</strong> share of the
 * stock at any time. Howerver, you can buy it then immediately sell it on the <strong>same day</strong>.<br>
 * Find and return the <em><strong>maximum</strong> profit you can achieve</em>.
 *
 */
public class BestTimeToBuyAndSellStock2 {

    /**
     * Two-pointer aproach, where:
     * <ul>
     *    <li>`l`: the pointer for the current purchase price of the stock.</li>
     *    <li>`r`: the pointer for the cuurent iterated price of the stock.</li>
     * </ul>
     * The invariant is that we only update the <code>l</code> pointer under two circumstances:
     * <ol type="a">
     *    <li>The current iterated price pointed to by `r` is lower than the current buy price pointed to by `l`;
     *        this indicates that we should buy stock at the price `r` points to, since the stock price is lower
     *        than what we currently are holding at. We do not update `totalProfit`, since we are not selling stock.</li>
     *    <li>The current iterated price pointed to by `r` is higher than the current buy price pointed to by `l`;
     *        this indicates that we should sell our stock because we stand to make a profit (buy low, sell high).
     *        Because we're selling our stock, we update `totalProfit` and set `l` to point to the same index as `r`.</li>
     * </ol>
     * If the price at `l` is the same as the price at `r`, we do not update anything and simply increment `r` to point
     * to the next day. We don't need to sell nor buy on a day when the prices are the same.
     */
    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
	int l = 0;            // Buy stock pointer
	int r = 1;            // Iterator pointer
	while (r < prices.length) {  // Falls out of scope for singleton prices array
	    int buyPrice = prices[l];
	    int currPrice = prices[r];
	    int profit = currPrice - buyPrice;
	    if (profit > 0) {
		// Sell our stock because we've made money
		totalProfit += profit;
		l = r;                 // Update buy stock pointer to current stock price
	    } else if (profit < 0) {
		// Stock price is low -> buy
		l = r;                 // Update buy stock pointer to current stock price
	    }
	    r++;
	}
	return totalProfit;
    }


    public static void main(String[] args) {
	int[] prices1 = {7,1,5,3,6,4};
	int[] prices2 = {1,2,3,4,5};
	int[] prices3 = {7,6,4,3,1};
	int[][] allPrices = {prices1, prices2, prices3};

	int[] results = {7, 4, 0};

	for (int i = 0; i < 3; i++) {
	    int[] prices = allPrices[i];
	    int result = results[i];
	    boolean isCorrect = maxProfit(prices) == result;
	    String display;
	    if (isCorrect) {
		display = String.format("prices:\t\t%s\nresult:\t\t%d\n\n",
					Arrays.toString(prices),
					maxProfit(prices));
	    } else {
		display = String.format("prices:\t\t%s\nresult:\t\t%d\ncorrect:\t%d\n\n",
					Arrays.toString(prices),
					maxProfit(prices),
					result);
	    }
	    System.out.println(display);
	}
    }
}
