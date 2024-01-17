import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            matrix[x - 1][y - 1] = 1;
            matrix[y - 1][x - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(matrix[i][j] + " ");
            }
            out.println();
        }
        out.flush();

    }
}
