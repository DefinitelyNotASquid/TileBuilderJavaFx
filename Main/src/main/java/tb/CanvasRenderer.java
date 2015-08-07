package tb;


import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


/**
 * Created by Jake Harris on 8/4/2015.
 */
public class CanvasRenderer {
    private int width = 0;
    private int height = 0;
    private int tileWidth = 0;
    private int tileHeight = 0;

    Image image1 = new Image("tree.png");

    GraphicsBank gb = new GraphicsBank();

    Tile nullTile = new Tile(0, "null.png", "null tile", "null", "The tile that automatically populates the canvas");


    int[][][] tiles; //Array that holds the tiles


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

        tiles = new int[width][height][2];

        initializeTileArray();
        gb.add(nullTile);




        this.canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int tileX = (int) (Math.floor(event.getX() / tileWidth));
                int tileY = (int) (Math.floor(event.getY() / tileHeight));
                drawImage(1, tileX, tileY, 1);
                System.out.println("X: " + tileX + ", Y:" + tileY);

            }
        });

    }

    private void initializeTileArray() {
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                for(int l = 0; l < 2; l++) {
                    tiles[x][y][l] = 0;
                }
            }
        }
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
//    }

    public void drawImage(int ID ,int X, int Y, int Z){
        //gc.drawImage(testTile.getImage(),((X*tileWidth) - testTile.getImageWidth()) + tileWidth,((Y*tileHeight) - testTile.getImageHeight() +tileHeight));
        tiles[X][Y][Z] = ID;
        updateGraphics();

    }

    public void drawSquare(int x, int y, int w, int h) {
        gc.fillRect(x, y, w, h);

    }

    public void updateGraphics() {
        //Draw Utility Things like Grid And CheckerBoard
        if(drawCheckerBoard){
            drawCheckerBoard();
        }

        int tileToDraw = 0;
        int y = 0;
        int x = 0;
        for(int Z = 0; Z < 2; Z++){
            for(x = 0; x < width; x++){
                for(y = 0; y < height; y++) {
                    tileToDraw = tiles[x][y][Z];
                    gc.drawImage(gb.getTile(tileToDraw).getImage(), x*tileWidth, y*tileHeight );
                    System.out.println("Drew Tile X: " + x + " Y: " + y + " Z: " + Z);
                }
            }
        }

        if(showGrid){
            drawGridLines();
        }


    }

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
