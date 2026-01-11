// Given an integer array nums of size N, sorted in ascending order with distinct values, and then rotated 
// an unknown number of times (between 1 and N), find the minimum element in the array.

// Example:
// Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
// Output: 0
// Explanation: Here, the element 0 is the minimum element in the array.

// ================================================================================

public class MinimumRotatedArray {

    public int findMin(int[] nums) {

        int low=0, high=nums.length-1, mid=0;

        if(nums[low] <= nums[high]) return nums[low];

        while(low < high) {

            mid = low + (high-low)/2;

            if(nums[mid] > nums[high])
                low = mid+1;
            else
                high = mid;
        }

        return nums[low];
        
    }
    
}
