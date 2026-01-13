// Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as a number
// X such that when X is raised to the power of N, it equals M. If the Nth root is not an integer, 
// return -1.

// Example:
// Input: N = 3, M = 27
// Output: 3
// Explanation: The cube root of 27 is equal to 3.

// ====================================================================================

✅ Key Idea
---> Calculate mid^N.
    * If mid^N == M, return mid.
    * If mid^N < M, move low = mid + 1.
    * If mid^N > M, move high = mid - 1.

public class NthRoot {

    public static int nthRoot(int N, int M) {
        int low = 1, high = M;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long power = power(mid, N);  

            if (power == M) {
                return mid;  
            } else if (power < M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; 
    }

     
    private static long power(int x, int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
            if (result > Long.MAX_VALUE / 2) break; // prevent overflow
        }
        return result;
    }
    
}
 
