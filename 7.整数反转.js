/*
 * @lc app=leetcode.cn id=7 lang=javascript
 *
 * [7] 整数反转
 */

// @lc code=start
/**
 * @param {number} x
 * @return {number}
 */
 var reverse = function (x) {
  const isNegative = x < 0;
  const max = Math.pow(2, 31) - 1;
  let tooBig = false;
  x = Math.abs(x);
  let rev = 0;

  while (x) {
    rev = rev * 10 + (x % 10);
    x = Math.floor(x / 10);

    if (rev > max) {
      tooBig = true;
      break;
    }
  }

  if (tooBig) {
    return 0;
  } else {
    return isNegative ? -rev : rev;
  }
};
// @lc code=end

// @after-stub-for-debug-begin
module.exports = reverse;
// @after-stub-for-debug-end
