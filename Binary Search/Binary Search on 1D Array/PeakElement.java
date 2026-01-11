// A peak element is an element that is strictly greater than its neighbors.
// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
// You must write an algorithm that runs in O(log n) time.

// Example:
// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.

// =========================================================================

✅ Key Idea
---> A peak element is strictly greater than its neighbors.
---> Since nums[-1] = nums[n] = -∞, the ends can also be peaks.
---> We use binary search:
    * If nums[mid] < nums[mid+1], then a peak must exist in the right half.
    * Otherwise, a peak must exist in the left half (including mid).
---> Eventually, low == high, which is the index of a peak.

public class PeakElement {

    public int findPeakElement(int[] nums) {

        int low=0, high=nums.length-1, mid=0;

        while(low < high) {

            mid = low + (high-low)/2;
            // Peak lies in right half
            if(nums[mid] < nums[mid+1]) 
                low = mid+1;
            else
                high = mid;
        }

        return low;
        
    }
    
}
