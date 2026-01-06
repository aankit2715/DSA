// Given an integer n, return true if it is a power of two. Otherwise, return false.
// An integer n is a power of two if there exists an integer x such that n == 2x.

// You must solve it without using loops or recursion.

// Example:
// Input: n = 16
// Output: true
// Explanation: 24 = 16

// ==================================================================================

public class PowerofTwo {

     public static boolean isPowerOfTwo(int n) {
        // A power of two has exactly one bit set in its binary representation
        return n > 0 && (n & (n - 1)) == 0;
    }
    
}


 