package com.fen4kin.webapp;

import com.fen4kin.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        // TODO : invoke r.toString via reflection
        //http://qaru.site/questions/14577/how-do-i-invoke-a-java-method-when-given-the-method-name-as-a-string
        System.out.println((r.getClass().getMethod("toString")).invoke(r));
        System.out.println(r);
    }
}