import javax.swing.*;

public class FrmMain extends JDialog {
    private JButton btnAESGCM;
    private JButton btnRSA;
    private JButton btnExit;
    private JPanel mainPanel;

    FrmMain(){
        setTitle("Encryption");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        btnExit.addActionListener(e -> {
            System.exit(0);
            setVisible(false);
        });
        btnAESGCM.addActionListener(e -> {
            new FrmAESGCM().setVisible(true);
            setVisible(false);
        });
        btnRSA.addActionListener(e -> {
            new FrmRSA().setVisible(true);
            setVisible(false);
        });
    }


    public static void main(String[] args) {
        new FrmMain().setVisible(true);
    }



}
