import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter((new FileWriter("output.txt")));
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++){
                matrix[i][j] = in.nextInt();
            }
        }

        boolean[] visited = new boolean[n];
        int[] marks = new int[n];
        int count = 1;

        Queue<Integer> queue = new ArrayDeque<>();

        while (count <= n) {
            for (int i = 0; i < n; i++) {
                if (visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                    break;
                }

            }
            while (!queue.isEmpty()) {
                int current = queue.poll();
                marks[current] = count;
                count++;

                for (int i = 0; i < n; i++) {
                    if (matrix[current][i] == 1 && !visited[i]){
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }

        }

        for (int i = 0; i < n; i++) {
            out.print(marks[i] + " ");
        }

        out.flush();
    }

}
