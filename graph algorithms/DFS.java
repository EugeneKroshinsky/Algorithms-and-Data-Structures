import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main implements Runnable{
    public static PrintWriter out;
    public static int count = 1;

    public static void DFS(int index, int[][] matrix, boolean[] visited, int n, int[] marks) {
        visited[index]  = true;

        marks[index] = count;
        count++;

        for (int i = 0; i < n; i++){
            if (matrix[index][i] == 1 && visited[i] == false) {
                DFS(i, matrix, visited, n, marks);
            }
        }

    }
    public static void main(String[] args) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }
    @Override
    public void run() {
        try {
            Scanner in = new Scanner(new File("input.txt"));
            out = new PrintWriter((new FileWriter("output.txt")));
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0 ; i < n; i++) {
                for (int j = 0; j < n; j++){
                    matrix[i][j] = in.nextInt();
                }
            }

            boolean[] visited = new boolean[n];
            int[] marks = new int[n];

            int start = 0;
            while (count <= n) {
                for (int i = 0; i < n; i++) {
                    if (visited[i] == false) {
                        start = i;
                        break;
                    }
                }

                DFS(start, matrix, visited, n, marks);
            }

            for (int i = 0; i < n; i++) {
                out.print(marks[i] + " ");
            }

            out.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
