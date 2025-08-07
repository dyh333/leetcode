/*
 * @lc app=leetcode.cn id=380 lang=java
 * @lcpr version=30202
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class InsertDeleteGetRandomO1 {

    // @lc code=start
    class Solution {
        class RandomizedSet {
            // 存储元素的值
            private List<Integer> nums;
            // 记录每个元素对应在 nums 中的索引
            private Map<Integer, Integer> valToIndex;
            private Random rand;

            public RandomizedSet() {
                nums = new ArrayList<>();
                valToIndex = new HashMap<>();
                rand = new Random();
            }

            public boolean insert(int val) {
                // 若 val 已存在，不用再插入
                if (valToIndex.containsKey(val)) {
                    return false;
                }

                // 若 val 不存在，插入到 nums 尾部，
                // 并记录 val 对应的索引值
                valToIndex.put(val, nums.size());
                nums.add(val);
                return true;
            }

            public boolean remove(int val) {
                // 若 val 不存在，不用再删除
                if (!valToIndex.containsKey(val)) {
                    return false;
                }

                // 先拿到 val 的索引
                int index = valToIndex.get(val);
                int lastElement = nums.get(nums.size() - 1);
                // 将最后一个元素对应的索引修改为 index
                valToIndex.put(lastElement, index);
                // 交换 val 和最后一个元素
                nums.set(index, lastElement);
                // 在数组中删除元素 val
                nums.remove(nums.size() - 1);
                // 删除元素 val 对应的索引
                valToIndex.remove(val);
                return true;
            }

            public int getRandom() {
                return nums.get(rand.nextInt(nums.size()));
            }
        }

        /**
         * Your RandomizedSet object will be instantiated and called as such:
         * RandomizedSet obj = new RandomizedSet();
         * boolean param_1 = obj.insert(val);
         * boolean param_2 = obj.remove(val);
         * int param_3 = obj.getRandom();
         */
        // @lc code=end

        public static void main(String[] args) {
            Solution solution = new InsertDeleteGetRandomO1().new Solution();
            // put your test code here

        }
    }
}
