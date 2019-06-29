
package com.ykf.suanfa.sign;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;


public class RSA {
    public static final String KEY_SHA = "SHA";
    public static final String KEY_SHA_1 = "SHA-1";
    public static final String KEY_MD5 = "MD5";

    /** */
    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /** */
    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * ras
     */
    public static final String KEY_ALGORTHM = "RSA";//
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    public static final String PUBLIC_KEY = "RSAPublicKey";// 公钥
    public static final String PRIVATE_KEY = "RSAPrivateKey";// 私钥

    /**
     * 初始化密钥
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORTHM);
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

    /**
     * 取得公钥，并转化为String类型
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * 取得私钥，并转化为String类型
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * 私钥解密
     * @param encryptedData
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String encryptedData, String privateKey) throws Exception {
        byte[] bytes = decryptByPrivateKey(decryptBase64(encryptedData), privateKey);
        String content = new String(bytes, "utf-8");
        return content;
    }


    /** */
    /**
     * <P>
     * 私钥解密
     * </p>
     *
     * @param encryptedData 已加密数据
     * @param privateKey    私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws Exception {
        byte[] keyBytes = decryptBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /** */
    /**
     * <p>
     * 公钥解密
     * </p>
     *
     * @param encryptedData 已加密数据
     * @param publicKey     公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
        byte[] keyBytes = decryptBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /**
     * 公钥加密
     *
     * @param content
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String content, String publicKey) throws Exception {
        byte[] data = content.getBytes("utf-8");
        byte[] bytes = encryptByPublicKey(data, publicKey);
        String encrypt = encryptBase64(bytes);
        return encrypt;
    }

    /** */
    /**
     * <p>
     * 公钥加密
     * </p>
     *
     * @param data      源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
        byte[] keyBytes = decryptBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /** */
    /**
     * <p>
     * 私钥加密
     * </p>
     *
     * @param data       源数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws Exception {
        byte[] keyBytes = decryptBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    public static String encryptBase64(byte[] b) throws UnsupportedEncodingException {
        return new String(java.util.Base64.getEncoder().encode(b));
    }

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBase64(String key) throws Exception {
        return java.util.Base64.getDecoder().decode(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return new String(java.util.Base64.getEncoder().encode(key));
    }

    /**
     * MD5加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
        return md5.digest();
    }

    /**
     * SHA加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptSHA(String decript) throws Exception {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance(KEY_SHA_1);
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data       //加密数据
     * @param privateKey //私钥
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // 解密私钥
        byte[] keyBytes = decryptBase64(privateKey);
        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        // 指定加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        // 取私钥匙对象
        PrivateKey privateKey2 = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateKey2);
        signature.update(data);

        return encryptBASE64(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param data      加密数据
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
        // 解密公钥
        byte[] keyBytes = decryptBase64(publicKey);
        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        // 指定加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        // 取公钥匙对象
        PublicKey publicKey2 = keyFactory.generatePublic(x509EncodedKeySpec);

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicKey2);
        signature.update(data);
        // 验证签名是否正常
        return signature.verify(decryptBase64(sign));

    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * test ras 加密解密
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        String str = "mobile=15010075648&time=123456789";

        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALccczZXc4jp49+0eudjx+YR8VPXO/Xn4kkOeq88ikaRFEkGvDxppJ5sAN4k52ydfmE7XnHvV9kc83dX0C0ZGC4ApvEWOo0U4hChtAAYCz8SCbiHGdDsd+N6HWqzh936lL2nnU6khL9OwWlaLdXz1r6WHUJeHsExgZU+SJVfdQ4jAgMBAAECgYAs0k/5W0qylt3qolj7Ttddn8K8zRCmTs57J4osXttSDq0yeu2UtB9RkApeVhY35g1La6bgqL+OK6IE8n/Iqj3airE7y8zqUMG00VtSjGz86vb0zU1DTqshgQuHGjCvWrmeEy9IENo4Dd9ZvNkOry0Xrmyag9GJIz7aJWE/Y+mrsQJBAOTyQ7S+r+oh9WTgWPNzzd5W8gXKSuLbaCgEx2ldzsa/Spt4JtpDSykQSf0BBVsPwo5ulodbJewpkG4wZjaD1XUCQQDMv6YOM/ycFaYOYu0jpDgaxhakg2CyWGbT4g8LGerDeSKKvDHnxg0WmuIU52+6MnbydBcJ7MuMMq/An/GLCSo3AkBhET4Xgcl/0QoDzQKppW2hWOegANajPDb60JvjVnx201/Ebrq6S1GwhVF5TVeB9jqcvNJhbQm1CSJNNYQAlQCJAkA0+so/Fpig0sE7K8Hs3Qtfci5dt1kIDPPek7oMx1IF7oxPlc7cCFVOqhkiC5jPd0tsBToI6WrqBhuQHlLkBSUVAkEAwgEE+xx8psY/upcfhQm+hTeRcK9YL1dBAlNSsW1h/xx0F8lfendTwVGwgaxL99qw7cl58TuNKUAxcQmtqQ+XiA==";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC3HHM2V3OI6ePftHrnY8fmEfFT1zv15+JJDnqvPIpGkRRJBrw8aaSebADeJOdsnX5hO15x71fZHPN3V9AtGRguAKbxFjqNFOIQobQAGAs/Egm4hxnQ7Hfjeh1qs4fd+pS9p51OpIS/TsFpWi3V89a+lh1CXh7BMYGVPkiVX3UOIwIDAQAB";

        System.out.println("===privateKey :" + privateKey + "   ==publicKey :  " + publicKey);



        // 公钥加密
        String sign = encryptByPublicKey(str,publicKey);

        System.out.println("加密结果 ： " + sign);

        // 私钥解密
        String qq = new String(decryptByPrivateKey(decryptBase64(sign), privateKey), "utf-8");

        System.out.println(qq);
    }

}
