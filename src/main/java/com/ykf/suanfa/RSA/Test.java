package com.ykf.suanfa.RSA;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2019-01-17 11:55
 */
public class Test {
    public static void main(String[] args) {
        try {
            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC3HHM2V3OI6ePftHrnY8fmEfFT1zv15+JJDnqvPIpGkRRJBrw8aaSebADeJOdsnX5hO15x71fZHPN3V9AtGRguAKbxFjqNFOIQobQAGAs/Egm4hxnQ7Hfjeh1qs4fd+pS9p51OpIS/TsFpWi3V89a+lh1CXh7BMYGVPkiVX3UOIwIDAQAB";
            String json = "";
            Map<String, String> map = new HashMap<>();

            //获取二维码
//            map.put("orderid", "1134387476543311872");
//            map.put("mchId", "132");
//            map.put("payType", "11");

            //订单列表
            map.put("vin", "");
            map.put("pageindex", "1");
            map.put("pagesize", "20");
            map.put("time", "1547693514055");
            map.put("userid", "14");

//            map.put("attach", "");
//            map.put("vin", "001");
//            map.put("goodsid", "33");
//            map.put("goodsname", "存储");
//            map.put("mchId", "132");
//            map.put("time", "1547695476016");
//            map.put("totalFee", "1");
//            map.put("userid", "14");

            MapUtil.sortMapByKey(map);
            String serverContent = MapUtil.concat(map);
            String a = RSA.encryptByPublicKey(serverContent, publicKey);
            System.out.println(serverContent);
            System.out.println(a);
        } catch (Exception e) {
        }
    }
}