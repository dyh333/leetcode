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
  if (strs.length === 0) {
    return '';
  } else if (strs.length === 1) {
    return strs[0];
  }

  let commonPrefix = strs[0];

  for (let i = 1; i < strs.length; i++) {
    while (strs[i].indexOf(commonPrefix) !== 0) {
      commonPrefix = commonPrefix.slice(0, commonPrefix.length - 1);
    }

    // 已经是空串，不需要继续遍历剩余字符串了
    if (commonPrefix === '') {
      break;
    }
  }

  return commonPrefix;
};
// @lc code=end

// @after-stub-for-debug-begin
module.exports = longestCommonPrefix;
// @after-stub-for-debug-end
