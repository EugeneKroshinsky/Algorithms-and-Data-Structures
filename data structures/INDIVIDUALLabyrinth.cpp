
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

        int m, c, n;
        m = in.nextInt();
        c = in.nextInt();
        n = in.nextInt();

        int[] hashTable = new int[m];

        for (int i = 0; i < m; i++) {
            hashTable[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int j = 0;
            while (true){
                int currentPos = ((x % m) + c * j) % m;
                if(hashTable[currentPos] == -1 || hashTable[currentPos] == x){
                    hashTable[currentPos] = x;
                    break;
                }
                j++;
            }
        }

        for (int i = 0; i < m; i++) {
            out.print(hashTable[i] + " ");
        }
        out.flush();
    }
}
