class solution {
    public void rotate(int[] nums, int k) {
       int i = 0;
       int[] newArr = new int[nums.length];
       while (i < nums.length) {
        newArr[i] = nums[(i+k)%nums.length];
       }
       for (int x = 0; x < nums.length; x++) {
            nums[x] = newArr[x];
        }
    }
    
}
