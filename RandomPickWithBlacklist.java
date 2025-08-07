/*
 * @lc app=leetcode.cn id=710 lang=java
 * @lcpr version=30202
 *
 * [710] 黑名单中的随机数
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RandomPickWithBlacklist {

    // @lc code=start
    class Solution {
        private int sz;
        private Map<Integer, Integer> mapping;
        private Random rand;

        public Solution(int n, int[] blacklist) {
            sz = n - blacklist.length;
            mapping = new HashMap<>();
            rand = new Random();

            for (int b : blacklist) {
                // 先把黑名单的数都放进去，value赋值为任意值
                mapping.put(b, 666);
            }

            int last = n - 1;
            for (int b : blacklist) {
                // 如果b已经在区间[sz, n)内，则不需要映射
                if (b >= sz) {
                    continue;
                }

                // 找到一个不在黑名单中的数
                while (mapping.containsKey(last)) {
                    last--;
                }

                mapping.put(b, last);
                last--;
            }
        }

        public int pick() {
            // 随机选取一个索引
            int index = rand.nextInt(sz);
            // 这个索引命中了黑名单，需要被映射到其他位置
            if (mapping.containsKey(index)) {
                return mapping.get(index);
            }

            // 若没命中黑名单，则直接返回
            return index;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(n, blacklist);
     * int param_1 = obj.pick();
     */
    // @lc code=end

    public static void main(String[] args) {
        // put your test code here
        int n = 5;
        int[] blacklist = { 1, 4 };
        Solution solution = new RandomPickWithBlacklist().new Solution(n, blacklist);
        for (int i = 0; i < 4; i++) {
            System.out.println(solution.pick());
        }
    }
}
