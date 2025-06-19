// # Partition Array Such That Maximum Difference Is K

// ## Problem Summary
// Given an integer array `nums` and an integer `k`, partition it into the minimum number of subsequences such that the difference between the maximum and minimum values in each subsequence is at most `k`.

// ## My Thought Process

// - I sorted the array to make the difference between nearby numbers small.
// - Then I greedily grouped consecutive values with difference <= k.
// - If the next value is too far from the start of the group, I start a new group.

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int result=1;
        int start=nums[0];
        for ( int i =1; i< nums.length;i++){
            if(nums[i] - start > k){
                result++;
                // i--;
                start=nums[i];
            }
        }
        return result;
    }
}
