import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

            int count = in.nextInt();
            for (int t = 0; t < count; t++){

                int n = in.nextInt();
                int k = in.nextInt();
                long[] dp = new long[n];
                dp[0] = 1;
                long currentSum = 1;

                for (int i = 1; i < n; i++){
                    dp[i] = currentSum % 1_000_000_007;
                    if (i >= k){
                        currentSum = (currentSum - dp[i - k] + dp[i]);
                    }
                    else
                    {
                        currentSum += dp[i];
                    }
                }
                out.println(dp[n - 1]);
            }
            out.flush();
    }
}
