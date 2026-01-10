// You are given a sorted array of integers arr and an integer target. Your task is to determine how many times target appears in arr.
// Return the count of occurrences of target in the array.

// Example:
// Input: arr = [0, 0, 1, 1, 1, 2, 3], target = 1
// Output: 3
// Explanation: The number 1 appears 3 times in the array.

// =========================================================================

public class CountOccurrences {

    public static int countOccurrences(int[] arr, int target) {
        int first = findBound(arr, target, true);
        if (first == -1) return 0; // target not found
        int last = findBound(arr, target, false);
        return last - first + 1;
    }

    private static int findBound(int[] arr, int target, boolean isFirst) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                if (isFirst) {
                    high = mid - 1; // keep searching left
                } else {
                    low = mid + 1;  // keep searching right
                }
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
    
}
 