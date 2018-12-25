package com.ykf.suanfa.redpackage;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author yukf
 * @create 2018-10-15 14:27
 * @desc 随机红包算法
 **/
public class RandomMoney {
    public static double getRandomMoney(LeftMoneyPackage _leftMoneyPackage) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (_leftMoneyPackage.remainSize == 1) {
            _leftMoneyPackage.remainSize--;
            return (double) Math.round(_leftMoneyPackage.remainMoney * 100) / 100;
        }
        Random r = new Random();
        double min = 0.01; //
        double max = _leftMoneyPackage.remainMoney / _leftMoneyPackage.remainSize * 2;
//        double money = r.nextDouble() * max;

        double money = r.nextDouble() * (max - min) + min;
        money = money <= min ? min : money;
        money = Math.floor(money * 100) / 100;
        _leftMoneyPackage.remainSize--;
        _leftMoneyPackage.remainMoney -= money;
        return money;
    }


    public static void main(String[] args) {
        LeftMoneyPackage leftMoneyPackage = new LeftMoneyPackage();
        leftMoneyPackage.remainMoney = 200;
        leftMoneyPackage.remainSize = 50;
        int count = leftMoneyPackage.remainSize;

        BigDecimal total = new BigDecimal(0);
        for (int i = 0; i < count; i++) {
            double money = getRandomMoney(leftMoneyPackage);
            System.out.print(money + ",");
            total = total.add(BigDecimal.valueOf(money));
        }
        System.out.println("");
        System.out.println(total);
    }

    @Test
    public void test() {
        double min = 5;
        double max = 10;
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            double a = random.nextDouble() * (max - min) + min;
            if (a < min || a > max) {
                System.out.println("超出" + a);
                break;
            }
//            System.out.print("，" + a);
        }
    }

}
