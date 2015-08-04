package tb;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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



        Button OpenButtons = new Button("Open...");
        OpenButtons.setOnAction(e -> fileDialog.Displayopen(windows));

        Button saveButtons = new Button("Save");

        saveButtons.setOnAction(e -> fileDialog.Displaysave(windows));

        Button Tpbuttons = new Button("Tile Info");
        Tpbuttons.setOnAction(e -> PropertiesDialog.displayTile("Tile Properties"));
        Button ClearButtons = new Button("Clear");
        ClearButtons.setOnAction(e -> System.out.print("Clear the Tileset"));

        ToolBar tilebar = new ToolBar();
        tilebar.getItems().addAll(
                OpenButtons,
                new Separator(),
                saveButtons,
                new Separator(),
                ClearButtons,
                new Separator(),
                Tpbuttons
        );


        tilelayout.setTop(tilebar);

        Scene scene = new Scene(tilelayout, 250, 600);
        windows.setScene(scene);

        windows.show();






        return answer;
    }


    }


