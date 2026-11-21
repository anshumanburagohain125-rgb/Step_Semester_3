public class WarehouseBinGridScan {
    // Time: O(m * n); additional space: O(1), excluding the returned result.
    public static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxValue = grid[0][0];
        int maxRow = 0;
        int maxColumn = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                int value = grid[row][column];
                total += value;

                if (value > maxValue) {
                    maxValue = value;
                    maxRow = row;
                    maxColumn = column;
                }
            }
        }

        return new int[] { total, maxRow, maxColumn };
    }

    public static void main(String[] args) {
        int[][] grid = {
            { 4, 9, 2 },
            { 7, 1, 6 },
            { 3, 12, 5 }
        };

        int[] result = warehouseSummary(grid);
        System.out.println("total = " + result[0]
                + ", maxCoordinate = (" + result[1] + ", " + result[2] + ")");
    }
}
