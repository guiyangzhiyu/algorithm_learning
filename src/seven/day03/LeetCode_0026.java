package seven.day03;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0026 {
    public static void main(String[] args) {
        //有序数组
        int[] nums = new int[]{-1, 0, 1, 1, 2,2,2,6,7,8,8,9,9,9};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 返回不重复数组的长度
     * @param nums
     * @return new nums length
     *
     * 一次循环，时间复杂度O(n)
     * 没有使用额外的数据空间，使用双指针的方式遍历数组，空间复杂度O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0;
        for(int j = 1;j<nums.length;j++) {
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        // 没有算上第一个值，所以要+1
        return i + 1;
    }
}
