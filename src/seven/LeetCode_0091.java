package seven;

/**
 * @version 2020/6/8
 * @auther weixiang
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0091 {
    public static void main(String[] args) {
        System.out.print(decodeSum("2137392378"));
    }

    /**
     * 字符串stre 解码的总个数
     *
     * @param str 待解码的字符串
     * @return 解码的个数
     */
    public static int decodeSum(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = str.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= str.length(); i++) {
            int first = Integer.valueOf(str.substring(i - 1, i));
            int second = Integer.valueOf(str.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[str.length()];
    }
}
