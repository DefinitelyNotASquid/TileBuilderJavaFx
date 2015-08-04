package tb;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.event.MouseListener;

/**
 * Created by Jake Harris on 8/4/2015.
 */
public class CanvasRenderer{
    private int width = 0;
    private int height = 0;
    private int tileWidth = 0;
    private int tileHeight = 0;

//    private int defaultTileWidth = 32;
//    private int defaultTileHeight = 32;

    private int activeLayer = 0;
    boolean hideLayers = false;
    boolean showGrid = true;
    boolean stateChanged = false;

    int grabX = 0;
    int grabY = 0;
    boolean dragged = false;

    int offsetX = 0;
    int offsetY = 0;

    GraphicsContext gc;
    Canvas canvas;

    CanvasRenderer(){
        this(10, 10, 32, 32);

    }

    CanvasRenderer(int width, int height){
        this(width, height, 32, 32);

    }

    CanvasRenderer(int width, int height, int tileWidth, int tileHeight){
        this.width = width;
        this.height = height;
        this.canvas = new Canvas(width*tileWidth, height*tileHeight);
        this.gc = canvas.getGraphicsContext2D();

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

    public Canvas getCanvas(){
        return this.canvas;

    }

    public GraphicsContext getGraphicContext(){
        return this.gc;

    }

}
