// Given an integer n, return the number of set bits (1s) in its binary representation.
// Can you solve it in O(log n) time complexity?

// Example:
// Input: n = 5
// Output: 2
// Explanation: The binary representation of 5 is 101, which has 2 set bits.

// ==================================================================================

public class CountSetBits {

    public static int SetBitsCount(int n) {
        int count = 0;
        while (n != 0) {
            // Clear the least significant set bit
            n &= (n - 1);
            count++;
        }
        return count;
    }
    
}

 