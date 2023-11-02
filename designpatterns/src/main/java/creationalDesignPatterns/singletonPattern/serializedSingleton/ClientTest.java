package creationalDesignPatterns.singletonPattern.serializedSingleton;

import java.io.*;
import java.util.Objects;

public class ClientTest {
    public static void main(String[] args) throws IOException {

        /*
          In some cases we need to serialize & deserialize singleton obj, but serialization creates a new obj which breaks
          Singleton. so override readResolve method with any access modifier(public, private) which will be automatically
          called by JVM.
        */

        ObjectOutput objectOutput = null;
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();

        try {
            objectOutput = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
            objectOutput.writeObject(singletonLazy1);
            objectOutput.flush();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (objectOutput!=null){
                objectOutput.close();
            }
        }

        ObjectInput objectInput = null;
        SingletonLazy singletonLazy2 = null;

        try {
            objectInput = new ObjectInputStream(new FileInputStream("singleton.ser"));
            Object readObject = objectInput.readObject();
            singletonLazy2 = (SingletonLazy)readObject;

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (objectInput!=null){
                objectInput.close();
            }
        }

        boolean isSingletonLazy = String.valueOf(singletonLazy1.hashCode()).equals(String.valueOf(Objects.requireNonNull(singletonLazy2).hashCode()));
        System.out.println(singletonLazy1.hashCode() + " " + singletonLazy2.hashCode() + " " + isSingletonLazy);
    }
}
