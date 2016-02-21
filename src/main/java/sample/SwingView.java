package sample;

import javax.swing.*;


public class SwingView  extends JFrame{

    public SwingView(){
        setSize(500,500);
        setTitle("Transapp");

        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton translateButton = new JButton("Translate");
        JTextArea originText = new JTextArea(10,10);
        jPanel.add(translateButton);
        jPanel.add(originText);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingView swingView = new SwingView();


    }
}
