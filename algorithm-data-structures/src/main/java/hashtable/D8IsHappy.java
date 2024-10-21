package hashtable;

import java.util.HashMap;
import java.util.HashSet;

public class D8IsHappy {

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }

    static class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> insetSet = new HashSet<>();
            while (true) {
                int[] sumSet = new int[10];
                while (n != 0) {
                    int temp = n % 10;
                    sumSet[temp]++;
                    n /= 10;
                }
                int sum = 0;
                for (int i = 0; i < sumSet.length; i++) {
                    if (sumSet[i] > 0) {
                        sum += sumSet[i] * (i * i);
                    }
                }
                if (sum == 1) return true;
                else if (insetSet.contains(sum)) return false;
                else insetSet.add(sum);
                n = sum;
            }
        }
    }
}
