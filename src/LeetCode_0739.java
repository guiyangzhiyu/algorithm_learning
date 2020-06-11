import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @version 2020/6/11
 * @auther weixiang
 */
public class LeetCode_0739 {
    public static void main(String[] args) {

    }
    //使用暴力的方式
    public int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];
        for(int i = 0;i < T.length;i++) {
            int j = i;
            while (j < T.length) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
                j++;
            }
        }
        return result;
    }

    //使用一个单调栈的方式
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        // 栈里面存着温度数组对应的下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < T.length;i++) {
            // 当前的温度比栈顶温度要大，那么记录栈顶元素的结果值，并且是栈顶元素出栈
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop();
                result[temp] = i - temp;
            }
            stack.push(i);
        }
        return result;
    }
}
