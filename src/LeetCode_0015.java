import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0015 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
    * Arrays.sort(nums);的时间复杂度是O(nlogn)
    * 双循环的时间复杂度是O(n*2)
    * 使用了双指针，空间复杂度是O(1)
    */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return result;
        //对数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            //两个指针，分别指向当前遍历值的后续列表的两端
            int p = i + 1;
            int q = nums.length - 1;
            //当前元素去重,排除异常结果  这样为什么不行？
            //不能去除还没有遍历到的元素，这个元素可能会再运算中使用，只能与之前遍历过的元素进行比较
            // if((i < nums.length - 1) && nums[i] == nums[i+1])
            //     continue;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (p < q) {
                if (nums[i] + nums[p] + nums[q] == 0) {
                    // ArrayList<Integer> tempList = new ArrayList<>();
                    // tempList.add(nums[i]);
                    // tempList.add(nums[p]);
                    // tempList.add(nums[q]);
                    result.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    while (p < q && nums[p] == nums[p + 1]) //前指针去重
                        p++;
                    while (p < q && nums[q] == nums[q - 1]) //后指针去重
                        q--;
                    //继续
                    p++;
                    q--;
                } else if (nums[i] + nums[p] + nums[q] > 0) {
                    q--;
                } else {
                    p++;
                }
            }
        }
        return result;
    }
}
