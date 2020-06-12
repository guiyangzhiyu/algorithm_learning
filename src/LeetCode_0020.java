import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version 2020/6/12
 * @auther weixiang
 */
public class LeetCode_0020 {
    static Map<Character, Character> map = new HashMap<>();
    public static void main(String[] args) {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        System.out.println(isValid("[][][{}]{()}"));
    }

    public static boolean isValid(String s) {
        //使用栈的方式，左括号入栈，如果遍历到右括号，与栈顶元素不相等，那么就表示非法
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Character temp = deque.isEmpty() ? '?' : deque.removeFirst();
                if (!temp.equals(map.get(s.charAt(i)))) {
                    return false;
                }
            } else {
                deque.addFirst(s.charAt(i));
            }
        }
        return deque.isEmpty();
    }
}

