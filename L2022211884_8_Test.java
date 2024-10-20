import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.check_maven.Solution8;
public class L2022211884_8_Test {

    /**
     * 测试用例设计的总体原则:
     * 我们基于等价类划分原则进行测试用例的设计。
     * - 等价类1: 输入为正常的网格，存在多个岛屿。
     * - 等价类2: 输入为空网格，返回0。
     * - 等价类3: 输入为全部水域的网格，返回0。
     * - 等价类4: 输入为一个完整的岛屿，返回1。
     * - 边界测试: 只有一行或者一列的网格。
     */

    /**
     * 测试方法1: 测试正常的多个岛屿情况
     * 测试用例: 4x5网格，期望结果为3
     */
    @Test
    public void testMultipleIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(3, result, "4x5的网格应有3个岛屿");
    }

    /**
     * 测试方法2: 测试空网格情况
     * 测试用例: 输入为空，期望结果为0
     */
    @Test
    public void testEmptyGrid() {
        char[][] grid = new char[][]{};
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(0, result, "空网格应返回0个岛屿");
    }

    /**
     * 测试方法3: 测试只有水的情况
     * 测试用例: 3x3全水域网格，期望结果为0
     */
    @Test
    public void testAllWater() {
        char[][] grid = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(0, result, "全水域的网格应返回0个岛屿");
    }

    /**
     * 测试方法4: 测试一个完整岛屿的情况
     * 测试用例: 3x3的单个岛屿，期望结果为1
     */
    @Test
    public void testSingleIsland() {
        char[][] grid = {
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(1, result, "单个岛屿的网格应返回1个岛屿");
    }

    /**
     * 测试方法5: 边界测试 - 一行的网格
     * 测试用例: 1x5的网格，期望结果为2
     */
    @Test
    public void testOneRowGrid() {
        char[][] grid = {
                {'1', '0', '1', '0', '1'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(3, result, "1x5的网格应返回3个岛屿");
    }

    /**
     * 测试方法6: 边界测试 - 一列的网格
     * 测试用例: 5x1的网格，期望结果为2
     */
    @Test
    public void testOneColumnGrid() {
        char[][] grid = {
                {'1'},
                {'0'},
                {'1'},
                {'0'},
                {'1'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(3, result, "5x1的网格应返回3个岛屿");
    }
}