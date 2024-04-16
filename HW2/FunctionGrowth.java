public class FunctionGrowth {
    public static void main(String[] args) {
        System.out.println("log n" +'\t' + "n" + "\t\t" + "n log n" + '\t' + "n^2" + "\t\t" + "n^3");
        for (long i = 2; i <= 2048; i *= 2){
            System.out.print((int)Math.log(i)+"   ");
            System.out.print("\t");
            System.out.print(i + "   ");
            System.out.print("\t");
            System.out.print(i*(int)Math.log(i));
            System.out.print("\t\t");
            System.out.print(i*i);
            System.out.print("\t");
            System.out.print(i*i*i);
            System.out.println();
        }
    }
}
