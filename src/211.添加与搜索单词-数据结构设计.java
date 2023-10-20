/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {

    private boolean exist = false;

    private WordDictionary[] children = new WordDictionary[26];

    public WordDictionary() {

    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (node.children[c] == null) {
                node.children[c] = new WordDictionary();
            }
            node = node.children[c];
        }
        node.exist = true;
    }

    public boolean search(String word) {
        return dfs(word, this, 0);
    }

    private boolean dfs(String word, WordDictionary node, int begin) {
        for (int i = begin; i < word.length(); i++) {
            int c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null && dfs(word, node.children[j], i + 1)) {
                        return true;
                    }
                }
                return false;
            }
            c -= 'a';
            if (node.children[c] != null) {
                node = node.children[c];
            } else {
                return false;
            }
        }
        return node.exist;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

