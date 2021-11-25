/*
 * @lc app=leetcode.cn id=14 lang=javascript
 *
 * [14] 最长公共前缀
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  let commonPrefix = '';

  if (strs.length === 0) {
    return commonPrefix;
  } else if (strs.length === 1) {
    return strs[0];
  }

  for (let i = 0; i < strs[0].length; i++) {
    for (let j = 1; j < strs.length; j++) {
      if (strs[j][i] !== strs[0][i]) {
        return commonPrefix;
      }
    }
    commonPrefix += strs[0][i];
  }

  // match ["",""] 这种情况
  return commonPrefix;
};
// @lc code=end

// @after-stub-for-debug-begin
module.exports = longestCommonPrefix;
// @after-stub-for-debug-end
