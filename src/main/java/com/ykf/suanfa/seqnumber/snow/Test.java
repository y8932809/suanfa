package com.ykf.suanfa.seqnumber.snow;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2018-12-26 15:43
 */
public class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println( SnowFlakeUtil.getOrderCode());
        }
    }
}