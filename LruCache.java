/*
 * @lc app=leetcode.cn id=146 lang=java
 * @lcpr version=30202
 *
 * [146] LRU 缓存
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LruCache {

    // @lc code=start
    class LRUCache {
        int capacity;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }

            // 将key变为最近使用
            this.makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.put(key, value);
                // 将key变为最近使用
                this.makeRecently(key);
                return;
            }

            if (cache.size() >= this.capacity) {
                // 链表头部就是最久未使用的 key
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }

            // 将新的 key 添加链表尾部
            cache.put(key, value);

        }

        private void makeRecently(int key) {
            int val = cache.get(key);
            // 删除key，重新插入到队尾
            cache.remove(key);
            cache.put(key, val);
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    // @lc code=end

    public static void main(String[] args) {
        // put your test code here
        LRUCache lruCache = new LruCache().new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废
        System.out.println(lruCache.get(2)); // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废
        System.out.println(lruCache.get(1)); // 返回 -1 (未找到)
        System.out.println(lruCache.get(3)); // 返回 3
        System.out.println(lruCache.get(4)); // 返回 4

    }
}
