package tb;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by Someonepic on 07/30/2015.
 */
public class Main extends Application {

    Stage window;
    BorderPane layout;
    BorderPane layout2;

    public static void main(String[] args){

        launch(args);

    }

    @Override

    public void start (Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("UNESE Javafx Tile Editor");
        //file menu
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu ViewMenu = new Menu("View");
        Menu helpMenu = new Menu("Help");

        //FileMenu items
        MenuItem openfile = new MenuItem("Open File...");
        openfile.setOnAction(e -> fileDialog.Displayopen(window) );
        fileMenu.getItems().add(openfile);

        MenuItem savefile = new MenuItem("Save");
        savefile.setOnAction(e -> System.out.print("saves the file"));
        fileMenu.getItems().add(savefile);

        MenuItem saveasfile = new MenuItem("Save as...");
        saveasfile.setOnAction(e -> fileDialog.Displaysave(window));
        fileMenu.getItems().add(saveasfile);

        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem newfile = new MenuItem("New");
        newfile.setOnAction(e -> System.out.print("Reset File, call dialog"));
        fileMenu.getItems().add(newfile);

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> handleClose());
        fileMenu.getItems().add(exit);
        //View Menu
        MenuItem ShowTileBar = new MenuItem("Tile bar");
        ShowTileBar.setOnAction(e-> TileChooser.display("Tile Bar"));
        ViewMenu.getItems().add(ShowTileBar);

        CheckMenuItem showgrid = new CheckMenuItem("Show Grid");
        showgrid.setOnAction(e -> {
            if (showgrid.isSelected())
                System.out.println("Show the lines");


            else
                System.out.println("hide the lines");
        });
        ViewMenu.getItems().add(showgrid);

        CheckMenuItem showlayers = new CheckMenuItem("Hide Other Layers");
        showlayers.setOnAction(e -> {
            if (showgrid.isSelected())
                System.out.println("Set Opacity");


            else
                System.out.println("Hide opacity");
        });
        ViewMenu.getItems().add(showlayers);


        //Edit Menu


        MenuItem undo = new MenuItem("Undo");
        undo.setOnAction(e -> System.out.print("Redo the previous operation"));
        editMenu.getItems().add(undo);

        MenuItem redo = new MenuItem("Redo");
        redo.setOnAction(e -> System.out.print("Undo the previous operation"));
        editMenu.getItems().add(redo);

        //Help Menu

        MenuItem about = new MenuItem("About");
        about.setOnAction(e -> System.out.println("Created by Group S"));
        helpMenu.getItems().add(about);

        MenuItem version = new MenuItem("Version");
        version.setOnAction(e -> System.out.println("Version 1.0"));
        helpMenu.getItems().add(version);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, ViewMenu, helpMenu);

        HBox topbar = new HBox();
        Button Zoomin = new Button("Zoom in");
        Button Zoomout = new Button("Zoom out");
        Button Set = new Button("Set");
        ToggleButton Fill = new ToggleButton("Fill");
        Button Something = new Button("Zoom in");
        topbar.getChildren().addAll(Zoomin,Zoomout, Fill, Something,Set);



        layout = new BorderPane();
        layout2 = new BorderPane();
        layout.setCenter(layout2);
        layout.setTop(menuBar);
        layout2.setTop(topbar);
        Scene scene = new Scene(layout, 800, 600);
        window.setScene(scene);
        window.show();
        //Handle Application Exit
        window.setOnCloseRequest(e -> {
            e.consume();
            handleClose();
        });
    }


    public void handleClose(){
        Boolean answer = ConfirmBox.display("Title" , "Sure you want to exit?");
        if(answer)
            window.close();

    }



}




