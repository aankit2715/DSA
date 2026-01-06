// Given a non-negative integer n, determine whether it is odd.
// Return true if the number is odd, otherwise return false.

// A number is odd if it is not divisible by 2 (i.e., n % 2 != 0).

// Example:
// Input: n = 7
// Output: true
// Explanation: 7 is not divisible by 2. Hence, it is odd.

// =================================================================================

public class CheckOddNumber {

    public static boolean isOdd(int n) {
        // Using bitwise AND with 1 to check the least significant bit
        return (n & 1) == 1;
    }
    
}



 