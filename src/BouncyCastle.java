////import org.bouncycastle;
//
//import org.bouncycastle.crypto.modes.GCMBlockCipher;
//import org.bouncycastle.crypto.params.AEADParameters;
//import static org.bouncycastle.pqc.crypto.newhope.ChaCha20.process;
////import static org.bouncycastle;
//import static org.bouncycastle.pqc.math.linearalgebra.ByteUtils.concatenate;
//
//public class BouncyCastle {
//    @Override
//    public byte[] encrypt(byte[] bytes) {
//        byte[] iv = this.ivGenerator.generateKey();
//        @SuppressWarnings("deprecation")
//        GCMBlockCipher blockCipher = new GCMBlockCipher(new org.bouncycastle.crypto.engines.AESFastEngine());
//        blockCipher.init(true, new AEADParameters(secretKey, 128, iv, null));
//        byte[] encrypted = process(blockCipher, bytes);
//        return iv != null ? concatenate(iv, encrypted) : encrypted;
//    }
//
//}
