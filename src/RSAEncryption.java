import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class RSAEncryption {
    String publicKeyString, privateKeyString;
    static PublicKey publicKey;
    static PrivateKey privateKey;

    RSAEncryption() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator =
                KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom();
        keyPairGenerator.initialize(2048, secureRandom);
        KeyPair pair = keyPairGenerator.generateKeyPair();
        publicKey = pair.getPublic();
        publicKeyString =
                Base64.getEncoder().encodeToString(publicKey.getEncoded());
//        System.out.println("public key = " + publicKeyString);
        privateKey = pair.getPrivate();
        privateKeyString =
                Base64.getEncoder().encodeToString(privateKey.getEncoded());
//        System.out.println("private key = " + privateKeyString);
    }

    public String encrypt(String message) throws Exception {
        //Encrypt message
        Cipher encryptionCipher = Cipher.getInstance("RSA");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedMessage =
                encryptionCipher.doFinal(message.getBytes());
        //        System.out.println("encrypted message = " + encryption);
        return Base64.getEncoder().encodeToString(encryptedMessage);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        //Decrypt message
        Cipher decryptionCipher = Cipher.getInstance("RSA");
        decryptionCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedMessage =
                decryptionCipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        //        System.out.println("decrypted message = " + decryption);
        return new String(decryptedMessage);
    }
}