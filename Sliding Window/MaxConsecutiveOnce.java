// Given a binary array nums and an integer k, flip at most k 0's.
// Return the maximum number of consecutive 1's after performing the flipping operation.


// Example 1

// Input : nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] , k = 3

// Output : 10

// Explanation : The maximum number of consecutive 1's are obtained only if we flip the 0's present at position 3, 4, 5 (0 base indexing).
// The array after flipping becomes [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0].
// The number of consecutive 1's is 10.

// =================================================================================



class Solution {
    public int longestOnes(int[] nums, int k) {

        int left=0, right=0, maxLen=0, zeros=0;

        while(right < nums.length) {

            if(nums[right] == 0)
                zeros++;

            while(zeros > k) {

                if(nums[left] == 0)
                    zeros--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
        
    }
}