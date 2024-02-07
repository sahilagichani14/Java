package codeinsidedocker;

import lombok.extern.java.Log;

@Log
public class Hello {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
    }
}
