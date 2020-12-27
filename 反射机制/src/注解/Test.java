package 注解;

import java.lang.annotation.*;

public class Test extends Object {
    @MyAnnotation
    public void test() {

    }


    //定义注解
    //Target 表示注解的使用位置
    @Target(value = {ElementType.METHOD, ElementType.TYPE})

    //Retention 表示注解有效位置
    //runtime>class>sources
    @Retention(value = RetentionPolicy.RUNTIME)

    //Documented 表示我们的注解称在JAVAdoc中
    @Documented

    //Inherited 子类可以继承父类注解
    @Inherited

    //自定义注解
    @interface MyAnnotation {
    }

}
