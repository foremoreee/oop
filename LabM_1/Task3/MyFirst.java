
class MyFirstClass {
    public static void main(String[] s) {
        MySecondClass o = new MySecondClass(993, 7);
        System.out.println(o.PlusNow());
        
	for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                o.setFirstNum(i);
                o.setSecondNum(j);
                System.out.print(o.PlusNow()); System.out.print(" ");
            }
            System.out.println();
        }
    }
}
class MySecondClass {
    private int x;
    private int y;

    public MySecondClass(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getFirstNum() {
        return x;
    }
    public int getSecondNum() {
        return y;
    }
    public void setFirstNum(int x) {
        this.x = x;
    }
    public void setSecondNum(int y) {
        this.y = y;
    }
    public int PlusNow() {
        return x + y;
    }
}
