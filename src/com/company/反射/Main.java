package com.company.反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String []args){
        try {
            Class clazz = Class.forName("com.company.反射.Student");

            Method main = clazz.getMethod("main", String[].class);

            main.invoke(null,(Object)new String[]{"a","b","c"});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
