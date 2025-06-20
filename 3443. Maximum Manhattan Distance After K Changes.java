class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0;
        // Check all 4 direction combinations (quadrants)
        String[] dirs = {"NE", "NW", "SE", "SW"};
        for (String dir : dirs) {
            ans = Math.max(ans, solveQuadrant(s, k, dir));
        }
        return ans;
    }

  
    private int solveQuadrant(String s, int k, String fav) {
        int curr = 0, opp = 0, best = 0;
        for (char ch : s.toCharArray()) {
            if (fav.indexOf(ch) != -1) {
                curr++;
            } else {
                curr--;
                opp++;
            }
      
            int flippedGain = 2 * Math.min(opp, k);
            best = Math.max(best, curr + flippedGain);
        }
        return best;
    }
}
\