package com.sy.utils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.tools.json.JSONUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
public class AESUtil {

    private static String CIPHER_NAME = "AES/CBC/PKCS5PADDING";

    public static String decrypt(String key, String iv, String data) {

        try {
            String[] parts = data.split(":");

            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance(CIPHER_NAME);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

            byte[] decodedEncryptedData = Base64.getDecoder().decode(parts[0]);

            byte[] original = cipher.doFinal(decodedEncryptedData);

            return new String(original);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String transString(String message, String secret) {
        String key = secret.substring(0, 16);
        String iv = secret.substring(16);
        String decrypt = decrypt(key, iv, message);
        JSONObject jsonObject = JSONObject.parseObject(decrypt);
//        Account account = (Account) JSON.parse(decrypt);
//        String userName = unicodeToCn(account.getAccount());
//        System.out.println(userName);
        return jsonObject.getString("account");

    }

    //Unicode转中文方法
    private static String unicodeToCn(String unicode) {
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = unicode.split("\\\\u");
        String returnStr = "";
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    }

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param password  加密密码
     * @return
     */
    public static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**解密
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        /*String secret = "3BStYafrhv7cBJ4Kz12PmEui63DO254S";
        String key = secret.substring(0,16);
        String iv = secret.substring(16);
        System.out.println(iv.length());
      String encrypted =
     "FfcOaxq8xvQC3mfgb7J+ju7YgZz0xCU2c3KgkBmXP3wXwa8xJUcFSCnN++nNHxdabdHRQuQuPviSigHJDUr5LpDSwxRCvmnUoQFR+bjpRC1qu1ZLDQyf9u0ohbw/2INjtn8A+U5Y42NutO8eu4Gklyj6OmO0K4lrm3AzT0L7MvdEZ52vwAV7NvtfDCHNqBpwOOKr1NHJv7tjJSdFmk4UiXpFZpGLHzh1paS5hUuCHYNmP3uaoiF8OzqBjYCap5FT/kxXH9FUsj5L82WGmmG17D+6QQ/AUwJ/outyiEVsM3JGjWDQkZOcFIP6ZKMbxfDZk4Jv21hqAcM18ctPtDP3vMHxa9BV9Kr6JTa2y6b86jkWTgLwIYT3B2uGcn0ipxA725yg6s7pS1S2NuFFjpv9WNX6XdV5tA+9UkvZ4yHYZbCPOvoSJcZk6jL/4ysrrz1iFUCfHjSDsW+N5/9QUAXKAvHEqaQXSy5rHyXttae8YIo=";
//        String encrypted =  "wrT+Q35UvlP4FgV0FELInbixfWUxC0TfmE4h+mtvuOWDihbL1+06767iifX4bbIznc+cBBV34v9cgwiIlbJP3yxscL0WSiQDFkoTBP/BMylDbXurNm2NIRkKvie3bn3uTxujGNGtMox9Et1Qayvih3aLCS1y90azBI/F91T+OdMh5vRbrZXsX3BwCaoG8mPQIaK9d/VTZ2SIfGyy+efwKB8HrUz6JTW2ogVO6m88+b5ySrP7s3DXxXQiyD7Dzu97sxnLIWdlAdZSv/DhdAM6JfgKIruUTZndHmEiICJwJJpZlh7EfaQy+kAnV8E4A+tr130uRZT8dEkUHMJ+5Os1/AMFSytJ4OV7yZWYdOQn163pgvQO6KrI5AEA+kjlxiJrrx7rcXFlt9ISMIlgro1Ox+w0rSrzz1OL/028xMG1Wxk=:ejEyUG1FdWk2M0RPMjUzUw==:" + iv;

        String decrypt = decrypt(key, iv, encrypted);
        System.out.println(decrypt);
        //String decrypt1 = Base64Util.decode(decrypt);
        System.out.println(UniCodeUtil.unicodeToString(decrypt));*/
        //System.out.println(transString(URLDecoder.decode("N5pUM7uo4wOQFK8YpzPh%2FM4sokq1qBA5JlSogHf7DHj0GTobOSYwnvnhs0pkEHG%2B%2Bdd%2BJYGnxgYYrr6LNR7Z6w%3D%3D", "utf-8"), "3BStYafrhv7cBJ4Kz12PmEui63DO254S"));

    }
}

@Data
class Account {
    private String account;

    private Long timestamp;
}
