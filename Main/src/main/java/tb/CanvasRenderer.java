package tb;


import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;


/**
 * Created by Jake Harris on 8/4/2015.
 */
public class CanvasRenderer {
    private int width = 0;
    private int height = 0;
    private int tileWidth = 0;
    private int tileHeight = 0;

    int[][] tiles; //Array that holds the tiles


//    private int defaultTileWidth = 32;
//    private int defaultTileHeight = 32;

    private int activeLayer = 0;
    private boolean hideLayers = false;
    private boolean showGrid = true;
    private boolean drawCheckerBoard = true;
    private boolean stateChanged = false;

    int grabX = 0;
    int grabY = 0;
    boolean dragged = false;

    int offsetX = 0;
    int offsetY = 0;

    private GraphicsContext gc;
    private Canvas canvas;

    GraphicsBank testBank = new GraphicsBank();
    Tile testTile = new Tile(2, "tree2.png","tree2","tree");


    CanvasRenderer() {
        this(10, 10, 32, 32);

    }

    CanvasRenderer(int width, int height) {
        this(width, height, 32, 32);

    }

    CanvasRenderer(int width, int height, int tileWidth, int tileHeight) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.width = width;
        this.height = height;
        this.canvas = new Canvas(width * tileWidth, height * tileHeight);
        this.gc = canvas.getGraphicsContext2D();

        tiles = new int[width][height];
        clearTiles(tiles);




        this.canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double tileX = Math.floor(event.getX() / tileWidth);
                double tileY = Math.floor(event.getY() / tileHeight);
                drawImage(tileX,tileY);
                System.out.println("X: " + tileX + ", Y:" + tileY);

            }
        });

    }

    public void drawCheckerBoard() {
        boolean flip = true;

        for (int i = 0; i < width; i++) {
            if (flip) {
                gc.setFill(Color.BLACK);
                flip = false;
            } else {
                gc.setFill(Color.web("#FF00DC"));
                flip = true;
            }
            for (int n = 0; n < height; n++) {
                if (flip) {
                    gc.setFill(Color.BLACK);
                    flip = false;
                } else {
                    gc.setFill(Color.web("#FF00DC"));
                    flip = true;
                }
                gc.fillRect(i * tileWidth, n * tileHeight, tileWidth, tileHeight);
            }
        }
    }

    public void drawGridLines() {

        for (int i = 0; i < width; i++) {

            for (int n = 0; n < height; n++) {

                gc.strokeRect(i * tileWidth, n * tileHeight, tileWidth, tileHeight);
            }
        }
    }

    public void clearTiles(int[][] tiles) {
        for (int i = 0; i < width; i++) {
            for (int n = 0; n < height; n++) {
                tiles[i][n] = 0;

            }
        }
    }

//    public void drawMap(int[][] tiles GraphicsBank gb) {
//        for (int i = 0; i < width; i++) {
//            for (int n = 0; n < height; n++) {
//                gc.drawImage(testTile.getImage(),);
//
//            }
//        }
//
//    }

    public void drawImage(double X, double Y){
        gc.drawImage(testTile.getImage(),((X*tileWidth) - testTile.getImageWidth()) + tileWidth,((Y*tileHeight) - testTile.getImageHeight() +tileHeight));

    }

    public void drawSquare(int x, int y, int w, int h) {
        gc.fillRect(x, y, w, h);

    }

//    public void updateGraphics() {
//
//
//        for(){
//            for{
//                for (){
//
//                }
//            }
//        }
//
//        //Draw Utility Things like Grid And CheckerBoard
//        if(drawCheckerBoard){
//            drawCheckerBoard();
//        }
//
//        if(showGrid){
//            drawGridLines();
//        }
//
//
//    }

    public Canvas getCanvas() {
        return this.canvas;

    }

    public void setShowGrid(boolean setTrue) {
        if (setTrue) {
            showGrid = true;
        } else
            showGrid = false;
    }


    public void setDrawCheckerBoard(boolean check){
        if(check){
            drawCheckerBoard = true;
        }else
        {
            drawCheckerBoard = false;
        }

    }



    public GraphicsContext getGraphicContext(){
        return this.gc;

    }

}
