package 反射;

public class Test02 {
}

class Father{
    static {
        System.out.println("父类被加载");
    }
}

class Son extends  Father{
    static {
        System.out.println("子类被加载");
        m=300;
    }

    static  int m =100;

}