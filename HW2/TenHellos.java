import java.util.Scanner;

public class TenHellos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String suffix = "th";
            if (i % 100 > 20){
                if (i % 10 == 1) suffix = "st";
                else if (i % 10 == 2) suffix = "nd";
                else if (i % 10 == 3) suffix = "rd";
            }
            System.out.println(i + suffix + " Hello");
        }
    }
}