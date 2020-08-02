//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P212WordSearchIi {

    public static void main(String[] args) {
        Solution solution = new P212WordSearchIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // define Trie
        class Trie {
            //定义Trie的节点
            class TrieNode {
                private String val;
                private TrieNode[] childs;
                private int R = 26;
                private boolean isEnd;

                public TrieNode() {
                    childs = new TrieNode[R];
                }

                public boolean containsKey(char ch) {
                    return childs[ch - 'a'] != null;
                }

                public void put(char ch, TrieNode node) {
                    childs[ch - 'a'] = node;
                }

                public TrieNode get(char ch) {
                    return childs[ch - 'a'];
                }

                public void setEnd() {
                    isEnd = true;
                }

                public boolean isEnd() {
                    return isEnd;
                }

                public void setVal(String word) {
                    val = word;
                }
                public String getVal(){
                    return val;
                }
            }

            TrieNode root;

            /**
             * Initialize your data structure here.
             */
            public Trie() {
                root = new TrieNode();
            }

            /**
             * Inserts a word into the trie.
             */
            public void insert(String word) {
                TrieNode node = root;
                for (char ch : word.toCharArray()) {
                    if (!node.containsKey(ch)) {
                        node.put(ch, new TrieNode());
                    }
                    node = node.get(ch);
                }
                node.setVal(word);
                node.setEnd();
            }

            /**
             * Returns if the word is in the trie.
             */
            public boolean search(String word) {
                TrieNode node = searchPrefix(word);
                return node != null && node.isEnd();
            }

            /**
             * Returns if there is any word in the trie that starts with the given prefix.
             */
            public boolean startsWith(String prefix) {
                TrieNode node = searchPrefix(prefix);
                return node != null;
            }

            /**
             * search a prefix or whole key in the trie
             *
             * @param prefix
             * @return the node where the search ends
             */
            public TrieNode searchPrefix(String prefix) {
                TrieNode node = root;
                for (char ch : prefix.toCharArray()) {
                    if (node.containsKey(ch)) {
                        node = node.get(ch);
                    } else {
                        return null;
                    }
                }
                return node;
            }
        }

        //四连通方向
        int[][] dirts = {{-1,0},{1,0},{0,-1},{0,1}};
        int row,col;
        Set<String> result;
        boolean[][] visited;
        char[][] board;
        public List<String> findWords(char[][] board, String[] words) {
            result = new HashSet<>();
            if (board == null || board.length == 0 || board[0].length == 0) {
                return new ArrayList<>(result);
            }
            this.board = board;
            row = board.length;
            col = board[0].length;
            visited = new boolean[row][col];
            //定义并初始化前缀树
            Trie trie = new Trie();
            Trie.TrieNode root = trie.root;
            for (String word : words) {
                trie.insert(word);
            }
            for (int i = 0 ;i < row;i++) {
                for (int j = 0; j < col; j++) {
                    dfs(i,j,root);
                }
            }
            return new ArrayList<>(result);
        }

        private void dfs(int i, int j, Trie.TrieNode root) {
            if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j]) {
                return;
            }
            root = root.get(board[i][j]);
            visited[i][j] = true;
            if (root == null) {
                visited[i][j] = false;
                return;
            }
            if (root.isEnd()) {
                result.add(root.val);
            }
            for (int[] dirt : dirts) {
                int newRow = i + dirt[0],newCol = j + dirt[1];
                if (newRow >= 0 && newRow < row && newCol >=0 && newCol < col && !visited[newRow][newCol]) {
                    dfs(newRow,newCol,root);
                }
            }
            //TODO 有问题
            visited[i][j] = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

