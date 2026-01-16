// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
// Return the kth positive integer that is missing from this array.

// Example 1:
// Input: arr = [2,3,4,7,11], k = 5
// Output: 9
// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

// ======================================================================================

✅ Key Idea
---> For each element arr[i], the number of missing integers before it is:
                            arr[i] - (i + 1)
     because in a strictly increasing array starting from 1, the expected value at index i is i+1.

public class KthMissing {

    public int findKthPositive(int[] arr, int k) {

        int low=0, high=arr.length-1, mid=0, missing=0;

        while(low <= high) {

            mid = low + (high-low)/2;
            missing = arr[mid] - (mid+1);

            if(missing < k)
                low = mid+1;
            else
                high = mid-1;
        }

        return low + k;
        
    }
    
}
