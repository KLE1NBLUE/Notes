package reflection;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * 练习-通过配置文件获取对象
 *
 * 首先准备一个文本文件：hero.config。 在这个文件中保存类的全名称，可以是charactor.APHero 或者是charactor.ADHero
 * 接着设计一个方法叫做：
 * public static Hero getHero()
 * 在这个方法中，读取hero.config的数据，取出其中的类名，根据类名实例化出对象，然后返回对象。
 */

public class Test01 {

    public static void main(String[] args) {
        List<String> reflexClass = getReflexClass("f:hero.config");
        ADHero ad = (ADHero) getHero(reflexClass, 0);//通过该方法反射实例化ADHero对象
        APHero ap = (APHero) getHero(reflexClass, 2);//通过该方法反射实例化ADHero对象
        executeMethod(ad, "setName", String.class, "盖伦");//通过反射给这英雄设置名称
        executeMethod(ap, "setName", String.class, "提莫");//通过反射给这英雄设置名称
        executeMethod(ad, "attackHero", Hero.class, ap);//通过反射，调用第一个英雄的attackHero方法，攻击第二个英雄
    }
    //读取配置文件
    public static List<String> getReflexClass(String filename) {
        File file = new File(filename);
        List<String> reflexClass = new ArrayList<String>();
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)){
            while(true) {
                String line = br.readLine();
                if(line == null) {
                    break;
                }
                reflexClass.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reflexClass;
    }
    //通过反射调用方法
    public static void executeMethod(Hero h,String methodName,Class clazz,Object args) {
        try {
            Method method = h.getClass().getMethod(methodName, clazz);
            method.invoke(h, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //通过反射获取Hero对象
    public static Hero getHero(List<String> list,int index) {
        List<String> reflexClass = getReflexClass("g:/Test/hero.config");
        Hero h = null;
        try {
            Class<?> clazz = Class.forName(reflexClass.get(index));
            Constructor<?> cons = clazz.getConstructor();
            h = (Hero) cons.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return h;
    }



}
