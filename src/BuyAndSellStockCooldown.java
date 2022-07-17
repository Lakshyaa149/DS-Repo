class Solution {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1)
            return 0;
        int n = prices.length;

        int buy[] = new int[n];
        int sell[] = new int[n];
        buy[0]=-prices[0];
        sell[0]=0;

        for (int i = 1; i < n; i++) {
            int s2 = 0;
            if (i - 2 < 0)
                s2 = 0;
            else
                s2 = sell[i - 2];
            buy[i] = Math.max(buy[i - 1], s2 - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);

        }

        return sell[n - 1];
    }
}