import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class FrmMain extends JDialog {

    FrmMain(){
        setTitle("Encryption");
        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        JButton btnAESGCM = new JButton("AES GCM");
        btnAESGCM.setBounds(20, 20, 150, 30);
        add(btnAESGCM);

        JButton btnRSA = new JButton("RSA");
        btnRSA.setBounds(20, 60, 150, 30);
        add(btnRSA);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(20, 100, 150, 30);
        add(btnExit);

        btnExit.addActionListener(e -> {
            System.exit(0);
            setVisible(false);
        });
        btnAESGCM.addActionListener(e -> {
            new FrmAESGCM().setVisible(true);
            setVisible(false);
        });
        btnRSA.addActionListener(e -> {
            try {
                new FrmRSA().setVisible(true);
            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                throw new RuntimeException(ex);
            }
            setVisible(false);
        });
    }


    public static void main(String[] args) {
        new FrmMain().setVisible(true);
    }



}
