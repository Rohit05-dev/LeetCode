class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int n = numbers.length;
        for(int i = 0; i < n; i++) {
            int diff = target - numbers[i];
            int low = i + 1;
            int high = n - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (numbers[mid] == diff) {
                    result[0] = i + 1;
                    result[1] = mid + 1;
                    return result;
                } else if (numbers[mid] < diff) {
                    low = mid +1;
                } else {
                    high = mid - 1;
                }
            }
        } 
        return result;
    }
}