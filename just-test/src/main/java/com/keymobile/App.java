package com.keymobile;

import com.keymobile.model.Sub;

import java.util.StringTokenizer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /*StringTokenizer stringTokenizer = new StringTokenizer("string(100)", "()");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }*/
        String str = "100|66,55:200|567,90:102|43,54";

        StringTokenizer strToke = new StringTokenizer(str, "|");// 默认不打印分隔符
        // StringTokenizer strToke=new StringTokenizer(str,":,|",true);//打印分隔符
        // StringTokenizer strToke=new StringTokenizer(str,":,|",false);//不打印分隔符
        while (strToke.hasMoreTokens()) {
            System.out.println(strToke.nextToken());
        }
    }
}
