// You are given an array with unique elements of stalls[], which denote the positions of stalls. 
// You are also given an integer k which denotes the number of aggressive cows. 
// The task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

// Examples:
// Input: stalls[] = [1, 2, 4, 8, 9], k = 3
// Output: 3
// Explanation: The first cow can be placed at stalls[0], 
// the second cow can be placed at stalls[2] and 
// the third cow can be placed at stalls[3]. 
// The minimum distance between cows in this case is 3, which is the largest among all possible ways.

// ====================================================================================

✅ Key Idea 
---> Sort the stalls (they may not always be sorted).
---> The minimum possible distance = 1.
---> The maximum possible distance = max(stalls) - min(stalls).
---> Use binary search on distance d:
    * Check if it’s possible to place k cows such that each cow is at least d units apart.
    * If possible, try larger d.
    * If not possible, try smaller d.


public class AggressiveCows {

    public boolean canArrange(int[] stalls, int k, int minDist) {
        
        int lastPos=stalls[0], cowCount=1;
        
        for(int i=1; i<stalls.length; i++) {
            
            if(stalls[i]-lastPos >= minDist) {
                cowCount++;
                lastPos = stalls[i];
                
                if(cowCount == k) return true; 
                
            }
        }
        
        return false;
         
    }
    
    
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        
        Arrays.sort(stalls);
        int n = stalls.length;
        int low=1, high=stalls[n-1]-stalls[0], mid=0;
        
        int ans=0;
        while(low <= high) {
            
            mid = low + (high-low)/2;
            
            if(canArrange(stalls, k, mid)) {
                ans = mid;
                low = mid+1;
            }
            else
                high = mid-1;
            
        }
        
        return ans;
        
    }
    
}
