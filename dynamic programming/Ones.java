import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if (n - k > k){
            k = n - k;
        }
        long numerator = 1, denominator = 1;
        for (int i = k + 1; i < n + 1; i++){
            numerator = (i * numerator) % 1_000_000_007;
        }
        for (int i = 1; i < n - k + 1; i++) {
            denominator = (i * denominator) % 1_000_000_007;
        }

        long pow = 1_000_000_005;
        long result = 1;
        while(pow > 0){
            if(pow % 2 == 1){
                result = (result * denominator) % 1_000_000_007;
            }
            denominator = denominator * denominator % 1_000_000_007;
            pow >>= 1;
        }

        System.out.println(numerator * result % 1_000_000_007);
    }
}
