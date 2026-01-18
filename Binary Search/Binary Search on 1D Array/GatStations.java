// We have a horizontal number line. On that number line, we have gas stations at positions stations[0], stations[1], ..., stations[n-1].
// Now, we add k more gas stations so that d, the maximum distance between adjacent gas stations, is minimized. We have to find the smallest possible value of d. Find the answer exactly to 6 decimal places.
// Note: stations is in a strictly increasing order.

// Examples:
// Input: stations[] = [1, 2, 3, 4, 5], k = 2
// Output: 1.00
// Explanation: Since all gaps are already equal (1 unit each), adding extra stations in between does not reduce the maximum distance.

// ======================================================================

public class GatStations {

    public boolean canPlace(int[] stations, int k, double dist) {
        int newStations=0;
        for(int i=0; i<stations.length-1; i++) {
            
            double gap = stations[i+1]-stations[i];
            newStations += (int) (gap/dist);
        }
        
        return newStations <= k;
    }
    
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        double low=0, high=stations[n-1]-stations[0]; 
        
        while(high - low > 1e-6) {   // when loop needs to run floating point numbers
            
            double mid = low + (high - low) / 2.0;
            
            if(canPlace(stations, K, mid)) 
                high = mid;
            else
                low = mid;
        }
        
        return high;
    }

    
}
