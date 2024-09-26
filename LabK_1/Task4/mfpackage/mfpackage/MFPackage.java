package mfpackage;

public class MFPackage {
    private int a;
    private int b;

    public MFPackage(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setFirstNum(int a) {
        this.a = a;
    }

    public void setSecondNum(int b) {
        this.b = b;
    }

    public int getFirstNum() {
        return a;
    }

    public int getSecondNum() {
        return b;
    }

    public int Mnogitel() {
        return a * b;
    }
}