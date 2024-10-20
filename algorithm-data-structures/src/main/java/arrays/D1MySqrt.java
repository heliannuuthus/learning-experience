package arrays;

public class D1MySqrt {
    public static void main(String[] args) {

    }

    class Solution {
        public int mySqrt(int x) {
            int left = 0, right = x;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long)mid * mid == x) {
                    return mid;
                } else if ((long)mid * mid < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return right;
        }
    }
}
