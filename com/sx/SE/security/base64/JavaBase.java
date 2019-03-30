package com.sx.SE.security.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;

/**
 * base64算法是基于64个字符的一种替换算法。
 * base64加密的产生式电子邮件的“历史问题”——邮件只能传输ASCII码。
 * base64加密的应用场景：email、密钥、证书文件。
 * 该算法可以由3种方式实现：JDK、Bouncy Castle、Commons Codec。
 * @CLassName{JavaBase}
 * @Auther{SHIXIAN-PC}
 * @Date{} {}
 * @Version 1.0
 */
public class JavaBase {
    //需要加密的原始字符串
    private static String src = "面向对象编程, object-oriented! @#*5";

    public static void main(String[] args) throws IOException {
        System.out.println("原始字符串:\t\t\t" + src);
        System.out.println();
        jdkBase64();
        System.out.println();
        commonsCodecBase64();
        System.out.println();
        bouncyCastleBase64();
    }

    /**
     * JDK实现编码
     * @Author Shixian
     * @Description
     * @Date 17:34 2019/3/30
     * @Param []
     * @return void
     **/
    private static void jdkBase64() throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(src.getBytes());//编码

        BASE64Decoder decoder = new BASE64Decoder();
        String decode = new String(decoder.decodeBuffer(encode));//解码

        System.out.println("JDK实现的base64编码:\t\t" + encode);
        System.out.println("JDK实现的base64解码:\t\t" + decode);
    }

    /**
     * Commons Codec实现base64编码
     * @Author Shixian
     * @Description
     * @Date 17:34 2019/3/30
     * @Param []
     * @return void
     **/
    private static void commonsCodecBase64() {
        byte[] encode = Base64.encodeBase64(src.getBytes());
        byte[] decode = Base64.decodeBase64(encode);

        System.out.println("Commons Codec实现base64编码:\t" + new String(encode));
        System.out.println("Commons Codec实现base64解码:\t" + new String(decode));

    }

    /**
     * Bouncy Castle实现base64编码
     * @Author Shixian
     * @Description
     * @Date 17:37 2019/3/30
     * @Param []
     * @return void
     **/
    private static void bouncyCastleBase64() {
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);

        System.out.println("Bouncy Castle实现base64编码:\t" + new String(encode));
        System.out.println("Bouncy Castle实现base64解码:\t" + new String(decode));
    }
}
