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

        int[] graph = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph[y - 1] = x;
        }

        for (int i = 0; i < n; i++) {
            out.print(graph[i] + " ");
        }
        out.flush();
    }
}
