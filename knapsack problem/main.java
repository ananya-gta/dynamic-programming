public class Main {

    public static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        // DP table fill
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            val[i - 1] + dp[i - 1][j - wt[i - 1]],
                            dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;

        int maxProfit = knapsack(W, val, wt);

        System.out.println("Maximum profit = " + maxProfit);
    }
}
