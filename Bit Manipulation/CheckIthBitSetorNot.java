// Given two integers n and i, return true if the ith bit in the binary representation of n (counting from the least significant bit, 0-indexed) is set (i.e., equal to 1). 
// Otherwise, return false.

// Example:
// Input: n = 5, i = 0
// Output: true
// Explanation: Binary representation of 5 is 101. The 0-th bit from LSB is set (1).

// ===================================================================================

public class CheckIthBitSetorNot {

    public static boolean isBitSet(int n, int i) {
        // Shift 1 left by i positions and AND with n
        return (n & (1 << i)) != 0;
    }
      
}

 

