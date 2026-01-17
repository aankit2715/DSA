// Given an array nums of n integers, where nums[i] represents the number of pages in the i-th book,
// and an integer m representing the number of students, allocate all the books to the students so that
// each student gets at least one book, each book is allocated to only one student, and the allocation is contiguous.

// Allocate the books to m students in such a way that the maximum number of pages assigned to a student
// is minimized. If the allocation of books is not possible, return -1.

// Example 1
// Input: nums = [12, 34, 67, 90], m=2
// Output: 113
// Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.

// ====================================================================================

✅ Key Idea
---> Search space:
    * Minimum possible maximum = max(nums) (since one student must take the largest book).
    * Maximum possible maximum = sum(nums) (if one student takes all books).
---> Binary search:
    * For a candidate maximum mid, check if we can allocate books to ≤ m students without exceeding mid.
    * If feasible, try smaller mid.
    * If not feasible, try larger mid.

public class AllocateMinimumPages {

    public boolean canAllocate(int[] arr, int k, int maxPages) {
        
        int pageCount=0, allocate=1;
        for(int ele : arr) {
            
            if(pageCount + ele > maxPages) {
                allocate++;
                pageCount = 0;
            }
            pageCount += ele;
            if(allocate > k) return false;
        }
        return true;
    }
    
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(n < k) return -1;
        
        int low=0, high=0, mid=0;
        for(int e : arr) {
            low = Math.max(low, e);
            high += e;
        }
        
        while(low <= high) {
            
            mid = low + (high-low)/2;
            if(canAllocate(arr, k, mid)) {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        
        return low;
        
    }
    
}
