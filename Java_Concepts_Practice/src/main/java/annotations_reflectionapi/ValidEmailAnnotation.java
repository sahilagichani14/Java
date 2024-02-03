package annotations_reflectionapi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(ElementType.METHOD)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmailAnnotation {
    String message() default "Invalid Email format";

    //cannot be private & no parameters
    //private String func(int a, int b);
}
