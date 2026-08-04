import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public ArrayList<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        int max = nums[0];
        int min = nums[0];
        set.add(nums[0]);

        for(int i = 1; i < n; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
            set.add(nums[i]);
        }

        int i = min + 1 ;
        while (i < max) {
            if (set.contains(i)) {
                i++;
            } else {
                list.add(i);
                i++;
            }
        } 
        
        return list;
    }
}
