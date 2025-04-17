package com.sy.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AESEncryption {

    // 用于生成盐值的方法
    public static byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    // 从密码和盐值生成密钥的方法
    public static SecretKey getSecretKey(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKey secretKey = new SecretKeySpec(keyFactory.generateSecret(keySpec).getEncoded(), "AES");
        return secretKey;
    }

    // 加密方法
    public static String encrypt(String data, SecretKey secretKey, byte[] salt) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(generateSalt()); // 可以使用固定的IV，但为了安全这里仍然生成一个新的IV
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        byte[] encryptedData = cipher.doFinal(data.getBytes("UTF-8"));

        // 将盐值、IV和加密后的数据一起返回（实际使用中可能需要更安全的存储方式）
        return Base64.getEncoder().encodeToString(salt) + ":" +
                Base64.getEncoder().encodeToString(iv.getIV()) + ":" +
                Base64.getEncoder().encodeToString(encryptedData);
    }

    // 解密方法
    public static String decrypt(String encryptedData, String password) throws Exception {
        String[] parts = encryptedData.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] iv = Base64.getDecoder().decode(parts[1]);
        byte[] encrypted = Base64.getDecoder().decode(parts[2]);

        SecretKey secretKey = getSecretKey(password, salt);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        byte[] decryptedData = cipher.doFinal(encrypted);
        return new String(decryptedData, "UTF-8");
    }

    public static void main(String[] args) {
        try {
            String password = "mySecretPassword";
            String data = "Hello, World!";
            //这个值生成之后告诉第三方，或者写死一个
            //byte[] salt = "123456".getBytes();
            byte[] salt = generateSalt();
            SecretKey secretKey = getSecretKey(password, salt);

            //正常加solt的加解密
            String encryptedData = encrypt(data, secretKey, salt);
            System.out.println("Encrypted Data: " + encryptedData);

            String decryptedData = decrypt(encryptedData, password);
            System.out.println("Decrypted Data: " + decryptedData);


            //二次用URL 加解密，，避免网络传输存在转义错误的问题
            String urlEncodeData = URLEncoder.encode(encryptedData, StandardCharsets.UTF_8.toString());
            String urlDecodeData = URLDecoder.decode(urlEncodeData, StandardCharsets.UTF_8.toString());
            System.out.println("url 中间二次加密一次，避免网络传输存在转义错误的问题：Decrypted Data:   " + decrypt(urlDecodeData, password));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
