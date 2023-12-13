import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        int countOfMatrix = in.nextInt();
        long[][] matrix = new long[countOfMatrix][2];
        long[][] dp = new long[countOfMatrix][countOfMatrix];

        for (int i = 0; i < countOfMatrix; i++){
            matrix[i][0] = in.nextInt();
            matrix[i][1] = in.nextInt();
        }



        for (int j = 1; j < countOfMatrix; j++){
            for (int i = j - 1; i >= 0; i--){
                long min = Long.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    long temp = dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
                    if (temp < min){
                        min = temp;
                    }
                }
                dp[i][j] = min;
            }
        }

        out.print(dp[0][countOfMatrix - 1]);
        out.flush();
    }
}
