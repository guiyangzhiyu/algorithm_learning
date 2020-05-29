/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0070 {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    /**
     *
     * @param level
     * @return
     */
    public static int climbStairs(int level){
        int[] temp = new int[level];
        return climb_stairs(0,level,temp);
    }

    /**
     *
     * 使用数组缓存，使得时间复杂度为O(n)
     * @param i 当前的阶数
     * @param level
     * @param temp
     */
    private static int climb_stairs(int i, int level, int[] temp) {
        if (i > level)
            return 0;
        if (i == level)
            return 1;
        temp[i] = climb_stairs(i+1,level,temp) + climb_stairs(i+2,level,temp);
        return temp[i];
    }
}
