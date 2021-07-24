package com.qooapp.kotlin.example;

import com.qooapp.kotlin.example.bean.*;
import com.qooapp.kotlin.example.part3.Companion;
import com.qooapp.kotlin.example.part3.Ex_4Kt;
import com.qooapp.kotlin.example.utils.JavaUtils;
import com.qooapp.kotlin.example.utils.KotlinUtils;

public class MainJava {

    public static void main(String[] args) {
        Companion instance = Ex_4Kt.getInstance(Companion.Companion.getCompanion());
        System.out.println(instance);
        String name = Ex_4Kt.getName(Companion.Companion.getCompanion());
        System.out.println(name);
        String string = Ex_4Kt.toString(null);
        System.out.println(string);

        // java
        int test = JavaUtils.test();
        System.out.println(test);

        // 如果生成的有多個相同的 Java 文件（包名，類名都相同），可以使用
        // @JvmName + @JvmMultifileClass 註解進行合併成一個 Java 類，當然裡面方法有衝突是不行的
        test = KotlinUtils.kotlinTest();
        System.out.println(test);

        test = KotlinUtils.kotlinTest2();
        System.out.println(test);

        // bean
        JavaBean javaBean = new JavaBean();
        javaBean.setArg(1);
        javaBean.setArg2(2);
        javaBean.arg3 = "dddd";
        System.out.println(javaBean);
        // bean
        KotlinBean kotlinBean = new KotlinBean();
        kotlinBean.setArg(1);
        kotlinBean.setArg2(2);
        kotlinBean.setArg3("dddd");
        System.out.println(kotlinBean);

        DataKotlinBean dataKotlinBean = new DataKotlinBean();
        dataKotlinBean.setArg(1);
        dataKotlinBean.setArg2(2);
        dataKotlinBean.setArg3("dddd");
        System.out.println(dataKotlinBean);

    }
}
