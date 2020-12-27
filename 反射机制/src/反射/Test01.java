package 反射;

//测试Class类的创建方式
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {

        Person person = new Student();
        System.out.println("这人是" + person.name);

        //方式一 通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二 通过forName获得
        Class c2 = Class.forName("反射.Student");
        System.out.println(c2.hashCode());

        //方式三 通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //获得父类类型
        Class c4 = c1.getSuperclass();
        System.out.println(c4);


    }
}


class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }

    public String getName() {
        return null;
    }


}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}
