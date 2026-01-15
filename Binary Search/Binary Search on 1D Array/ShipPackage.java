// A conveyor belt has packages that must be shipped from one port to another within days days.
// The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on
// the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

// Example:
// Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
// Output: 15
// Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
// 1st day: 1, 2, 3, 4, 5
// 2nd day: 6, 7
// 3rd day: 8
// 4th day: 9
// 5th day: 10

// ======================================================================================

✅ Key Idea
---> The ship’s capacity must be at least:
    * max(weights) (otherwise the heaviest package won’t fit).
---> At most:
    * sum(weights) (if we ship everything in one day).
---> We binary search between these two bounds to find the minimum feasible capacity.

public class ShipPackage {

    public boolean canConvey(int[] weights, int days, int capacity) {

        int wgtCount=0, dayCount=1;
        for(int w : weights) {    
            if(wgtCount + w > capacity) {
                dayCount++;
                wgtCount=0;
            }
            wgtCount += w; 

            if(dayCount > days) return false;
        }

        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
         
        int low=0, high=0, mid=0;
        for(int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        int res=0;
        while(low <= high) {

            mid = low + (high-low)/2;

            if(canConvey(weights, days, mid)) {
                res = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }

        return res;
        
    }
    
}
