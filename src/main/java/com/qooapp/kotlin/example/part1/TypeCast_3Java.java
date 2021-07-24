package com.qooapp.kotlin.example.part1;

public class TypeCast_3Java {
    public static void main(String[] args) {
        Parent parent = new Child();
        if (parent instanceof Child) {
            ((Child) parent).getName();
        }
    }
}
