package com.niuka.common.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.niuka.common.config.ConfigUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 * <p>
 *     前端参数加解密工具类
 * </p>
 *
 * @author hewei
 *
 * @date 2017/6/6
 */
public   class DesCrypt {
//    private static String  KEY =  ConfigUtils.getProperty("api.desc.crypt.key");
    private static String  KEY = "abcdefgabcdefg12";
    private static String CODE_TYPE = "UTF-8";

    /**
     * DES解密
     * @return
     */
    public static String decode(String src) throws Exception {

        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();

        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(KEY.getBytes(CODE_TYPE));

        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");

        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);

        // 真正开始解密操作
        return IOUtils.toString(cipher.doFinal(Base64.decodeBase64(src)), "UTF-8");
    }

    /**
     * DES加密
     * @param datasource
     * @return
     */
    public static String encode(String datasource) {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec   desKey = new DESKeySpec(KEY.getBytes(CODE_TYPE));

            // 创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey        securekey  = keyFactory.generateSecret(desKey);

            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");

            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);

            // 现在，获取数据并加密
            byte[] temp = Base64.encodeBase64(cipher.doFinal(datasource.getBytes()));

            return IOUtils.toString(temp, "UTF-8");
        } catch (Throwable e) {
            e.printStackTrace();

            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(DesCrypt.decode("dk0hcSFb3BY="));
    }

    public String getKEY() {
        return KEY;
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }
}