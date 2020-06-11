/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version 2020/6/11
 * @auther weixiang
 */
public class LeetCode_0009 {
    public static void main(String[] args) {
        System.out.print(isPalindrome(987789));
    }

    /** 使用双指针的方式进行判断 */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x%10 == 0)) {
            return false;
        }
        //取x右半部分的反转数
        int reversehelf = 0;
        while (x > reversehelf) {
            reversehelf = reversehelf*10 + x%10;
            x /= 10;
        }
        //需要加上对奇数位x的判断，把reversehelf/10 后，在进行比较
        return x == reversehelf || x == reversehelf/10;
    }
}
