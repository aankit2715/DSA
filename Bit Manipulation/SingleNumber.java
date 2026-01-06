// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example:
// Input: nums = [4,1,2,1,2]
// Output: 4

// ==================================================================================

public class SingleNumber {

    public int singleNumber(int[] nums) {

        int i=0, res=0;

        while(i < nums.length) {

            res ^= nums[i]; // XOR of same number is 0.
            i++;
        }

        return res;

        
    }
    
}
