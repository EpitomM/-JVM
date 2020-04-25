package cn.itcast.jvm.t3.load;

public class Load4 {
    public static void main(String[] args) {
        System.out.println(E.a);    // 10
        System.out.println(" - - - - - ");
        System.out.println(E.b);// hello
        System.out.println(" - - - - - ");
        System.out.println(E.c);//init E  20

    }
}

class E {
    public static final int a = 10;
    public static final String b = "hello";
    public static final Integer c = 20;  // Integer.valueOf(20)
    static {
        System.out.println("init E");
    }
}
