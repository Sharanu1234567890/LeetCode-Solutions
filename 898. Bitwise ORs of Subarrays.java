import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();       // Stores all unique ORs
        Set<Integer> prev = new HashSet<>();         // ORs ending at previous index

        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num); // Start a new subarray

            for (int val : prev) {
                curr.add(val | num);  // Extend previous subarrays with current num
            }

            result.addAll(curr);
            prev = curr; // Prepare for next iteration
        }

        return result.size();
    }
}
