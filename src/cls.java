//import org.bouncycastle.asn1.x500.X500Name;
//
//import java.io.IOException;
//import java.io.PrintStream;
//import java.security.*;
//import java.security.cert.CertificateException;
//import java.util.Date;
//import java.PKCS10;
//
//class cls{
//    private static final String SIGNATURE_ALGORITHM = "SHA1WITHRSA";
//    private static final long VALIDITY_DAYS = 14L;
//
//
//    public static byte[] sign(PKCS10 csr, X509CertImpl signerCert, PrivateKey signerPrivKey) throws CertificateException, IOException, InvalidKeyException, SignatureException {
//
//        /*
//         * The code below is partly taken from the KeyTool class in OpenJDK7.
//         */
//
//        X509CertInfo signerCertInfo = (X509CertInfo) signerCert.get(X509CertImpl.NAME + "." + X509CertImpl.INFO);
//        X500Name issuer = (X500Name) signerCertInfo.get(X509CertInfo.SUBJECT + "." + CertificateSubjectName.DN_NAME);
//
//        /*
//         * Set the certificate's validity:
//         * From now and for VALIDITY_DAYS days
//         */
//        Date firstDate = new Date();
//        Date lastDate = new Date();
//        lastDate.setTime(firstDate.getTime() + VALIDITY_DAYS * 1000L * 24L * 60L * 60L);
//        CertificateValidity interval = new CertificateValidity(firstDate, lastDate);
//
//        /*
//         * Initialize the signature object
//         */
//        Signature signature;
//        try {
//            signature = Signature.getInstance(SIGNATURE_ALGORITHM);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//        signature.initSign(signerPrivKey);
//
//        /*
//         * Add the certificate information to a container object
//         */
//        X509CertInfo certInfo = new X509CertInfo();
//        certInfo.set(X509CertInfo.VALIDITY, interval);
//        certInfo.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(new Random().nextInt() & 0x7fffffff));
//        certInfo.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
//        try {
//            certInfo.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(AlgorithmId.get(SIGNATURE_ALGORITHM)));
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//        certInfo.set(X509CertInfo.ISSUER, new CertificateIssuerName(issuer));
//        certInfo.set(X509CertInfo.KEY, new CertificateX509Key(csr.getSubjectPublicKeyInfo()));
//        certInfo.set(X509CertInfo.SUBJECT, new CertificateSubjectName(csr.getSubjectName()));
//
//        /*
//         * Add x509v3 extensions to the container
//         */
//        CertificateExtensions extensions = new CertificateExtensions();
//
//        // Example extension.
//        // See KeyTool source for more.
//        boolean[] keyUsagePolicies = new boolean[9];
//        keyUsagePolicies[0] = true; // Digital Signature
//        keyUsagePolicies[2] = true; // Key encipherment
//        KeyUsageExtension kue = new KeyUsageExtension(keyUsagePolicies);
//        byte[] keyUsageValue = new DerValue(DerValue.tag_OctetString, kue.getExtensionValue()).toByteArray();
//        extensions.set(KeyUsageExtension.NAME, new Extension(
//                kue.getExtensionId(),
//                true, // Critical
//                keyUsageValue));
//
//
//        /*
//         * Create the certificate and sign it
//         */
//        X509CertImpl cert = new X509CertImpl(certInfo);
//        try {
//            cert.sign(signerPrivKey, SIGNATURE_ALGORITHM);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchProviderException e) {
//            throw new RuntimeException(e);
//        }
//
//        /*
//         * Return the signed certificate as PEM-encoded bytes
//         */
//        ByteOutputStream bos = new ByteOutputStream();
//        PrintStream out = new PrintStream(bos);
//        BASE64Encoder encoder = new BASE64Encoder();
//        out.println(X509Factory.BEGIN_CERT);
//        encoder.encodeBuffer(cert.getEncoded(), out);
//        out.println(X509Factory.END_CERT);
//        out.flush();
//        return bos.getBytes();
//    }
//}