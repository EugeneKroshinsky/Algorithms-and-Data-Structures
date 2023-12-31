import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = in.nextInt();
        }

        if (n == 1) {
            System.out.println(dp[0]);
            System.out.print(1);
            System.exit(0);
        }
        if (n == 2) {
            System.out.print(-1);
            System.exit(0);
        }
        dp[1] = -1;
        dp[2] += dp[0];

        for (int i = 3; i < n; i++)
        {
            dp[i] += Math.max(dp[i-2], dp[i-3]);
        }
        System.out.println(dp[n -1]);

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(n);
        int current = n - 1;
        while (current != 0) {
            if (current == 2) {
                stack.push(1);
                break;
            }
            current = dp[current - 2] > dp[current - 3] ? current - 2 : current - 3;
            stack.push(current + 1);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
