package com.tsystems;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */
public class MainClass {
        public static void main(String[] args){
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    SimpleFrame frame = new SimpleFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(600, 500);
                    frame.setLocation(300, 100);
                    frame.setVisible(true);
                    frame.setResizable(false);
                    System.out.println("WORKING!");
                }
            });
        }
}

    class SimpleFrame extends JFrame{
        public SimpleFrame()
        {

        }
    }


