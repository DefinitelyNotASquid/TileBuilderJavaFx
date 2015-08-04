package tb;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Created by Someonepic on 07/31/2015.
 */
public class TileChooser {
    static boolean answer;



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
    public static boolean display(String title){


        Stage windows = new Stage();
        windows.setTitle(title);
        windows.setMinWidth(250);

        BorderPane tilelayout = new BorderPane();
        //Set the buttons up
        HBox hb = new HBox();
        Button OpenButtons = new Button("Open...");
        OpenButtons.setOnAction(e -> fileDialog.Displayopen(windows) );
        OpenButtons.setPadding(new Insets(0, 0, 0, 0));

        Button saveButtons = new Button("Save");

        saveButtons.setOnAction(e -> fileDialog.Displaysave(windows) );
        saveButtons.setPadding(new Insets(0, 0, 0, 0));

        Button ClearButtons = new Button("Clear");
        ClearButtons.setOnAction(e -> PropertiesDialog.displayTile("Tile Properties") );
        ClearButtons.setPadding(new Insets(0, 0, 0, 0));
        hb.setPadding(new Insets(0, 0, 100, 62.5));
        tilelayout.setTop(hb);



        hb.getChildren().addAll(OpenButtons, saveButtons, ClearButtons);
        Scene scene = new Scene(tilelayout, 250, 600);
        windows.setScene(scene);

        windows.show();






        return answer;
    }


    }


