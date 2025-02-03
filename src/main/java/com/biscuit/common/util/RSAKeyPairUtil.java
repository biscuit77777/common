package com.biscuit.common.util;

import com.biscuit.common.dtos.RSAPairDTO;
import sun.security.util.AuthResources_de;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 非对称加密工具类
 *
 * @author biscuit
 */
public abstract class RSAKeyPairUtil {

    public static RSAPairDTO generator() {
        return generator(2048);
    }

    /**
     * 生成指定长度的 RSA 非对称公私钥
     *
     * @param keySize 长度
     */
    public static RSAPairDTO generator(int keySize) {
        try {
            // 初始化 KeyPairGenerator，指定算法为 RSA
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

            // 设置密钥长度
            keyPairGenerator.initialize(keySize);

            // 生成密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // 获取私钥和公钥
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            // 创建 dto 返回对象
            RSAPairDTO dto = new RSAPairDTO();
            dto.setPublicKey(Base64.getEncoder().encodeToString(publicKey.getEncoded()));
            dto.setPrivateKey(Base64.getEncoder().encodeToString(privateKey.getEncoded()));

            // 返回公私钥dto对象
            return dto;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据公钥加密
     *
     * @param publicKey 公钥
     * @param plainText 需要加密的内容
     */
    public static String encrypt(String publicKey, String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException |
                 InvalidKeyException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据私钥解密
     *
     * @param privateKey    私钥
     * @param encryptedText 加密内容
     */
    public static String decrypt(String privateKey, String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(privateKey));
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedBytes);
        } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException |
                 InvalidKeyException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    private static PublicKey getPublicKey(String publicKey) {
        try {
            // 解码Base64字符串
            byte[] decoded = Base64.getDecoder().decode(publicKey);

            // 创建X509EncodedKeySpec对象
            X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);

            // 获取KeyFactory实例
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            // 生成PublicKey对象
            return keyFactory.generatePublic(spec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private static PrivateKey getPrivateKey(String privateKey) {
        try {
            // 解码Base64字符串
            byte[] decoded = Base64.getDecoder().decode(privateKey);

            // 创建X509EncodedKeySpec对象
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);

            // 获取KeyFactory实例
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            // 生成PrivateKey对象
            return keyFactory.generatePrivate(spec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        RSAPairDTO dto = generator();
        System.out.println("公钥 => " + dto.getPublicKey());
        System.out.println("私钥 => " + dto.getPrivateKey());

        System.out.println("\n");

        String text = "Hello Biscuit, Please refuel!";
        String body = encrypt(dto.getPublicKey(), text);

        System.out.println("未加密内容 =>" + text);
        System.out.println("使用公钥加密后的内容 => " + body);
        System.out.println("使用私钥解密后的内容 => " + decrypt(dto.getPrivateKey(), body));
    }

}
