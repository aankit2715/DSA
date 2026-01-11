// Given an integer array nums, sorted in ascending order (with distinct values) and a target value k. 
// The array is rotated at some pivot point that is unknown. Find the index at which k is present and if k is not present return -1.

// Example:
// Input : nums = [4, 5, 6, 7, 0, 1, 2], k = 0
// Output: 4
// Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array,
// nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

// ====================================================================================

public class SearchRotatedArrayI {

     public int search(int[] nums, int target) {

        int low=0, high=nums.length-1, mid=0;

        while(low <= high) {

            mid = low + (high-low)/2;

            if(nums[mid] == target) return mid;

            else if(nums[low] <= nums[mid]) {
                
                if(nums[low] <= target && target < nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else {

                if(target > nums[mid] && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }

        return -1;
        
    }
    
}
