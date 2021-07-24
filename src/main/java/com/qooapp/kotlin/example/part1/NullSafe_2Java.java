package com.qooapp.kotlin.example.part1;

public class NullSafe_2Java {

    public static void main(String[] args) {
        String string = getString();
        if (string == null) {
            return;
        }
        System.out.println(string.length());
    }

    private void test1() {
        String string = getString();
        if (string != null) {
            System.out.println(string.length());
        }
        // Method invocation 'length' may produce 'NullPointerException'
        System.out.println(string.length());
    }

    private static String getString() {
        return null;
    }
}
