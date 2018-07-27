package jvm;

public class IllegalForwardReference {

    static {
        i = 10;//可以赋值。当 i 没有在声明时赋值的情况下有用。
//        System.out.println(i);//不能访问，会提示 Illegal Forward Reference
    }

    static int i;

    public static void main(String[] args) {
        System.out.println(i);
    }

}
