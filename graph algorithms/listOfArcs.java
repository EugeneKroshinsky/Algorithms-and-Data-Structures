import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            if (graph[x - 1] == null) {
                graph[x - 1] = new ArrayList<>();
            }
            if (graph[y - 1] == null) {
                graph[y - 1] = new ArrayList<>();
            }
            graph[x - 1].add(y);
            graph[y - 1].add(x);
        }

        for (int i = 0; i < n; i++) {
            if (graph[i] == null) {
                out.print(0);
            } else {
                out.print(graph[i].size() + " ");
                for (int x : graph[i]){
                    out.print(x + " ");
                }
            }

            out.println();
        }
        out.flush();
    }
}
