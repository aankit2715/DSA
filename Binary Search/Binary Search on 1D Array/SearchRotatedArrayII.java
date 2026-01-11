// Given an integer array nums, sorted in ascending order (may contain duplicate values) and a target value k. 
// Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.

// Example:
// Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
// Output: True
// Explanation: The element 3 is present in the array. So, the answer is True.

// ====================================================================================

public class SearchRotatedArrayII {

    public boolean search(int[] nums, int target) {

        int low=0, high=nums.length-1, mid=0;

        while(low <= high) {

            mid = low + (high-low)/2;

            if(nums[mid] == target) return true;

            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            } 

            else if(nums[low] <= nums[mid]) {

                if(nums[low] <= target && target < nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else {

                if(nums[high] >= target && target > nums[mid])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }

        return false;
        
        
    }
    
}
