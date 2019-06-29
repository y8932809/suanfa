package com.ykf.suanfa.wechar;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
/**
 * 描述:
 * 微信小程序userinfo解密
 *
 * @author yukaifei
 * @create 2019-03-27 15:43
 */
public class WXUtils {
    public static JSONObject getUserInfo(String encryptedData, String sessionKey, String iv){
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);

        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String ency="OpKR/WlNhxI6MOL7WPJJ72y+9Gl614t6UZZZg7QVqj4pnibZm4o1nfpuRU4+KHakNWv6PhV0Fwg0dwXi7Hs2EfhI+YOgELo5zOcvrO+z/bSYcNUFw0ZRc2IEZsFwsEAoRpyQFIEHxswo7XBECR3yg2hVPqClnrSqjUEUaMcNfzHVHNGSmgdyY6F//x4N9x7aTggrNZJ1MNZWZ092xcXaRT0xbaNPThtpx6gwwAGAcjZDnD4cjd0U4ISGwyGo/pIy3++syH0qPbx7209MWofrjPpKBnyxfkiXpBVKmaWcp+g8Sx4reWFNLQ6KckFzLQzv8+yKDLrDwxxBLKNkLq5p8WUDPQMg8fyYPMPcJHKNsqjaxIstPxHU+L5AiH4DtysOk6jeLc1z80Tr+ZyLilbWLIFnbVYgGYSwXDHw1rVypkt5Q4wkKF4944vZIqTU9crBrdwnSbYvUsILnwTFZ/+TwbIpI1VGc9OGv+eENT8n5lo=";
        String iv ="dF2N94nTv6WxY/3oNU5XRw==";
        String key ="hS8FkRzIbrl0usEiJgc0QQ==";
        JSONObject result = getUserInfo(ency,key,iv);
        System.out.println(JSON.toJSONString(result));


    }
}