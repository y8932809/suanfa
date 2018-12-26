package com.ykf.suanfa.seqnumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2018-12-26 15:29
 */
public class TestSequence extends Thread {

    IdGeneratorUtils idGenerator;
    IdSequenceUtils idSequenceUtils;

    static  List<String> list = new ArrayList<>();

    public TestSequence(IdGeneratorUtils idGenerator) {
        this.idGenerator = idGenerator;
    }

    int ct = 0;

    @Override
    public void run() {
        System.out.println();
        while (ct < 100) {
            String id =  idGenerator.nextId();
//            System.out.println(Thread.currentThread().getId() + " : " + id);
            list.add(id);
            ct++;
        }
    }


    public static void main(String[] args) {

        IdGeneratorUtils utils = new IdGeneratorUtils();

        TestSequence test1 = new TestSequence(utils);
        TestSequence test2 = new TestSequence(utils);

        test1.start();
        test2.start();

        System.out.println("---------------------------------------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}