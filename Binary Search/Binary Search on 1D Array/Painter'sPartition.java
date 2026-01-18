// Given an array arr[] where each element denotes the length of a board, and an integer k representing the number of painters available. 
// Each painter takes 1 unit of time to paint 1 unit length of a board.
// Determine the minimum amount of time required to paint all the boards, under the constraint that each painter
// can paint only a contiguous sequence of boards (no skipping or splitting allowed).

// Examples:
// Input: arr[] = [5, 10, 30, 20, 15], k = 3
// Output: 35
// Explanation: The optimal allocation of boards among 3 painters is - 
// Painter 1 → [5, 10] → time = 15
// Painter 2 → [30] → time = 30
// Painter 3 → [20, 15] → time = 35
// Job will be done when all painters finish i.e. at time = max(15, 30, 35) = 35

// =======================================================================================

✅ Key Idea
---> Check feasibility:
    * If A > N, some painters will be idle, but allocation is still possible.
---> Search space:
    * Minimum possible maximum = max(C) (largest single board).
    * Maximum possible maximum = sum(C) (one painter paints all boards).
---> Binary search:
    * For a candidate maximum length mid, check if we can allocate boards to ≤ A painters without exceeding mid.
    * If feasible, try smaller mid.
    * If not feasible, try larger mid.

public class Painter'sPartition {

    public boolean canPaint(int[] arr, int k, int maxLen) {
        int curSum=0, painter=1;
        for(int len : arr) {
            if(curSum + len > maxLen) {
                painter++;
                curSum=0;
            }
            curSum += len;
            
            if(painter > k) return false;
        }
        
        return true;
    }
    
    public int minTime(int[] arr, int k) {
        // code here
        int low=0, high=0, mid=0;
        
        for(int ele : arr) {
            low = Math.max(low, ele);
            high += ele;
        }
        
        int ans=high;
        while(low <= high) {
            
            mid = low + (high-low)/2;
            
            if(canPaint(arr, k, mid)) {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        
        return ans;
    }
    
}
