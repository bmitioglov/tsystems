import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */

public class MainForm{
    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        MainPanel panel = new MainPanel(frame);
//        UserMainPanel panel = new UserMainPanel();
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false);

    }
}

class MainPanel extends javax.swing.JPanel {

    JLabel jLabel1;
    JButton jButton1;
    JButton jButton2;
    JFrame mainFrame;

    public MainPanel(JFrame frame){
        initComponents();
        mainFrame = frame;

    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        LoginDialog loginDialog = new LoginDialog(mainFrame, true);
        loginDialog.setLocationRelativeTo(mainFrame);
        loginDialog.setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        RegistrationDialog regDialog = new RegistrationDialog(mainFrame, true);
        regDialog.setLocationRelativeTo(mainFrame);
        regDialog.setVisible(true);
    }



    @SuppressWarnings("unchecked")
    private void initComponents() {


        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\goodspeed\\Desktop\\Logo_T-Systems_01.jpg")); // NOI18N

        jButton1.setText("Вход");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });


        jButton2.setText("Регистрация");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(308, 308, 308)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(291, 291, 291)
                                                .addComponent(jButton2)))
                                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(92, 92, 92))
        );
    }

}
