import java.util.Scanner;

public class SumOfSines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double t = sc.nextDouble();
        double radian = Math.toRadians(t);
        System.out.println(Math.sin(2*radian) + Math.sin(3*radian));
    }
}
