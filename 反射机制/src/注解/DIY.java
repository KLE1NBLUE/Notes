package 注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class DIY {
    //注解可以显示 赋值，没有默认值就需要给注解赋值
    @Myannotation2(name = "张三", schools = {"带专，说唱大学"})
    public void test() {

    }

    @Myannotation3("hello")
    public void test2() {

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Myannotation2 {
    //注解的参数：参数类型 + 参数名();
    String name() default "";

    int age() default 0;

    int id() default -1;//不存在

    String[] schools() default {"北大", "青鸟"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Myannotation3 {
    String value();
}