/*
 * @lc app=leetcode.cn id=9 lang=javascript
 *
 * [9] 回文数
 */

// @lc code=start
/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
  if (x < 0 || (x > 0 && x % 10 === 0)) {
    return false;
  }

  let rev = 0;

  while (rev < x) {
    rev = rev * 10 + (x % 10);
    x = Math.floor(x / 10);
  }

  return x === rev || x === Math.floor(rev / 10);
};
// @lc code=end

// @after-stub-for-debug-begin
module.exports = isPalindrome;
// @after-stub-for-debug-end
