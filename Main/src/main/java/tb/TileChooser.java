package tb;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Iterator;

/**
 * Created by Someonepic on 07/31/2015.
 */
public class TileChooser {
    Stage windows;
    GridPane layout;
    GraphicsBank gfx;
    static boolean answer;

    public static boolean display(String title){
        Stage windows = new Stage();
        windows.setTitle(title);
        windows.setMinWidth(250);

        BorderPane tilelayout = new BorderPane();
        //Set the buttons up
        HBox hb = new HBox();
        Button OpenButtons = new Button("Open...");
        Button saveButtons = new Button("Save");
        Button ClearButtons = new Button("Clear");
        hb.setPadding(new Insets(0,0,100,62.5));


        tilelayout.setTop(hb);
        hb.getChildren().addAll(OpenButtons,saveButtons,ClearButtons);
        Scene scene = new Scene(tilelayout, 250, 600);
        windows.setScene(scene);
        windows.show();
        return answer;
    }
}
