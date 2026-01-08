// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// ===================================================================================

public class FindBound {

    public int findBound(int[] nums, int target, boolean isFirst) {

        int low=0, high=nums.length-1, mid=0, bound=-1;

        while(low <= high) {

            mid = low + (high-low)/2;

            if(nums[mid] == target) {
                bound = mid;
                if(isFirst) 
                    high = mid-1;
                else 
                    low = mid+1;
            }
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }

        return bound;
    }
    
    public int[] searchRange(int[] nums, int target) {

        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);

        return new int[] {first, last};
        
    }
    
}
