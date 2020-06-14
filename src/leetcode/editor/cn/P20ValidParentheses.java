//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P20ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {
            Deque<Character> deque = new LinkedList<>();
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('{', '}');

            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    Character temp = deque.pollFirst();
                    if (temp == null || !temp.equals(map.get(s.charAt(i)))) {
                        return false;
                    }
                } else {
                    deque.offerFirst(s.charAt(i));
                }
            }
            return deque.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

