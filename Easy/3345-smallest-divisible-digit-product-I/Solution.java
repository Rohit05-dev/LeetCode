public class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int product = 1;
            for(int i = n; i > 0; i/=10) {
                product *= i % 10;
            }
            if (product % t == 0) {
                return n;
            }
            n++;
        }
    }
}
