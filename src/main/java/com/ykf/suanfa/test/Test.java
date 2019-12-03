package com.ykf.suanfa.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2019-01-24 20:48
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> strList = new ArrayList<>();
        List<Integer> strList2 = new ArrayList<>();

        strList.add(1);
        strList.add(2);
        strList.add(3);

        strList2.add(1);
        strList2.add(3);
        strList2.add(4);

        strList.removeAll(strList2);

        System.out.println(1000%1000);
//        for (Integer item : strList) {
//            System.out.println(item);
//        }


    }

}