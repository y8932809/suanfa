package com.ykf.suanfa.sign;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2019-02-18 11:49
 */
public class Md5Test {
    public static void main(String[] args) {
        String appSecret = "u748ym28xvbq8h8a1ode";
        Map<String, String> map = new HashMap<>();

//        map.put("wxcode","0335zAQj0rx1up1e55Oj0AYNQj05zAQn");
//        map.put("width","10");
//        map.put("isHyaline","true");


//        map.put("mobile","13552984926");
//        map.put("time","1551408715");


        map.put("appid","xmserer1bctx1y17");
        map.put("channel","changanS311");
        map.put("code","USCbsU");
        map.put("timestamp","1561020717204");
        MapUtil.sortMapByKey(map);
        String serverContent = MapUtil.concat(map);
        String test = serverContent + "&key=" + appSecret;
        String result = MD5.sign(serverContent + "&key=" + appSecret).toUpperCase();
        System.out.println(serverContent);
        System.out.println(test);
        System.out.println(result);
    }

    @Test
    public void run() {
        TreeMap<String, Object> params = syncCinemas();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (null != entry.getValue()) {
                if (null != entry.getValue().toString() && !entry.getValue().toString().equals("")) {
                    sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
            }
        }
        String s = sb.toString() + "key=A013F70DB97834C0A5492378BD76C53A" ;
        System.out.println(s);
        String sign = DigestUtils.md5Hex(s).toUpperCase();
        System.out.println(sign);
    }
    private static  TreeMap<String, Object> syncCinemas() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("merCode", "1000014");
        params.put("timestamp", "1557282165000");
        params.put("api", "gateway.sync.simpleshow");
        params.put("version", "1.0");
        params.put("signType", "MD5");
//        params.put("cinemaId", "10685");
//        params.put("startDate", "2019-05-07");
        params.put("bizData","{" +"\"cinemaId\":\"10685\"," +"\"startDate\":\"2019-05-07\"" +"}" );
        return params;
    }
}