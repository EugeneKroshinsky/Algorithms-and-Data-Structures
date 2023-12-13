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
        int[] arr = new int[n];
        arr[0] = in.nextInt();
        for (int i = 1; i < n; i++){
            arr[i] = in.nextInt();
            if(arr[i] < arr[(i - 1) / 2]){
                out.println("NO");
                out.flush();
                System.exit(0);
            }
        }
        out.println("YES");
        out.flush();
    }
}
