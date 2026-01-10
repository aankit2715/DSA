// Given a sorted array of nums and an integer x, write a program to find the upper bound of x.
// The upper bound of x is defined as the smallest index i such that nums[i] > x.
// If no such index is found, return the size of the array.

// Example 1
// Input : n= 4, nums = [1,2,2,3], x = 2
// Output:3
// Explanation:
// Index 3 is the smallest index such that arr[3] > x.

// ===================================================================================

public class UpperBound {

    int upperBound(int[] arr, int target) {
        // code here
        
        int n=arr.length;
        
        if(arr[n-1] < target) return n;
        
        int low=0, high=n-1, mid=0;
        
        while(low < high) {
            
            mid = low + (high-low)/2;
            
            if(arr[mid] > target)
                high = mid;
            else
                low = mid+1;
        }
        
        return low; // or return high, since low == high at the end
        
    }
    
}
