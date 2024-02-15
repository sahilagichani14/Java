package Junit;

import java.util.Arrays;

public class Calculator {

    public int sum(int a, int b){
        return a+b;
    }

    public int divide(int a, int b){
        if(b==0) throw new IllegalArgumentException("Int can't be divided by 0");
        return a/b;
    }

    public boolean isEven(int x){
        return x%2==0;
    }

    public int[] incrementArray(int n[]){
        return Arrays.stream(n).map(x->x+1).toArray();
    }
}
