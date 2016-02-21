package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwingView  extends JFrame implements ActionListener{


    public static final int WINDOWS_WIDTH = 500;
    public static final int WINDOWS_HEIGHT = 400;
    public static final int TEXT_AREA_ROWS = 20;
    public static final int TEXT_AREA_COLUMNS = 20;
    private final JTextArea originText;
    private final JTextArea translatedText;

    public SwingView(){
        setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);
        setTitle("Transapp");

        JPanel jPanel = new JPanel();
//        FlowLayout flowLayout = new FlowLayout();
//        jPanel.setLayout(flowLayout);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridx=0; //x coordinate of the cell
        constraints.gridy=0; // y coordinate of the cell
        constraints.gridheight = 1;
        constraints.gridwidth = 1;

        JLabel jlOriginText = new JLabel("Input text to translate");
        gridBagLayout.setConstraints(jlOriginText,constraints);

        constraints.gridx=1; //x coordinate of the cell
        constraints.gridy=0; // y coordinate of the cell
        constraints.gridheight = 1;
        constraints.gridwidth = 1;

        JLabel jlTranslatedText = new JLabel("Translated text");
        gridBagLayout.setConstraints(jlTranslatedText,constraints);

        //fill all space in the cell
        // constraints.gridwidth = constraints.BOTH;


        jPanel.add(jlOriginText);
        jPanel.add(jlTranslatedText);

        this.setResizable(false);
        this.setContentPane(jPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        constraints.gridx=0; //x coordinate of the cell
        constraints.gridy=1; // y coordinate of the cell
        constraints.gridheight = 6;
        constraints.gridwidth = 1;


        originText = new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLUMNS);
        JScrollPane jspOriginText = new JScrollPane(originText);
        originText.setWrapStyleWord(true);
        originText.setLineWrap(true);
        //originText.setSize(10, 10);

        gridBagLayout.setConstraints(jspOriginText,constraints);
        //jPanel.add(originText);
        jPanel.add(jspOriginText);

        constraints.gridx=1; //x coordinate of the cell
        constraints.gridy=1; // y coordinate of the cell
        constraints.gridheight = 6;
        constraints.gridwidth = 1;
        translatedText = new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLUMNS);
        JScrollPane jspTranslatedText = new JScrollPane(translatedText);
        translatedText.setWrapStyleWord(true);
        translatedText.setWrapStyleWord(true);
        translatedText.setLineWrap(true);
        //translatedText.setSize(10, 10);
        gridBagLayout.setConstraints(jspTranslatedText,constraints);
        jPanel.add(jspTranslatedText);

        constraints.gridx=0; //x coordinate of the cell
        constraints.gridy=7; // y coordinate of the cell
        constraints.gridheight = 1;
        constraints.gridwidth = 2;

        JButton translateButton = new JButton("Translate");
        gridBagLayout.setConstraints(translateButton,constraints);
        translateButton.addActionListener(this);
        jPanel.add(translateButton);

        setVisible(true);

    }

    public static void main(String[] args) {
        SwingView swingView = new SwingView();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //translatedText.setText(originText.getText());
        String textToTranslate = originText.getText();
        textToTranslate = textToTranslate.replace("\r\n","%0D%0A").replace("\n", "%0D%0A").replace("\r", "%0D%0A");
        String translated = TranslateUtil.translate(textToTranslate);
        System.out.println(translated);
        translatedText.setText(translated);
    }
}
