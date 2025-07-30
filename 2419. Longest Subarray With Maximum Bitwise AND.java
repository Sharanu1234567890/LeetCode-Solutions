class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num); // Step 1: Find max element
        }

        int count = 0, longest = 0;
        for (int num : nums) {
            if (num == max) {
                count++;              // Step 2: Count consecutive max elements
                longest = Math.max(longest, count);
            } else {
                count = 0;            // Reset if sequence breaks
            }
        }

        return longest;
    }
}
