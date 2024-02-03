package annotations_reflectionapi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // @Override, @Deprecated, @SuppressWarnings (tells compiler to suppress)
        // annotations are used for adding metadata & influencing behaviour of code at compile time or run time

        //REFLECTION API -> can be used in dynamic code modification, code generation, dependency injection, runtime config

        Class<Info> infoClassData = Info.class;
        if (infoClassData.isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation myCustomAnnotation = infoClassData.getAnnotation(MyCustomAnnotation.class);
            System.out.println(myCustomAnnotation.priority());
            System.out.println(Arrays.toString(myCustomAnnotation.tags()));
        }
        for(Method method: infoClassData.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation methodAnnotation = method.getAnnotation(MyCustomAnnotation.class);
                System.out.println(method.getName());
                System.out.println(methodAnnotation.priority());
                System.out.println(methodAnnotation.tags());
            }
        }

        //REFLECTION API EX-2
        try {
            Class<?> infoclass = Class.forName("annotations_reflectionapi.Info");
            Object instance = infoclass.getDeclaredConstructor().newInstance();
            Method method = infoclass.getMethod("getDetailedInfo");
            method.invoke(instance);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    @DescriptionAnnotation(describe = "Finding the answer", var = 1)
    public void method() {

    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface DescriptionAnnotation{
    String describe();
    int var();
    long xyz() default 20L; // if we give default val then even if we don't pass any value when using annotation then no error
}
