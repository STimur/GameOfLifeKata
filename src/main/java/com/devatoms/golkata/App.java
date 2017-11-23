package com.devatoms.golkata;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Field field = new Field(Field.GLIDER_SPACESHIP_PATTERN);
        for (int i = 0; ; i++) {
            System.out.println("Generation " + i + ":");
            System.out.println(field);
            System.out.println();
            Thread.sleep(1000);
            field = field.nextGen();
        }
    }
}
