package exceptionalhandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //always use try with resources & check for supressed exceptions
        try(FileInputStream fis = new FileInputStream("file.txt")) {
            //code to read from the file
        } catch (IOException e) {
            for (Throwable supressedException: e.getSuppressed()) {
                System.err.println("Supressed Exception " + supressedException.getMessage());
            }
            e.printStackTrace();
        }

    }
}
