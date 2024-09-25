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
        return this.x;
    }

    public int getSecondNum() {
        return this.y;
    }

    public int PlusNow() {
        return this.x + this.y;
    }
}