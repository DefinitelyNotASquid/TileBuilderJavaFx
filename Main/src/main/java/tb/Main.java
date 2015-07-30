package tb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;
import java.awt.*;

/**
 * Created by Someonepic on 07/30/2015.
 */
public class Main extends Application {

    Stage window;
    BorderPane layout;

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
        Menu helpMenu = new Menu("Help");
        //Menu items
        fileMenu.getItems().add(new Menu("Open File..."));
        fileMenu.getItems().add(new Menu("Save"));
        fileMenu.getItems().add(new Menu("New"));
        fileMenu.getItems().add(new Menu("Exit"));

        editMenu.getItems().add(new Menu("Undo"));
        editMenu.getItems().add(new Menu("Redo"));


        helpMenu.getItems().add(new Menu("About"));
        helpMenu.getItems().add(new Menu("Version"));


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 800, 600);
        window.setScene(scene);
        window.show();





    }



}
