package creationalDesignPatterns.singletonPattern.destroySingletonViaReflection;

import creationalDesignPatterns.singletonPattern.SingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class ClientTest {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        /*
            we are creating singleton2 using reflection since we can change behaviour of constructor, var, methods at runtime
            so to avoid this we can use Enums, since there is no private constructor to manipulate, also Enum value is
            instantiated only once in Java program and are globally accessible. However, Enums doesn't allow LAZY initialisation.
        */

        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = null;


        Constructor<?>[] declaredConstructors = SingletonLazy.class.getDeclaredConstructors();
        for(Constructor<?> constructor: declaredConstructors){
            constructor.setAccessible(true);
            Object obj = constructor.newInstance();
            singletonLazy2 = (SingletonLazy) obj;
            break;
        }

        boolean isSingletonLazy = String.valueOf(singletonLazy1.hashCode()).equals(String.valueOf(Objects.requireNonNull(singletonLazy2).hashCode()));
        System.out.println(singletonLazy1.hashCode() + " " + singletonLazy2.hashCode() + " " + isSingletonLazy);

        SingletonEnum singletonEnum1 = SingletonEnum.GET_INSTANCE;
        SingletonEnum singletonEnum2 = SingletonEnum.GET_INSTANCE;
        boolean isSingletonEnum = String.valueOf(singletonEnum1.hashCode()).equals(String.valueOf(Objects.requireNonNull(singletonEnum2).hashCode()));
        System.out.println(singletonEnum1.hashCode() + " " + singletonEnum2.hashCode() + " " + isSingletonEnum);

    }
}
