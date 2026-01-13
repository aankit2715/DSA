// Given a positive integer n. Find and return its square root. If n is not a perfect square, 
// then return the floor value of sqrt(n)

// Example:
// Input: n = 28
// Output: 5
// Explanation: The square root of 28 is approximately 5.292. So, the floor value will be 5.

// ============================================================================================

✅ Key Idea
---> If mid * mid == n, return mid.
---> If mid * mid < n, move low = mid + 1 and store mid as a candidate answer.
---> If mid * mid > n, move high = mid - 1.

public class SquareRoot {

    public static int sqrt(int n) {
        if (n == 0 || n == 1) return n; // base cases

        int low = 1, high = n, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid <= n / mid) { // avoid overflow by using division
                ans = mid;        
                low = mid + 1;    
            } else {
                high = mid - 1;   
            }
        }
        return ans;
    }


    
}


 