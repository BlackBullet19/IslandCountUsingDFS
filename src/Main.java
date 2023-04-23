public class Main {
    public static void main(String[] args) {
        /*
        Find islands count in matrix using DFS algorithm!
        Constraints:
            nums[n].length = nums[0].length
            0<m,n<100
         */

        int[][] nums = new int[][]{
                {1, 1, 1, 1, 1},
                {0, 0, 1, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0}
        };

        System.out.println(findIsland(nums));
    }

    private static int findIsland(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;
        int islandCounter = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nums[i][j] == 1) {
                    DFS(nums, i, j);
                    islandCounter++;
                }
            }
        }
        return islandCounter;
    }

    private static void DFS(int[][] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length) {
            return;
        }
        if (nums[i][j] == 0) {
            return;
        }
        nums[i][j] = 0;

        // left
        DFS(nums, i, j - 1);

        //right
        DFS(nums, i, j + 1);

        //up
        DFS(nums, i - 1, j);

        //down
        DFS(nums, i + 1, j);
    }
}