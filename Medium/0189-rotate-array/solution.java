class solution {
    /*
    public void rotate(int[] nums, int k) {
       int i = 0;
       int[] newArr = new int[nums.length];
       while (i < nums.length) {
        newArr[(i+k)%nums.length] = nums[i];
        i++;
       }
       for (int x = 0; x < nums.length; x++) {
            nums[x] = newArr[x];
        }
    }
    */
    

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums, int left, int right) {
        int temp = 0;
        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
