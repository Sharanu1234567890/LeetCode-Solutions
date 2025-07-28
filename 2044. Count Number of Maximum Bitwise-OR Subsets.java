class Solution {
     int target=0;
        int count=0;

    public int countMaxOrSubsets(int[] nums) {
        // int target=0;
        // int count=0;

        for (int num : nums) target |= num;
        backtrack(nums,0,0);
        return count;
    }
    // return count;
 
    private void backtrack(int[] nums, int index, int currOr) {
        if(index==nums.length){
        if(currOr==target) count++;
        return;
        }
        

    backtrack(nums,index+1,currOr|nums[index]);

    backtrack(nums, index+1, currOr);
    
    // return count;
    }
}