package com.ykf.suanfa.pay;

import com.ykf.suanfa.sign.MD5;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2019-06-10 16:46
 */
public class Test {

    public static void main(String[] args) {

        Map<String,String> param = new HashMap<>();
        param.put("appId","wxb2c62db60adf9342");
        param.put("timeStamp","1560156698");
        param.put("nonceStr","LhxeiaRQAlbUQprz");
        param.put("package","prepay_id=wx10154108481652d3c3fbab001253890000");
        param.put("signType","MD5");

        MapUtil.sortMapByKey(param);
        String serverContent = MapUtil.concatNotEmpty(param);

        String  stringSignTemp=serverContent+"&key=XQkGaLpIiwZTPDDcGUs2v3nilEB1T3bD";

        String sign= MD5.sign(stringSignTemp).toUpperCase();

        System.out.println(sign);
    }
}