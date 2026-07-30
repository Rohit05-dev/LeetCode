import java.util.HashMap;

class solution {
    
    public int[] twoSum (int[] nums, int target) {
        int[] myArr = new int[2];
        HashMap<Integer, Integer> myMap = new HashMap<>();
        
        for(int i = 0; i <= nums.length; i++){
            
            int diff = target - nums[i];
            if (myMap.containsKey(diff)) {
                myArr[0] = i;
                myArr[1] = myMap.get(diff);
            }
            myMap.put(nums[i], i);
        }
        return myArr;
    }

}


