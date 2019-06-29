package com.ykf.suanfa.sign;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AES {
    /**
     * 加密
     * @param encodeRules
     * @param content
     * @return
     */
    public static String AESEncode(String encodeRules,String content){
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            keygen.init(128, random);
            SecretKey original_key=keygen.generateKey();
            byte [] raw=original_key.getEncoded();
            SecretKey key=new SecretKeySpec(raw, "AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte [] byte_encode=content.getBytes("utf-8");
            byte [] byte_AES=cipher.doFinal(byte_encode);
            String AES_encode=new String(new BASE64Encoder().encode(byte_AES));
            return AES_encode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param encodeRules
     * @param content
     * @return
     */
    public static String AESDecode(String encodeRules,String content){
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            keygen.init(128, random);
            SecretKey original_key=keygen.generateKey();
            byte [] raw=original_key.getEncoded();
            SecretKey key=new SecretKeySpec(raw, "AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte [] byte_content= new BASE64Decoder().decodeBuffer(content);
            byte [] byte_decode=cipher.doFinal(byte_content);
            String AES_decode=new String(byte_decode,"utf-8");
            return AES_decode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
