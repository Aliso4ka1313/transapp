package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MainController {
    @FXML private TextArea originText;
    @FXML private TextArea translatedText;

    @FXML protected void handleTranslateButtonAction (ActionEvent event){
        String textToTranslate = originText.getText();
        textToTranslate = textToTranslate.replace("\r\n","%0D%0A").replace("\n", "%0D%0A").replace("\r", "%0D%0A");
        String translated = TranslateUtil.translate(textToTranslate);
        translatedText.setText(translated);
    }


}
