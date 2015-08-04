package tb;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.image.Image;
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
import javafx.scene.image.ImageView;
import javafx.geometry.*;
import java.util.Iterator;

/**
 * Created by Someonepic on 07/31/2015.
 */
public class TileChooser {
    Stage windows;
    GridPane layout;
    GraphicsBank gfx;




    public void tilepane(String name, int tilecount, String path) {

        TilePane tile = new TilePane(Orientation.VERTICAL);
        tile.setTileAlignment(Pos.CENTER_LEFT);
        tile.setPrefRows(4);

        for (int i = 0; i < tilecount; ) {

            String j = name;

            Image image = new Image(path);
            Button B = new Button(j);
            B.setPadding(new Insets(0, 0, 0, 0));
            B.setMinSize(32, 32);
            B.setMaxSize(32, 32);

            ImageView k = new ImageView(image);

            tile.getChildren().add(B);
            B.setGraphic(k);
            i++;
        }

    }
    public static boolean display(String title) {


        Stage windows = new Stage();
        windows.setTitle(title);
        windows.setMinWidth(250);

        BorderPane tilelayout = new BorderPane();
        //Set the buttons up
        HBox hb = new HBox();
        Button OpenButtons = new Button("Open...");
        OpenButtons.setOnAction(e -> fileDialog.Displayopen(windows));
        OpenButtons.setPadding(new Insets(0, 0, 0, 0));

        Button saveButtons = new Button("Save");

        saveButtons.setOnAction(e -> fileDialog.Displaysave(windows));
        saveButtons.setPadding(new Insets(0, 0, 0, 0));

        Button ClearButtons = new Button("Clear");
        ClearButtons.setPadding(new Insets(0, 0, 0, 0));
        hb.setPadding(new Insets(0, 0, 100, 62.5));
        tilelayout.setTop(hb);


        hb.getChildren().addAll(OpenButtons, saveButtons, ClearButtons);
        Scene scene = new Scene(tilelayout, 250, 600);
        windows.setScene(scene);

        windows.show();
        windows.setOnCloseRequest(e -> {
            e.consume();
            Main.handleClose();
        });



    }


