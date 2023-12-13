import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static String str;
    public static int[][] dp;
    public static String result = "";
        
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        str = in.next();
        n = str.length();

        dp = new int[n + 1][n + 1];

        for (int i = 1; i < n  + 1; i++){
            for (int j = 1; j < n  + 1; j++){
                if (str.charAt(i - 1) == str.charAt(n - j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int i = n, j = n;
        while (i > 0 && j > 0){
            if (str.charAt(i - 1) == str.charAt(str.length() - j)){
                result += str.charAt(i - 1);
                i--;
                j--;
            }
            else if(dp[i][j-1] > dp[i -1][j]){
                j--;
            }
            else {
                i--;
            }
        }

        out.println(result.length());
        out.print(result);
        out.flush();
    }
}
