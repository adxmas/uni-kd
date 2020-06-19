package mainas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/mainas.fxml"));
        primaryStage.setTitle("Car Renting Service");
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();

    }


    public static void main(String[] args) {

        launch(args);
    }
}
