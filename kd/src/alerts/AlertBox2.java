package alerts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox2 {

    public static void display(String msg){

        Stage alertWindow = new Stage();

        //blokuoja user interaction su main langu, kol alertboxo window nera isjungtas
        alertWindow.initModality(Modality.APPLICATION_MODAL);
        alertWindow.setTitle("Klaida");
        alertWindow.setMinWidth(250);

        Label label = new Label();
        label.setText(msg);
        Button closeButton = new Button("Close button");
        closeButton.setOnAction(e -> alertWindow.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        alertWindow.setScene(scene);
        alertWindow.showAndWait();
    }

}