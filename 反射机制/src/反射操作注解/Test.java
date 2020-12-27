package 反射操作注解;

//练习反射操作注解

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("反射操作注解.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation anotation : annotations
        ) {
            System.out.println(anotation);
        }


        //获得注解value的值
        Table table = (Table)c1.getAnnotation(Table.class);
        String  value = table.value();
        System.out.println(value);

        //获得类指定注解
        Field f = c1.getDeclaredField("name");
        FieldStu annotation = f.getAnnotation(FieldStu.class);
        System.out.println(annotation.columname());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@Table("db_student")
class Student2 {
    @FieldStu(columname = "db_id", type = "int", length = 10)
    private int id;
    @FieldStu(columname = "db_age", type = "int", length = 10)
    private int age;
    @FieldStu(columname = "db_name", type = "varchar", length = 10)
    private String name;

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Student2() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


@Table("db_Student")
//类名注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

//属性注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldStu {
    String columname();

    String type();

    int length();
}