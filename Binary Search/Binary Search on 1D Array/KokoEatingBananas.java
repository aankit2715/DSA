// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
// The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
// If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

// Example:
// Input: piles = [3,6,7,11], h = 8
// Output: 4

// =====================================================================================

✅ Key Idea
Koko’s eating speed 𝑘 can range from 1 banana/hour up to max(piles) bananas/hour.
---> Use binary search on possible eating speeds:
    * Calculate total hours needed at mid speed.
    * If total hours <= h, increase speed (high = mid - 1).
    * If total hours > h, try to find a smaller speed (low = mid + 1).
    * 
    * 
public class KokoEatingBananas {

    public static boolean canEatAll(int[] piles, int h, int k) {

        int count=0;
        for(int p : piles) {
            count += (p + k -1)/k;
            if(count > h) return false;
        }

        return true;
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int low=1, high=0, mid=0;
        for(int p : piles)
            high = Math.max(high, p);

        int res=high;
        while(low <= high) {

            mid = low + (high-low)/2;

            if(canEatAll(piles, h, mid)) {
                res = mid;
                high = mid-1;
            }
            else
                low = mid+1;

        }  

        return res;   
    }
    
}
