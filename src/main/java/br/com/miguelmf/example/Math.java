package br.com.miguelmf.example;

public class Math {

    private int numberOfOperations;

    private Math() {
        super();
        numberOfOperations = 0;
    }

    public static Math newInstance() {
        return new Math();
    }

    public int sum(int x, int y) {
        register();
        return x + y;
    }

    public int subtract(int x, int y) {
        register();
        return x - y;
    }

    private void register() {
        numberOfOperations++;
    }

    public int getNumberOfOperations() {
        return numberOfOperations;
    }

}
