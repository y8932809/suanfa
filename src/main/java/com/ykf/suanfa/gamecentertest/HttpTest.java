package com.ykf.suanfa.gamecentertest;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
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

    public static void main1(String[] args) {

        Integer threadCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        Long start = System.currentTimeMillis();
        System.out.println("开始时间：" + System.currentTimeMillis());
        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < threadCount; i++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
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

//        for (int i = 1;i<100 ;i++){
//            System.out.println(getUserId());
//        }
    }

    private static String getUserId() {
        List<String> userIds = new ArrayList<>();
        userIds.add("82c9b3d6ad2740e7a2abf87193e69531");
        userIds.add("1306b7451d4f40ecbdb15eeac23fc651");
        userIds.add("b3039596884b42329e9a4ee0fe638e92");
        userIds.add("f34639220351476b957fa79151dc61d4");
        userIds.add("05b95b0cf1ab47faa688b0861efbd8ba");
        userIds.add("89a57a59bc42426a9265869b74e25578");
        userIds.add("24bf759644f542618dcc38ea0eec133f");
        userIds.add("f3e11662eaae40de811ecee87f987052");
        userIds.add("8419bc94776941c2963cdd4234e39706");
        userIds.add("961dd85fa2c14e699ad02bd03f5f5a0c");
        userIds.add("3e2ae855ee7b4edeb0c74d5971e79b00");
        userIds.add("81235a9504d44343aebfd83c51d2eb14");
        userIds.add("fdb587a1c0ba486ca28f0078df7684e8");
        userIds.add("2016aef660764f37a35d6ff1f7daaecc");
        userIds.add("5a32e7961da041c886c4ae0ef6b0ede9");
        userIds.add("913d2469ee994021ad9eab920041f7dc");
        userIds.add("b7210d4a34a04bb0bbe36ee35442b059");
        userIds.add("e8e7c0b89d0b4cc5aff3a2e164edb949");
        userIds.add("a71448fc252b4536bc8de541a2194623");
        userIds.add("ce3be4ffc79b4787a02f91b5d2fbd37d");
        userIds.add("a93754ba028c49d186199fc45acd1198");
        userIds.add("bb167500419540bcb01331c3fdecc0f7");
        userIds.add("4d8ee9bd168e4f2c90aa16e66c00febc");
        userIds.add("095eec8f84fc466a9e7980a803ee0a97");
        userIds.add("a6f67ca0483a49e7b360f52d75938b67");
        userIds.add("62ee098b9ffc4fa698b7ffa3a0e4d99e");
        userIds.add("c919be3bae5048cb9d705d7ebd4ea8b1");
        userIds.add("bf1609fef3ba4816b29a436f7552030b");
        userIds.add("3b5f38f88623431c876182e5e9be1730");
        userIds.add("bfd9441308c5491eb1ffc4c97e0efaba");
        userIds.add("43b5716f377c4b2e93e4201e5f01e721");
        userIds.add("a942461a9f1f491abb5a8dc7fb17f87c");
        userIds.add("91bce297d2e445eea68a0712b6960bdc");
        userIds.add("21caa69f1efd470d8b0672fec05e4016");
        userIds.add("503eb8673a654fa5ad681bedeced99e3");
        userIds.add("b6752203a3e14060a90ecc1f88157260");
        userIds.add("e1bb2b76bdfc428ba5c90a47bb7688dd");
        userIds.add("ffbfa67df2b84c79a9431cdb79a63a0e");
        userIds.add("3fedb33158cb4044a8844f4109a6a8bb");
        userIds.add("544ad4a4c2284bfdae78a7587572d2f4");
        userIds.add("8e251bbc78a24c06b343fbc7d9d707c3");
        userIds.add("6deeffe5db8f4485a4ec6afc34a605e9");
        userIds.add("d6abf0a362684df08b1ff63f9db54eff");
        userIds.add("b5ce3ed2e3754c919b3a7af8db2b1836");
        userIds.add("4fb41de1d5be4352bbad317dc547ba4d");
        userIds.add("3792fec257b04a29beaa78fbab8aa54d");
        userIds.add("db2575ff5ff14a1ba3c84c43bb99eb42");
        userIds.add("3a914fcf6f234f6f9f78df2399b159c0");
        userIds.add("d811a5df37ca4d9f9f4c610280a58319");
        userIds.add("1d590dceb35d4082ad0a53d4e7d4a0f7");
        userIds.add("44201870359c476db8fa56d945de10d7");
        userIds.add("f0362ced5ac343c3a34507260c3fbe8b");
        userIds.add("5545e7db245e4d95b73f25e870b0f30b");
        userIds.add("6f0cf2c77e0a4865878a503836e53dd8");
        userIds.add("a2724feb687c4a3686810af295e53c3d");
        userIds.add("cfa4de4f0b55436299ff50e5aa75d37a");
        userIds.add("231b051d422d4ad4a8cdf218fe96bd86");
        userIds.add("af52a4b3b7fa490c8600f4f4e88ff3fe");
        userIds.add("ba0a3a5ee2f44c30939358eea8af6dd6");
        userIds.add("ab18419ec14e46539862dd8d0cb25e68");
        userIds.add("0c7b8c99152c493f93bf150404347f98");
        userIds.add("cf264b9f46a04244ba32b42775ed00f9");
        userIds.add("148c9d8adcd843e88d4f02f69755f291");
        userIds.add("237ff7c5364d43c1853fa393dd56025c");
        userIds.add("80232b60c242423b9b4bc126e4c215fd");
        userIds.add("ecf00661a8744e94a23ad72c344ca040");
        userIds.add("978251eef7994851afd166d746d5d2ea");
        userIds.add("946eb4eb2eb94bf183b0f2e07e1ce4da");
        userIds.add("ddee75f11a0b42bf92c66d40bf617695");
        userIds.add("14a0825f12e84a958b0575ee58f6b577");
        userIds.add("664d428438024e9a97ce692ad19343fd");
        Random rand1 = new Random();
        return userIds.get(rand1.nextInt(71));
    }

    @Test
    private static String getPos() {
//       "40.186218,116.571808"
        double l1 = 39.260000;
        double l2 = 115.250000;
        Random random = new Random();

        l1 = l1 + Math.random() * 1.77;
        l2 = l2 + Math.random() * 1.35;

        return String.format("%.6f", l1) + "," +  String.format("%.6f", l2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getPos());
        }
    }
}