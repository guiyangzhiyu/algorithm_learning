//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

package algorithm10.week01;

public class P66PlusOne {

    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            // 如果值不是9，那么直接+1，返回
            //是9的话，进入下次循环
            for (int i = digits.length - 1; i >=0 ; i--) {
                if (digits[i] != 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            //走到这里，说明值是 999999...
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

