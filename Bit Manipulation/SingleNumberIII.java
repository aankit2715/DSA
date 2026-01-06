// Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
// You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

// Example:
// Input: nums = [1,2,1,3,2,5]
// Output: [3,5]

// ==================================================================================

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        int xor=0;
        for(int n : nums) 
            xor ^= n;

        int diffBits = xor & -xor; // To lowest/rightmost set bit (-xor represents two's complement)

        int a=0, b=0;
        for(int n : nums) {

            if((n & diffBits) == 0)
                a ^= n;
            else
                b ^= n;
        }

        return (a < b) ? new int[] {a, b} :  new int[] {b, a};
        
    }
    
}
