package com.ykf.suanfa.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2018-12-24 17:34
 */
public class HttpTest {

    volatile static double lat = 30.66051;
    volatile static double lng = 104.12928;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        CountDownLatch countDownLatch = new CountDownLatch(1000);

        Long start = System.currentTimeMillis();
        System.out.println("开始时间：" + System.currentTimeMillis());
        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < 5000; i++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        lat -= 0.001;
                        lng -= 0.001;
                        RestTemplate restTemplate = new RestTemplate();
                        String uploadJson = restTemplate.getForEntity("http://127.0.0.1:8091/maplocation/checkPoint?type=1" + "&lat=" + lat + "&lng=" + lng, String.class).getBody();
                        System.out.println("请求开始：lat=" + lat + "lng=" + lng + "返回json" + uploadJson);
                        countDownLatch.countDown();
                    }
                });
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}