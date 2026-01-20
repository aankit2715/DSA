// You are given an integer array bloomDay, an integer m and an integer k.
// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

// Example:
// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
// Output: 3

// ===========================================================================================


✅ Key Idea
---> If m * k > n (total flowers needed > total flowers available), it’s impossible → return -1.
---> The answer lies between min(bloomDay) and max(bloomDay).
---> For a given day D, we can check if it’s possible to make m bouquets:
    * Traverse bloomDay.
    * Count consecutive flowers that have bloomed (bloomDay[i] <= D).
    * Every time we reach k consecutive bloomed flowers, we form a bouquet and reset the count.
    * If total bouquets ≥ m, then day D is feasible.

public class MinimumDaysForBouquets {

    public boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {

        int flowers=0, bouquets=0;
        for(int b : bloomDay) {

            if(b <= day) {

                flowers++;
                if(flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
                    

            }
            else
                flowers = 0;

            if(bouquets >= m) return true;

        }

        return false;

    }

    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;
        if((long)m*k > n) return -1;

        int low=Integer.MAX_VALUE, high=Integer.MIN_VALUE, mid=0;
        for(int b : bloomDay) {
            low = Math.min(low, b);
            high = Math.max(high, b);
        }

        int res=high;
        while(low <= high) {
            
            mid = low + (high-low)/2;
            
            if(canMakeBouquets(bloomDay, m, k, mid)){
                res = mid;
                high = mid-1;
            }
            else
                low = mid+1;

        }

        return res;
        
    }
    
}
