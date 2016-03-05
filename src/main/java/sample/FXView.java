package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXView extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "./resources/hello.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("JavaFX and Maven");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
