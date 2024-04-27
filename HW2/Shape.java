import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shape {
    double x, y, r = 1e18;
    ArrayList<double[]> points = new ArrayList<>();

    public Shape(String input){
        Scanner sc = new Scanner(input);
        while (sc.hasNext()){
            this.points.add(new double[]{sc.nextDouble(), sc.nextDouble()});
        }
        init();
        sc.close();
    }

    private void init(){
        for (int i = 0; i < points.size(); i++){
            x += points.get(i)[0];
            y += points.get(i)[1];
        }

        x = x / points.size();
        y = y / points.size();

        for (int i = 0; i < points.size(); i++){
            double dist = Math.sqrt((x - points.get(i)[0])*(x - points.get(i)[0]) + (y - points.get(i)[1])*(y - points.get(i)[1]));
            r = Math.min(dist, r);
        }
    }

    static boolean isCrosses(Shape a, Shape b){
        for (int i = 1; i < a.points.size(); i++){
            if (isinCircle(a.points.get(i-1)[0], a.points.get(i-1)[1], b.x, b.y, b.r) ^ isinCircle(a.points.get(i)[0], a.points.get(i)[1], b.x, b.y, b.r)){
                return true;
            }
        }
        return false;
    }

    static int isEncircle(Shape a, Shape b){
        if (isinCircle(b.x, b.y, a.x, a.y, a.r)) return 2;

        double dist = Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
        if (dist <= a.r + b.r) return 1;

        return 0;
    }

    static boolean isinCircle(double X, double Y, double x, double y, double r){
        double dist = Math.sqrt((x - X)*(x - X) + (y - Y)*(y - Y));
        return dist <= r;
    }
}
