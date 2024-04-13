public class B {
    static void myInfo(){
        String name = "Le Vu Hieu";
        String StudentID = "23020365";
        String Class = "AI1";
        String GitUsername = "NaHieu2005";
        String email = "levuhieu2k5@gmail.com";
        System.out.println(name + '\t' + StudentID + '\t' + Class + '\t' + GitUsername + '\t' + email);
    }
    public static void main(String[] args) {
        myInfo();
        for (int i = 9; i >= 1; i--) {
            System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer.");
            System.out.println("Take one down, pass it around,");
        }
        System.out.println("No more bottles of beer on the wall.");
    }
}
