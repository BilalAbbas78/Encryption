import javax.swing.*;

public class FrmAESGCM extends JDialog {
    FrmAESGCM(){
        setTitle("AES GCM");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setResizable(false);
        setLayout(null);

        JLabel lblHeading = new JLabel("AES GCM Encryption and Decryption");
        lblHeading.setBounds(80, 5, 250, 30);
        add(lblHeading);

        JLabel lblEncrypt = new JLabel("Enter text to Encrypt");
        lblEncrypt.setBounds(20, 30, 200, 30);
        add(lblEncrypt);

        JTextArea txtEncrypt = new JTextArea();
        txtEncrypt.setLineWrap(true);
        txtEncrypt.setBounds(20, 60, 150, 100);
        add(txtEncrypt);

        JButton btnEncrypt = new JButton("Encrypt");
        btnEncrypt.setBounds(20, 170, 150, 30);
        add(btnEncrypt);

        JLabel lblEncrypted = new JLabel("Encrypted Text:");
        lblEncrypted.setBounds(20, 210, 150, 30);
        add(lblEncrypted);

        JTextArea txtEncrypted = new JTextArea();
        txtEncrypted.setLineWrap(true);
        txtEncrypted.setBounds(20, 240, 150, 100);
        add(txtEncrypted);




        JLabel lblDecrypt = new JLabel("Enter text to Decrypt");
        lblDecrypt.setBounds(200, 30, 200, 30);
        add(lblDecrypt);

        JTextArea txtDecrypt = new JTextArea();
        txtDecrypt.setLineWrap(true);
        txtDecrypt.setBounds(200, 60, 150, 100);
        add(txtDecrypt);

        JButton btnDecrypt = new JButton("Decrypt");
        btnDecrypt.setBounds(200, 170, 150, 30);
        add(btnDecrypt);

        JLabel lblDecrypted = new JLabel("Decrypted Text:");
        lblDecrypted.setBounds(200, 210, 150, 30);
        add(lblDecrypted);

        JTextArea txtDecrypted = new JTextArea();
        txtDecrypted.setLineWrap(true);
        txtDecrypted.setBounds(200, 240, 150, 100);
        add(txtDecrypted);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(130, 360, 100, 30);
        add(btnBack);

        btnEncrypt.addActionListener(e -> {
            String text = txtEncrypt.getText();
            if (text.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter text to encrypt", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String encrypted = null;
            try {
                encrypted = AESGCM.encrypt(text);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            txtEncrypted.setText(encrypted);
        });

        btnDecrypt.addActionListener(e -> {
            String text = txtDecrypt.getText();
            if (text.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter text to decrypt", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String decrypted = null;
            try {
                decrypted = AESGCM.decrypt(text);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            txtDecrypted.setText(decrypted);
        });

        btnBack.addActionListener(e -> {
            new FrmMain().setVisible(true);
            dispose();
        });

    }

    public static void main(String[] args) {
        new FrmAESGCM().setVisible(true);
    }
}
