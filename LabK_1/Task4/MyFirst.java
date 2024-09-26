import mfpackage.*;

class MyFirstClass {
    public static void main(String[] s) {
        MFPackage o = new MFPackage(57, 24);
        System.out.println(o.Mnogitel());
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                o.setFirstNum(i);
                o.setSecondNum(j);
                System.out.print(o.Mnogitel());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}