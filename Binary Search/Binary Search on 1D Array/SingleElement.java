// You are given a sorted array consisting of only integers where every element appears exactly twice,
// except for one element which appears exactly once.
// Return the single element that appears only once.
// Your solution must run in O(log n) time and O(1) space.

// Example:
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2

// ======================================================================

✅ Key Idea
---> The array is sorted, and every element appears twice except one.
---> Pairs normally start at even indices: (0,1), (2,3), (4,5)….
---> If the single element is before index mid, the pairing breaks earlier.
---> We can use binary search to detect where the "pairing rule" breaks.

public class SingleElement {

    public int singleNonDuplicate(int[] nums) {

        int low=0, high=nums.length-1, mid=0;

        while(low < high) {

            mid = low + (high-low)/2;
            // Ensure mid is even (so we compare pairs correctly)
            if(mid % 2 == 1)
                mid--;
            // If pair is valid, single element is in right half
            if(nums[mid] == nums[mid+1])
                low = mid+2;
            else
                high = mid;
        }

        return nums[low];
    }
    
}
