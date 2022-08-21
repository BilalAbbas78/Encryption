import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESGCM {
    private static SecretKey key;
    private static Cipher encryptionCipher;

    public void init() {
//        byte[] decodedKey = Base64.getDecoder().decode("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    public static String encrypt(String message) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        byte[] messageInBytes = message.getBytes();
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
        return encode(encryptedBytes);
    }

    public static String decrypt(String encryptedMessage) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        byte[] messageInBytes = decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        int t_LEN = 128;
        GCMParameterSpec spec = new GCMParameterSpec(t_LEN, encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
        return new String(decryptedBytes);
    }

    private static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private static byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public static void main(String[] args) {
        try {
            AESGCM AESGCM = new AESGCM();
            AESGCM.init();
            String encryptedMessage = AESGCM.encrypt("ABC");
            String decryptedMessage = AESGCM.decrypt(encryptedMessage);

            System.out.println("Encrypted Message : " + encryptedMessage);
            System.out.println("Decrypted Message : " + decryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}