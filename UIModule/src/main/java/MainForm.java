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
        frame.setSize(1000,700);
        MainPanel panel = new MainPanel();
        JButton button = new JButton("dfff");
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);

    }
}

class MainPanel extends javax.swing.JPanel {

    ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
    JButton nextButton = new javax.swing.JButton();
    JLabel mainLabel = new javax.swing.JLabel();
    JRadioButton radioButton1 = new javax.swing.JRadioButton();
    JRadioButton radioButton2 = new javax.swing.JRadioButton();

    public MainPanel(){
       initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {


        nextButton.setText("Далее");


        mainLabel.setText("Выберите способ введения матрицы");

        radioButton1.setText("Из файла");


        radioButton2.setText("С клавиатуры");

//        FlowLayout layout = new FlowLayout();
//        this.setLayout(layout);
//        layout.addLayoutComponent("button", nextButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(267, 267, 267)
                                                .addComponent(nextButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(182, 182, 182)
                                                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(251, 251, 251)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(radioButton2)
                                                        .addComponent(radioButton1))))
                                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mainLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                                .addComponent(radioButton1)
                                .addGap(51, 51, 51)
                                .addComponent(radioButton2)
                                .addGap(105, 105, 105)
                                .addComponent(nextButton)
                                .addGap(123, 123, 123))
        );
    }

}
