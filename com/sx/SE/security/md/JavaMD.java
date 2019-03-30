package com.sx.SE.security.md;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 *
 * @CLassName{JavaMD}
 * @Auther{SHIXIAN-PC}
 * @Date{} {}
 * @Version 1.0
 */
public class JavaMD {
    //需要加密的字段
    private static String src = "object-oriented";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("原始字符串:" + src + "\n");

        jdkMD5();
        bouncyCastleMD5();
        commonsCodecMD5();
        System.out.println();

        jdkMD2();
        bouncyCastleMD2();
        commonsCodecMD2();
        System.out.println();

        bouncyCastleMD4();

    }

    /**
     * JDK实现的MD5加密
     * @Author Shixian
     * @Description
     * @Date 21:48 2019/3/30
     * @Param []
     * @return void
     **/
    private static void jdkMD5() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5digest = md.digest(src.getBytes());
        System.out.println("JDK MD5:"+ Hex.encodeHexString(md5digest));
    }

    /**
     * JDK实现的MD2加密
     * @Author Shixian
     * @Description
     * @Date 21:49 2019/3/30
     * @Param []
     * @return void
     **/
    private static void jdkMD2() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD2");
        byte[] md2digest = md.digest(src.getBytes());
        System.out.println("JDK MD2:" + Hex.encodeHexString(md2digest));
    }

    /**
     * Bouncy Castle实现的MD4加密
     * @Author Shixian
     * @Description
     * @Date 21:49 2019/3/30
     * @Param []
     * @return void
     **/
    private static void bouncyCastleMD4() throws NoSuchAlgorithmException {
        //通过这种方式给JDK动态添加一个provide,就可以通过这种方式获得 JDK本身不支持的MD4了
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest md = MessageDigest.getInstance("md4");
        byte[] md4digest = md.digest(src.getBytes());
        System.out.println("bc MD4:\t" + org.bouncycastle.util.encoders.Hex.toHexString(md4digest));
    }

    /**
     * Bouncy Castle实现的MD5加密
     * @Author Shixian
     * @Description
     * @Date 21:55 2019/3/30
     * @Param []
     * @return void
     **/
    private static void bouncyCastleMD5() {
        Digest digest = new MD5Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] md5bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md5bytes, 0);
        System.out.println("bc MD5:\t" + org.bouncycastle.util.encoders.Hex.toHexString(md5bytes));
    }

    /**
     * Bouncy Castle实现的MD2加密
     * @Author Shixian
     * @Description
     * @Date 21:55 2019/3/30
     * @Param []
     * @return void
     **/
    private static void bouncyCastleMD2() {
        Digest digest = new MD2Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] md2bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md2bytes, 0);
        System.out.println("bc MD2:\t" + org.bouncycastle.util.encoders.Hex.toHexString(md2bytes));
    }

    /**
     * Commons Codec实现的MD5加密
     * @Author Shixian
     * @Description
     * @Date 21:56 2019/3/30
     * @Param []
     * @return void
     **/
    private static void commonsCodecMD5() {
        System.out.println("cc MD5:\t" + DigestUtils.md5Hex(src.getBytes()));
    }

    /**
     * Commons Codec实现的MD2加密
     * @Author Shixian
     * @Description
     * @Date 21:56 2019/3/30
     * @Param []
     * @return void
     **/
    private static void commonsCodecMD2() {
        System.out.println("cc MD2\t" + DigestUtils.md2Hex(src.getBytes()));
    }
}
