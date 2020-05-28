import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0283 {
    public static void main(String[] args) {
        int[] nums = {0,3,1,0,3,5,0,9,8};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 把0移动到数组的最后
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        // 记录非零数据的索引
        int j = 0;
        for(int i = 0;i < nums.length;i++) {
            if (nums[i] != 0) {
                //把不是0的元素赋值给j的索引处
                nums[j] = nums[i];
                //说明nums[j]再被赋值前的只是0，与nums[i]交换位置
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
