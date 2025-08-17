// class Solution {
//     public double new21Game(int n, int k, int maxPts) {
//         if (k == 0) return 1.0;    
//         Double[] memo = new Double[k + maxPts + 1]; // enough to cover reachable sums
//     // Alice never draws: sum = 0 ≤ n
//         return dfs(0, n, k, maxPts,memo);
//     }

//     private double dfs(int sum, int n, int k, int maxPts,Double[] memo) {
//         if (sum >= k) {                // stop condition
//             return sum <= n ? 1.0 : 0.0;
//         }
//         if (memo[sum] != null) return memo[sum];

//         double p = 0.0;
//         for (int x = 1; x <= maxPts; x++) {
//             p += dfs(sum + x, n, k, maxPts,memo);
//         }
//         return memo[sum] = p / maxPts;
//     }
// }

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) {
            return 1;
        }
        double[] dp = new double[n + 1]; // prob of getting point i
        dp[0] = 1;
        double sum = 0;  // sum(dp[i - 1], dp[i - 2], ..., dp[i - maxPts])
        for(int i = 1; i <= n; i++) {
            if (i - 1 < k) { // cannot use state of i >= k cuz no more drawing after k.
                sum += dp[i - 1];
            }
            if (i - maxPts > 0) { // only keep states of drawing last round in window.
                sum -= dp[i - maxPts - 1];
            }
            dp[i] = sum / maxPts;  // calculate prob of point i based on all states in last round.
        }

        double ret = 0;
        for(int i = k; i <= n; i++) {
            ret += dp[i];
        }
        return ret;
    }
}