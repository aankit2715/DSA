// Given an integer array nums of size n, sorted in ascending order with distinct values. 
// The array has been right rotated an unknown number of times, between 0 and n-1 (including). 
// Determine the number of rotations performed on the array.

// Example:
// Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
// Output: 4
// Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7]. So, we can notice that the array has been rotated 4 times.

// ==================================================================================

public class RotationCount {

    int findKRotation(int[] nums)  {
        
        int low=0, high=nums.length-1, mid=0;

        if(nums[low] <= nums[high]) return 0;

        while(low < high) {

            mid = low + (high-low)/2;

            if(nums[mid] > nums[high])
                low = mid+1;
            else
                high = mid;
        } 

        return low;
    
}
