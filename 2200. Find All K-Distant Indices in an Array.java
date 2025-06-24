class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    //     ArrayList<Integer> arr = new ArrayList<>();

    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == key) {
    //             count(nums, i, k, arr);
    //         }
    //     }

    //     return arr;
    // }

    // public static void count(int[] nums, int index, int k, ArrayList<Integer> arr) {
    //     // Go from index - k to index + k
    //     for (int i = index - k; i <= index + k; i++) {
    //         if (i >= 0 && i < nums.length) { // Check array bounds
    //             if (!arr.contains(i)) {     // Avoid duplicates
    //                 arr.add(i);
    //             }
    //         }
    //     }
    // }


    //    ArrayList<Integer> result = new ArrayList<>();

    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = 0; j < nums.length; j++) {
    //             if (nums[j] == key && Math.abs(i - j) <= k) {
    //                 result.add(i);
    //                 break; // No need to check more j's for this i
    //             }
    //         }
    //     }

    //     return result;
    // }
    // }
    

     HashSet<Integer> set = new HashSet<>(); // avoids duplicates with O(1) time

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                for (int i = j - k; i <= j + k; i++) {
                    if (i >= 0 && i < nums.length) {
                        set.add(i);  // duplicates automatically avoided
                    }
                }
            }
        }

        // Convert to sorted ArrayList if needed
        ArrayList<Integer> result = new ArrayList<>(set);
        result.sort(null);  // sort the result if order matters

        return result;
    }
}