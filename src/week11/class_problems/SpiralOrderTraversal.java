public class SpiralOrderTraversal {
    // Time: O(m * n); output space: O(m * n).
    public static int[] spiralOrder(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[] result = new int[rows * columns];
        int index = 0;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;

        while (top <= bottom && left <= right) {
            for (int column = left; column <= right; column++) {
                result[index++] = grid[top][column];
            }
            top++;

            for (int row = top; row <= bottom; row++) {
                result[index++] = grid[row][right];
            }
            right--;

            if (top <= bottom) {
                for (int column = right; column >= left; column--) {
                    result[index++] = grid[bottom][column];
                }
                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result[index++] = grid[row][left];
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[] result = spiralOrder(grid);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
