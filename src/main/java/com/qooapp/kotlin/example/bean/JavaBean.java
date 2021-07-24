package com.qooapp.kotlin.example.bean;

public class JavaBean {
    int arg;
    private Integer arg2;
    public String arg3;

    public int getArg() {
        return arg;
    }

    public void setArg(int arg) {
        this.arg = arg;
    }

    public Integer getArg2() {
        return arg2;
    }

    public void setArg2(Integer arg2) {
        this.arg2 = arg2;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "arg=" + arg +
                ", arg2=" + arg2 +
                ", arg3=" + arg3 +
                '}';
    }
}
