class MyFirstClass {
    public static void main(String[] s) {
        MySecondClass o = new MySecondClass(27, 57);
        System.out.println(o.Mnogitel());
        
	for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                o.setFirstNum(i);
                o.setSecondNum(j);
                System.out.print(o.Mnogitel()); System.out.print(" ");
            }
            System.out.println();
        }
    }
}
class MySecondClass {
    private int a;
    private int b;


    public MySecondClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getFirstNum() {
        return a;
    }

    public int getSecondNum() {
        return b;
    }

    public void setFirstNum(int a) {
        this.a = a;
    }

    public void setSecondNum(int b) {
        this.b = b;
    }

    public int Mnogitel() {
        return a * b;
    }
}