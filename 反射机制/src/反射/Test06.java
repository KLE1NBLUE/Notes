package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        //获得Class对象
        Class c1 = Class.forName("反射.Student");
//        //构造一个对象
//        Student student = (Student)c1.newInstance();
//        System.out.println(student);
//
//        //通过构造器创建对象
//        Constructor constructor = c1.getConstructor();
//        Student student1 = (Student)constructor.newInstance();
//        System.out.println(student1);

        //通过反射调用普通方法
//        Student student2 = (Student) c1.newInstance();
//        Method setName =  c1.getDeclaredMethod("setName",String.class);
//        setName.invoke(student2,"hello");
//        System.out.println(student2.getName());

        //通过反射操作属性
        Student student = (Student)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(student,"hello");
        System.out.println(student.getName());
    }
}
