package seven.day03;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0011 {

    public static void main(String[] args) {
        //有序数组
        int[] nums = {1,3,9,34,3,5,23,5,234,23,4,523};
        System.out.println(maxArea(nums));
    }

    /**
     * 获取数组中形成的最大区域
     *
     * 最多遍历数组一次，时间复杂度O(n)
     * 额外使用了2个指针变量，空间复杂度O(1)
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        //一个头指针，一个尾指针。比较两个指针的大小，移动比较小的值。
        int maxArea = 0;
        if (height == null || height.length < 2)
            return maxArea;
        int head = 0,foot = height.length -1;
        // maxArea = (foot-head) * (Math.min(height[head],height[foot]));
        while (head < foot) {
            maxArea = Math.max(maxArea,(foot-head) * (Math.min(height[head],height[foot])));
            if (height[head] < height[foot]) {
                head++;
            } else {
                foot--;
            }
        }
        return maxArea;
    }
}
