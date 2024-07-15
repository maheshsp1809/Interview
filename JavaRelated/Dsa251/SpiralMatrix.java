public class SpiralMatrix {

    // Function to print the matrix in spiral order
    public static void printSpiral(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Define the boundaries of the matrix
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // Print the top row from left to right
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            // Print the right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // Print the bottom row from right to left if there are still rows remaining
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            // Print the left column from bottom to top if there are still columns remaining
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Spiral order of matrix1:");
        printSpiral(matrix1);
        System.out.println();

        // Test case 2
        int[][] matrix2 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        System.out.println("Spiral order of matrix2:");
        printSpiral(matrix2);
        System.out.println();
    }
}
