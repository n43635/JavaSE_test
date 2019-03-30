package com.sx.SE.security.sha;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 消息摘要算法----SHA
 * SHA算法的实现和MD算法的实现大同小异，也是JDK提供了默认的几种实现，
 * apache的Commons Codec在JDK的基础上进行了优化，使其更好用，
 * 而Bouncy Castle是JDK的拓展，提供了JDK和Commons Codec没有的SHA-224的实现。
 * @CLassName{JavaSHA}
 * @Auther{SHIXIAN-PC}
 * @Date{} {}
 * @Version 1.0
 */
public class JavaSHA {
    private static String src = "object-oriente";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("原始字符串" + src);
        
        jdkSHA1();
        bouncyCastleSHA1();
        commonsCodecSHA1();
        System.out.println();
        
        bouncyCastleSHA244();
        System.out.println();
        jdkSHA256();
        
        bouncyCastleSHA256();
    }

    /**
     * JDK实现sha-1
     * @Author Shixian
     * @Description
     * @Date 0:07 2019/3/31
     * @Param []
     * @return void
     **/
    private static void jdkSHA1() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("sha");//这里sha-1算法传入的参数是sha
        byte[] sha1Bytes = md.digest(src.getBytes());
        System.out.println("JDK SHA-1:\t" + org.apache.commons.codec.binary.Hex.encodeHexString(sha1Bytes));
    }

    /**
     * JDK实现sha-256
     * @Author Shixian
     * @Description
     * @Date 0:07 2019/3/31
     * @Param []
     * @return void
     **/
    private static void jdkSHA256() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("sha-256");
        md.update(src.getBytes());
        System.out.println("JDK SHA-256:\t" + org.apache.commons.codec.binary.Hex.encodeHexString(md.digest()));
    }

    /**
     * Bouncy Castle实现sha-1
     * @Author Shixian
     * @Description
     * @Date 0:08 2019/3/31
     * @Param []
     * @return void
     **/
    private static void bouncyCastleSHA1() {
        Digest digest = new SHA1Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha1bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha1bytes, 0);
        System.out.println("bc SHA-1:\t" + org.apache.commons.codec.binary.Hex.encodeHexString(sha1bytes));
    }

    /**
     * Bouncy Castle实现sha-244
     * @Author Shixian
     * @Description
     * @Date 0:08 2019/3/31
     * @Param []
     * @return void
     **/
    private static void bouncyCastleSHA244() {
        Digest digest = new SHA224Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha224bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha224bytes, 0);
        System.out.println("bc SHA-244:\t" + org.apache.commons.codec.binary.Hex.encodeHexString(sha224bytes));
    }

    /**
     * Bouncy Castle实现sha-256
     * @Author Shixian
     * @Description
     * @Date 0:09 2019/3/31
     * @Param []
     * @return void
     **/
    private static void bouncyCastleSHA256() {
        Digest digest = new SHA256Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha256bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha256bytes, 0);
        System.out.println("bc SHA-256:\t" + org.apache.commons.codec.binary.Hex.encodeHexString(sha256bytes));
    }

    /**
     * Commons Codec实现sha-1
     * @Author Shixian
     * @Description
     * @Date 0:10 2019/3/31
     * @Param []
     * @return void
     **/
    private static void commonsCodecSHA1() {
        System.out.println("cc SHA-1:\t" + DigestUtils.sha1Hex(src.getBytes()));
        //采用下面的方式更加方便
        System.out.println("cc SHA-1:\t" + DigestUtils.sha1Hex(src));
    }

}
