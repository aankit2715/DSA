Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. 
The floor of x is the largest element in the array which is smaller than or equal to x. 
The ceiling of x is the smallest element in the array greater than or equal to x. If no floor or ceil exists, output -1.

Example:
Input : nums =[3, 4, 4, 7, 8, 10], x= 5
Output: 4 7
Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

public class FloorAndCeil {

    public int[] findFloorAndCeil(int[] nums, int x) {
        int floor = -1, ceil = -1;
        int low = 0, high = nums.length - 1;

        // Find floor (largest element <= x)
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= x) {
                floor = nums[mid];   // candidate floor
                low = mid + 1;       // move right to find larger floor
            } else {
                high = mid - 1;
            }
        }

        // Reset pointers for ceil
        low = 0; high = nums.length - 1;

        // Find ceil (smallest element >= x)
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= x) {
                ceil = nums[mid];    // candidate ceil
                high = mid - 1;      // move left to find smaller ceil
            } else {
                low = mid + 1;
            }
        }

        return new int[]{floor, ceil};
    }   
    
}
