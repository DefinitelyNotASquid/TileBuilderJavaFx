package tb;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Someonepic on 8/4/2015.
 */
public class PropertiesDialog {
    static boolean answer;
    public static boolean displayTile(String title){

        Stage windows1 = new Stage();
        windows1.initModality(Modality.APPLICATION_MODAL);
        windows1.setTitle(title);
        //Implement spinner Here
        Label idtext = new Label("ID");
        Label nametext = new Label("Tile Name");
        Label Typetext = new Label("Tile Type");
        Label Pathtext = new Label("Relative path");

        TextField idInput = new TextField();
        TextField NameInput = new TextField();
        TextField FilePathInput = new TextField();
        TextField TypeInput = new TextField();

        NameInput.setPromptText("Enter The tile Name");
        idInput.setPromptText("Enter Tile Id (1-9999)");
        TypeInput.setPromptText("Enter Type of the Tile");
        FilePathInput.setPromptText("Enter Relative File Path");

        Button Delete = new Button("Clear");
        Button Cancel = new Button("Cancel");
        Cancel.setOnAction(e -> windows1.close());
        Button Save = new Button("Save");
     //  Save.setOnAction(e -> isInt(idInput, idInput.getText()));

        //Layout
        HBox layout = new HBox(2);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(Save,Delete,Cancel);
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(12);
        gp.add(idtext, 0, 0);
        gp.add(idInput, 1, 0);
        gp.add(nametext, 0, 1);
        gp.add(NameInput, 1, 1);
        gp.add(Typetext, 0, 2);
        gp.add(TypeInput, 1,2);
        gp.add(Pathtext, 0,3);
        gp.add(FilePathInput, 1,3);
        BorderPane bp = new BorderPane();
        bp.setCenter(gp);
        bp.setBottom(layout);

        Scene scene = new Scene(bp, 250, 200);
        windows1.setScene(scene);
        windows1.showAndWait();

    return answer;
    }


}
