package com.ykf.suanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2019-11-23 13:25
 */
public class ThreadTest {

    public static void main1(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                for (int index = 1; index <= 50; index++) {
                    System.out.println("休眠" + index + "秒");
                    Thread.sleep(1000);
                }
                return "执行完毕";
            }
        });
        task.run();
        System.out.println("执行结果：" + task.get());
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<FutureTask<Integer>> futureTaskList = new ArrayList<FutureTask<Integer>>();
        for (int i = 0; i < 5; i++) {
            final int index = i;
            FutureTask<Integer> ft = new FutureTask<Integer>(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println("子线程：" + index + ",执行完成！");
                    return getResult(index);
                }
            });
            futureTaskList.add(ft);
            executorService.submit(ft);
        }

        Integer totalResult = 0;
        for (FutureTask<Integer> ft : futureTaskList) {
            try {
                totalResult +=ft.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程计算的结果为：" + totalResult);
    }

    private static int getResult(int num) throws InterruptedException {
        Thread.sleep(5000);
        return num;
    }


    public static void main2(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<FutureTask<Integer>> futureTaskList = new ArrayList<FutureTask<Integer>>();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            FutureTask<Integer> ft = new FutureTask<Integer>(new Callable<Integer>() {
                private Integer result = 0;

                @Override
                public Integer call() throws Exception {
                    for (int j = 0; j < 100; j++) {
                        result += j;
                    }
                    Thread.sleep(5000);
                    System.out.println("子线程：" + index + ",执行完成！");
                    return result;
                }
            });
            futureTaskList.add(ft);
            executorService.submit(ft);
        }

        System.out.println("子线程提交完毕，主线程继续执行！");

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行完毕！");

        Integer totalResult = 0;
        for (FutureTask<Integer> ft : futureTaskList) {
            try {
                totalResult = +ft.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程计算的结果为：" + totalResult);
    }
}