package tb;

/**
 * Created by JakeSuper on 30/07/2015.
 */
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by JakeSuper on 30/07/2015.
 */
public class ConfirmBox {
    private boolean answer;


    public boolean displayGetAnswer(String title, String message){



        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);


        //Set message on the label
        Label label = new Label();
        label.setText(message);

        //Set the buttons up
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        //HBox layout2 = new HBox(30);
        BorderPane layout = new BorderPane();
        layout.setTop(label);
        layout.setLeft(yesButton);
        layout.setRight(noButton);


        layout.setPadding(new Insets(10,30,10,30));

        //layout2.getChildren().addAll(yesButton, noButton);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }

    public void handleClose(Stage window, String Title, String Message){
        ConfirmBox box = new ConfirmBox();
        boolean close = box.displayGetAnswer(Title, Message);
        if(close){
            window.close();

        }

    }

}
