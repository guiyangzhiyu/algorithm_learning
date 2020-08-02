//你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。 
//
// 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。 
//
// 示例 1: 
//
// 
//输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//输出: [20,24]
//解释: 
//列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
//列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
//列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
// 
//
// 注意: 
//
// 
// 给定的列表可能包含重复元素，所以在这里升序表示 >= 。 
// 1 <= k <= 3500 
// -105 <= 元素的值 <= 105 
// 对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。 
// 
// Related Topics 哈希表 双指针 字符串

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P632SmallestRangeCoveringElementsFromKLists {

    public static void main(String[] args) {
        Solution solution = new P632SmallestRangeCoveringElementsFromKLists().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法一、堆
        public int[] smallestRange(List<List<Integer>> nums) {
            //区间[leftValue,rightValue]
            int leftValue = 0, rightValue = Integer.MAX_VALUE;
            //最小区间的范围
            int minRange = rightValue - leftValue;
            //字符串的个数
            int size = nums.size();
            //heao中索引对应的最大值
            int max = Integer.MIN_VALUE;
            //strs[i]表示第i个数组当前的索引位置
            int[] strs = new int[size];
            PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer index1, Integer index2) {
                    return nums.get(index1).get(strs[index1]) - nums.get(index2).get(strs[index2]);
                }
            });
            //使用每个数组的第一个索引进行初始化
            for (int i = 0; i < size; i++) {
                //nums.get().get(strs[i]) ,比较每个数组的第0个元素
                heap.add(i);
                max = Math.max(max, nums.get(i).get(0));
//                max = Math.max(max,nums.get(i).get(strs[i]));
            }
            //当有一个数组遍历完后，跳出循环
            while (true) {
                //第minValueIndex个数组存了最小值
                int minValueIndex = heap.poll();
                //更新最小区间
                if (max - nums.get(minValueIndex).get(strs[minValueIndex]) < minRange) {
                    minRange = max - nums.get(minValueIndex).get(strs[minValueIndex]);
                    leftValue = nums.get(minValueIndex).get(strs[minValueIndex]);
                    rightValue = max;
                }
                //存在最小值的数组索引+1
                strs[minValueIndex]++;
                //数组遍历完了
                if (strs[minValueIndex] == nums.get(minValueIndex).size()) {
                    break;
                }
                //添加心的元素，更新最大值
                heap.add(minValueIndex);
                max = Math.max(max, nums.get(minValueIndex).get(strs[minValueIndex]));
            }
            return new int[]{leftValue, rightValue};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

