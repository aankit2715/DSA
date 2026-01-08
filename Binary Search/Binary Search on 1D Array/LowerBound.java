// Given a sorted array of nums and an integer x, write a program to find the lower bound of x.
// The lower bound algorithm finds the first and smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.
// If no such index is found, return the size of the array.

// Example:
// Input : nums= [1,2,2,3], x = 2
// Output:1
// Explanation:
// Index 1 is the smallest index such that arr[1] >= x.

// =============================================================================

public class LowerBound {

    int lowerBound(int[] arr, int target) {
        
        if(arr[arr.length-1] < target) return arr.length;
        
        int low=0, high=arr.length-1, mid=0;
        
        while(low < high) { // searching for exact element --> low <= high
                            // Lower Bound / Upper Bound (finding insertion position) --> low < high
            mid = low + (high-low)/2;
            
            if(arr[mid] >= target)
                high = mid;
            else
                low = mid+1;
            
        }
        
        return low;
        
    }
    
}
