// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the
// largest sum of any subarray is minimized. Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

// Example 1:
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

// ===============================================================================

✅ Key Idea
---> The minimum possible largest sum = max(nums) (since at least one subarray must contain the largest element).
---> The maximum possible largest sum = sum(nums) (if we put everything into one subarray).
---> We binary search between these bounds to find the smallest feasible maximum sum.

public class SplitArray {

    public boolean canSplit(int[] nums, int k, int maxSum) {

        int subArray=1, subSum=0;
        for(int num : nums) {

            if(subSum + num > maxSum) {
                subArray++;
                subSum = 0;
            }
            subSum += num;

            if(subArray > k) return false;
        }

        return true;

    }
    
    public int splitArray(int[] nums, int k) {

        int low=0, high=0, mid=0;
        for(int num : nums) {
            low = Math.max(num, low);
            high += num;
        }

        while(low <= high) {

            mid = low + (high-low)/2;

            if(canSplit(nums, k, mid)) 
                high = mid-1;
            else
                low = mid+1;
        }

        return low;
        
    }
    
}
