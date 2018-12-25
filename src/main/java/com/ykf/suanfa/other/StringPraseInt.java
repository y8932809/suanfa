package com.ykf.suanfa.other;

/**
 * @author yukf
 * @create 2018-11-09 14:51
 * @desc String字符串转换Int
 **/
public class StringPraseInt {


    public static void main(String[] args) {
        System.out.println(Convert("1234"));
    }

//    public static Integer Convert(String str) {
//        char[] chars = str.toCharArray();
//        Integer number = 0;
//        for (int i = 0; i < chars.length; i++) {
//            number = number * 10 + (chars[i]- '0');
//        }
//        return number;
//    }

    public static Integer Convert(String str) {
        char[] chars = str.toCharArray();
        Integer number = 0;
        for (int i = 0; i < chars.length; i++) {
            number = number * 10 + (chars[i] - '0');
        }
        return number;
    }


}
