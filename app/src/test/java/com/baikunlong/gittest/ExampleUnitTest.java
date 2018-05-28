package com.baikunlong.gittest;

import org.junit.Test;
import org.junit.internal.Classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test1() throws ClassNotFoundException {
        Person1 person1 = new Person1("白锟龙", 19, "男");
        System.out.println(person1.toString());
        Class<String> stringClass = String.class;
        System.out.println(stringClass);
        Class<? extends String> aClass = new String().getClass();
        System.out.println(aClass);
        Class<?> aClass1 = Class.forName("java.lang.String");
        System.out.println(aClass1);
    }

    @Test
    public void test2() throws Exception {
        Class<?> Person1 = Class.forName("com.baikunlong.gittest.Person1");
        Class<?> Person2 = Class.forName("com.baikunlong.gittest.Person1");
        // 2.获得对应的构造器
        // (1)获取Person对象的所对应的类的全部的public的构造器
        Constructor<?>[] constructors = Person1.getConstructors();
        System.out.println("构造方法"+Arrays.toString(constructors));
//        Constructor<?>[] declaredConstructors = Person1.getDeclaredConstructors();
//        System.out.println(declaredConstructors);
        //有参数
        Constructor<?> constructor = Person1.getConstructor(String.class, int.class, String.class);
        //无参
        Constructor<?> constructor1 = Person1.getConstructor(null);
        //实例化有参数与无参的
        Person1 p = (com.baikunlong.gittest.Person1) constructor.newInstance("白锟龙", 22, "男的");
        Person1 p2 = (com.baikunlong.gittest.Person1) constructor1.newInstance(null);
        p.showInfo(p.getName(),p.getAge());
        p2.show();
        //访问私有属性
        Field name = Person1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"改造的白锟龙");
        p.showInfo(p.getName(),p.getAge());
        //访问私有方法
        Method eat = Person1.getDeclaredMethod("eat",String.class);
        eat.setAccessible(true);
        String invoke = (String) eat.invoke(p, p.getName());
        System.out.println("访问私有方法eat："+invoke);
        //访问Person1里的main方法
        Method main = Person1.getDeclaredMethod("main", String[].class);
        main.invoke(p, (Object) new String[]{"带去main里的参数1","带去main里的参数2","带去main里的参数3"});
    }

}