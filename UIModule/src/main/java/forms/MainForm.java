package forms;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */

public class MainForm{
    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocation(200,60);
        try {
            Socket socket = new Socket("localhost", 9091);
            MainPanel panel = new MainPanel(frame, socket);
            frame.add(panel);
        } catch (IOException e) {
            System.out.println("Problem opening socket");
//            TODO: Добавить диалог ошибки
        }

//        forms.UserMainPanel panel = new forms.UserMainPanel();

        frame.setVisible(true);
        frame.setResizable(false);



    }
}

class MainPanel extends javax.swing.JPanel {

    JLabel jLabel1;
    JButton jButton1;
    JButton jButton2;
    JFrame mainFrame;
    Socket socket;

    public MainPanel(JFrame frame, Socket socket){
        initComponents();
        mainFrame = frame;
        this.socket = socket;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        LoginDialog loginDialog = new LoginDialog(mainFrame, socket, true);
        loginDialog.setLocationRelativeTo(mainFrame);
        loginDialog.setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        RegistrationDialog regDialog = new RegistrationDialog(mainFrame, socket, true);
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
