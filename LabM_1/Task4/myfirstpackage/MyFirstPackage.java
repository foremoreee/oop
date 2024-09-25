package myfirstpackage;

public class MyFirstPackage {
    private int x;
    private int y;

    public MyFirstPackage(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setFirstNum(int x) {
        this.x = x;
    }

    public void setSecondNum(int y) {
        this.y = y;
    }

    public int getFirstNum() {
        return x;
    }

    public int getSecondNum() {
        return y;
    }

    public int PlusNow() {
        return x + y;
    }
}