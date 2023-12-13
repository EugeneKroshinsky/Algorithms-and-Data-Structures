import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static int[] arr1;
    public static int[][] dp;
    public static int[] arr2;
    public static ArrayList<Integer> result1;
    public static ArrayList<Integer> result2;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr1 = new int[n];
        arr2 = new int[n];
        for (int i = 0; i < n; i++){
            arr1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }

        result1 = new ArrayList<Integer>();
        result2 = new ArrayList<Integer>();

        dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++){
            for (int j = 1; j < n  + 1; j++){
                if (arr1[i - 1] == arr2[j - 1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

/*        for (int i = 0; i < n + 1; i++){
            for (int j = 0; j < n  + 1; j++){
                System.out.print(dp[i][j] +  " ");
            }
            System.out.println();
        }*/
        find(n, n);

        System.out.println(result1.size());
        for (int i = 0; i < result1.size(); i++){
            System.out.print(result1.get(i) + " ");
        }
        System.out.println();
        for (int j = 0; j < result1.size(); j++){
            System.out.print(result2.get(j) + " ");
        }
    }
    public static void find(int i, int j){
        if (i == 0 || j == 0){
            return;
        }
        if (arr1[i - 1] == arr2[j - 1]){
            find(i - 1, j - 1);
            result1.add(i - 1);
            result2.add(j - 1);
        }
        else if(dp[i][j-1] > dp[i -1][j]){
            find(i, j -1);
        }
        else {
            find(i - 1, j);
        }
    }
}
