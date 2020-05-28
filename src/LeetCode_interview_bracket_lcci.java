import java.util.LinkedList;
import java.util.List;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bracket-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_interview_bracket_lcci {
    static List<String> list = new LinkedList<>();
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(int n) {
        generate(0,0,n,"");
        return list;
    }

    /**
     * 通过递归生成产生的合法字符串
     * @param left 左括号的输入个数
     * @param right 右括号的输入个数
     * @param n 总括号的对数
     * @param s 生成的字符串
     */
    private static void generate(int left, int right, int n, String s) {
        if (left == n && right == n) { //退出递归的条件
            list.add(s);
            return;
        }
        if (left < n) // 只要左括号不超过总对数，那么就能进行添加
            generate(left + 1,right,n,s+"(");
        if (right < left) //右括号不超过左括号的个数，才能添加
            generate(left,right+1,n,s+")");
    }
}
