package arrays;

public class D2BackspaceCompare {

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("bbbextm", "bbb#extm"));
    }

    static class Solution {
        public boolean backspaceCompare(String s, String t) {
            int i = s.length() - 1, j = t.length() - 1, icount = 0, jcount = 0;
            while (i >= 0 || j >= 0) {
                while (i >= 0) {
                    if (s.charAt(i) == '#') {
                        icount++;
                        i--;
                    } else if (icount > 0) {
                        i--;
                        icount--;
                    } else {
                        break;
                    }
                }

                while (j >= 0) {
                    if (t.charAt(j) == '#') {
                        jcount++;
                        j--;
                    } else if (jcount > 0) {
                        j--;
                        jcount--;
                    } else {
                        break;
                    }
                }

                if (i >= 0 && j >= 0) { // 边界
                    if (s.charAt(i) != t.charAt(j)) {
                        return false;
                    }
                } else  { // 如果 i > 0 或者 j > 0 表示一个已经遍历完成，另一个还未遍历完成，长度不相同
                    if (i >= 0 || j >= 0) {
                        return false;
                    }
                }
                j--;i--;
            }
            return true;
        }

    }
}
