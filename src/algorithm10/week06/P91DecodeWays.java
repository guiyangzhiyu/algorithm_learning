//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划

package algorithm10.week06;

public class P91DecodeWays {

    public static void main(String[] args) {
        Solution solution = new P91DecodeWays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            //dp[i]表示以i为结尾的子串解码个数
            //dp[i] = dp[i - 1] if s.charAt(i) != '0'
            //dp[i] += dp[i - 2] if    10 <=  s.sbString(i - 2,i) <= 26
            //注意处理dp[-1]的边界问题
            //可以进行空间优化
            int[] dp = new int[s.length()];
            dp[0] = s.charAt(0) == '0' ? 0 : 1;
            for (int i = 1; i < s.length(); i++) {
                int one = Integer.valueOf(s.substring(i, i + 1));
                int two = Integer.valueOf(s.substring(i - 1, i + 1));
                if (one > 0) {
                    dp[i] = dp[i - 1];
                }
                if (two >= 10 && two <= 26) {
                    dp[i] += (i == 1) ? 1 : dp[i - 2];
                }
            }
            return dp[s.length() - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

