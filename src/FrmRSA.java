import javax.swing.*;
import java.security.NoSuchAlgorithmException;

public class FrmRSA extends JDialog {
    FrmRSA() throws NoSuchAlgorithmException {
        setTitle("RSA");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        JLabel lblHeading = new JLabel("RSA Encryption and Decryption");
        lblHeading.setBounds(80, 5, 250, 30);
        add(lblHeading);

        JLabel lblEncrypt = new JLabel("Enter text to Encrypt");
        lblEncrypt.setBounds(20, 30, 200, 30);
        add(lblEncrypt);

        JTextArea txtEncrypt = new JTextArea();
        txtEncrypt.setLineWrap(true);
        JScrollPane spTxtEncrypt = new JScrollPane(txtEncrypt);
        spTxtEncrypt.setBounds(20, 60, 150, 100);
        add(spTxtEncrypt);

        JButton btnEncrypt = new JButton("Encrypt");
        btnEncrypt.setBounds(20, 170, 150, 30);
        add(btnEncrypt);

        JLabel lblEncrypted = new JLabel("Encrypted Text:");
        lblEncrypted.setBounds(20, 210, 150, 30);
        add(lblEncrypted);

        JTextArea txtEncrypted = new JTextArea();
        txtEncrypted.setLineWrap(true);
        JScrollPane spTxtEncrypted = new JScrollPane(txtEncrypted);
        spTxtEncrypted.setBounds(20, 240, 150, 150);
        add(spTxtEncrypted);


        JLabel lblDecrypt = new JLabel("Enter text to Decrypt");
        lblDecrypt.setBounds(200, 30, 200, 30);
        add(lblDecrypt);

        JTextArea txtDecrypt = new JTextArea();
        txtDecrypt.setLineWrap(true);
        JScrollPane spTxtDecrypt = new JScrollPane(txtDecrypt);
        spTxtDecrypt.setBounds(200, 60, 150, 100);
        add(spTxtDecrypt);

        JButton btnDecrypt = new JButton("Decrypt");
        btnDecrypt.setBounds(200, 170, 150, 30);
        add(btnDecrypt);

        JLabel lblDecrypted = new JLabel("Decrypted Text:");
        lblDecrypted.setBounds(200, 210, 150, 30);
        add(lblDecrypted);

        JTextArea txtDecrypted = new JTextArea();
        txtDecrypted.setLineWrap(true);
        JScrollPane spTxtDecrypted = new JScrollPane(txtDecrypted);
        spTxtDecrypted.setBounds(200, 240, 150, 150);
        add(spTxtDecrypted);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(130, 410, 100, 30);
        add(btnBack);

        RSAEncryption rsa = new RSAEncryption();

        btnEncrypt.addActionListener(e -> {
            String text = txtEncrypt.getText();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter text to encrypt");
            } else {
                String encrypted;
                try {
                    encrypted = rsa.encrypt(text);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    throw new RuntimeException(ex);
                }
                txtEncrypted.setText(encrypted);
            }
        });

        btnDecrypt.addActionListener(e -> {
            String text = txtDecrypt.getText();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter text to decrypt");
            } else {
                String decrypted;
                try {
                    decrypted = rsa.decrypt(text);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    throw new RuntimeException(ex);
                }
                txtDecrypted.setText(decrypted);
            }
        });

        btnBack.addActionListener(e -> {
            new FrmMain().setVisible(true);
            dispose();
        });
    }
    }
