此题依然可以使用计数法来完成，因为其所计数对象在常数空间内————a~z
通过先遍历字符串n统计次数后再遍历标记空间m,因此时间复杂度在O(MAX(n,m))
代码如下：
```
class Solution {
    public int firstUniqChar(String s) {
        int[][] book=new int[26][2];
        char[] chs=s.toCharArray();
        int n=s.length();//String是对象，方法
        for(int i=0;i<n;i++){//标记出现次数
            book[chs[i]-'a'][0]++;
            book[chs[i]-'a'][1]=i;//记录下标
        }
        int res=n;
        for(int i=0;i<26;i++)//搜索出现一次的元素
            if(book[i][0]==1&&book[i][1]<res)
                res=book[i][1];
        return (res==n)?-1:res;
    }
}
```
