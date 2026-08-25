import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // If the set already has the number, we found a duplicate
            if (!seen.add(num)) {
                return true;
            }
        }
        
        // If the loop completes, every element is distinct
        return false;
    }
}
