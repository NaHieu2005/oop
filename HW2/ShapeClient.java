public class ShapeClient {
    public static void main(String[] args) {
        Shape a = new Shape("0 0 0 1 1 1 1 0");
        Shape b = new Shape("10 10 10 11 11 11 11 10");
        Shape c = new Shape("0.5 0.5 0.5 -10 1.5 0");
        Shape d = new Shape("0.5 0.5 0.75 0.75 0.75 0.2");
        
        System.out.println("a crosses b:" + Shape.isCrosses(a, b));
        System.out.println("a crosses c:" + Shape.isCrosses(a, c));
        System.out.println("a crosses d:" + Shape.isCrosses(a, d));

        System.out.println("a encircles b:" + Shape.isEncircle(a, b));
        System.out.println("a encircles c:" + Shape.isEncircle(a, c));
        System.out.println("a encircles d:" + Shape.isEncircle(a, d));
    }
}
