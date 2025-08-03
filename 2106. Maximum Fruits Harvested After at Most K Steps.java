class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int left = 0, total = 0, maxFruits = 0;

        for (int right = 0; right < n; right++) {
            total += fruits[right][1];

            // Shrink window from the left while it's invalid
            while (left <= right && !canReach(fruits[left][0], fruits[right][0], startPos, k)) {
                total -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits;
    }

    private boolean canReach(int l, int r, int start, int k) {
        // Minimum steps to go from start to l and r
        return Math.min(Math.abs(start - l), Math.abs(start - r)) + (r - l) <= k;
    }
}
