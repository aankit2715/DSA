// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, 
// and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
// The test cases are generated so that there will be an answer.

// Example:
// Input: nums = [1,2,5,9], threshold = 6
// Output: 5

// ===================================================================================

public class DivisorThreshold {

    public boolean validDivisor(int[] nums, int threshold, int divisor) {

        int sum=0;
        for(int n : nums) {
            sum += (n + divisor -1)/divisor;

            if(sum > threshold) return false;
        }

        return true;

    }

    public int smallestDivisor(int[] nums, int threshold) {

        int low=1, high=Integer.MIN_VALUE, mid=0;

        for(int n : nums) 
            high = Math.max(high, n);

        int res = 0;

        while(low <= high) {

            mid = low + (high-low)/2;

            if(validDivisor(nums, threshold, mid)) {
                res = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }

        return res;
        
    }
    
}
