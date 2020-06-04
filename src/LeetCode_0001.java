import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0001 {
    /**
     * 使用2次循环，时间复杂度O(n),空间复杂度O(n)
     * @param nums 原数组
     * @param target 目标值
     * @return 索引数组
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("nums参数异常");
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            map.putIfAbsent(nums[i], i);
//            if(map.get(nums[i]) == null){
//                map.put(nums[i],i);
//            }
        }
        for(int i = 0;i < nums.length;i++) {
            if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("target参数异常");
    }
}
