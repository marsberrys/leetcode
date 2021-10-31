package solutions.s79;

import org.junit.Assert;
import org.junit.Test;


/**
 * 79. 单词搜索
 * @Author weixun
 * @Date 2021-10-30
 * @See https://leetcode-cn.com/problems/word-search/
 */
public class Solution {

    private static final int[][] V = new int[][] {{-1, 0},{0, 1},{1, 0},{0, -1}};

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        char[] words = word.toCharArray();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(check(board, words, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(char[][] board, char[] words, int idx, int i, int j, boolean[][] visited) {
        if(words[idx] != board[i][j]) {
            return false;
        }

        if(idx == words.length - 1) {
            return true;
        }

        visited[i][j] = true;
        for(int[] v : V) {
            int nxtI = i + v[0];
            int nxtJ = j + v[1];
            if(nxtI >= 0 && nxtJ >= 0 && nxtI < board.length && nxtJ < board[0].length && !visited[nxtI][nxtJ]) {
                if(check(board, words, idx + 1, nxtI, nxtJ, visited)) {
                    return true;
                }
            }
        }

        visited[i][j] = false;
        return false;
    }

    @Test
    public void test() {

        Assert.assertEquals(true, exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));

        Assert.assertEquals(true, exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));

        Assert.assertEquals(false, exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));

        Assert.assertEquals(true, exist(new char[][]{{'a'}}, "a"));

        System.out.println("ok");
    }
}
