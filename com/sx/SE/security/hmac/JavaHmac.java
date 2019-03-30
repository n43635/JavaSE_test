package com.sx.SE.security.hmac;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 消息摘要算法----MAC
 * @CLassName{JavaHmac}
 * @Auther{SHIXIAN-PC}
 * @Date{} {}
 * @Version 1.0
 */
public class JavaHmac {
    private static String src = "object-oriente";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException {
        System.out.println("原始字符串:" + src + "\n");
        jdkHmacMD5();
        bouncyCatleHmacMD5();
    }

    private static void jdkHmacMD5() throws NoSuchAlgorithmException, DecoderException, InvalidKeyException {

        //得到秘钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = keyGenerator.generateKey();//生成秘钥
        byte[] key = secretKey.getEncoded();//获取秘钥
        Hex.decodeHex("aabbccddee".toCharArray());

        //还原秘钥
        SecretKey restoreSecretKey = new SecretKeySpec(key, "hmacMD5");

        //信息摘要
        Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());//实例化mac
        mac.init(restoreSecretKey);//初始化mac
        byte[] hmacMD5bytes = mac.doFinal(src.getBytes());//执行摘要

        System.out.println("jdkHmacMD5:\t" + Hex.encodeHexString(hmacMD5bytes));
    }

    private static void bouncyCatleHmacMD5() {
        HMac hmac = new HMac(new MD5Digest());
        //生成秘钥的时候以aabbccddee为基准
        hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aabbccddee")));
        hmac.update(src.getBytes(), 0, src.getBytes().length);

        //执行摘要
        byte[] hmacMDbytes = new byte[hmac.getMacSize()];
        hmac.doFinal(hmacMDbytes, 0);

        System.out.println("bcHmacMD5:\t" + org.bouncycastle.util.encoders.Hex.toHexString(hmacMDbytes));
    }
}
