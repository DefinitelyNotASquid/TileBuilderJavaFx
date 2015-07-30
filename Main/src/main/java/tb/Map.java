package tb;

import javafx.scene.image.ImageView;
import java.util.*;

/**
 * Created by Someonepic on 07/30/2015.
 */
public class Map {

    int tileWidth = 32;
    int tileHeight = 32;

    int zoomWidth = 32;
    int zoomHeight = 32;

    int viewWidth = 400;
    int viewHeight = 400;

    ArrayList changeListeners;

    final static int LAYERS = 3;

    Tile[][][] tiles; //ground layer

    public Map(int width, int height)
    {
        tiles = new Tile[width][height][LAYERS];
        changeListeners = new ArrayList();
    }
    public Map(int width, int height, int tileWidth, int tileHeight)
    {
        this(width, height);
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        zoomWidth = tileWidth;
        zoomHeight = tileHeight;
    }

    public void setTile(int x, int y, int z, Tile t)
    {
        tiles[x][y][z] = t;
    }

    void setZoom(float z) {
        zoomWidth  = (int)(tileWidth * z);
        zoomHeight = (int)(tileHeight * z);

    }
    public void setViewSize(int width, int height)
    {
        this.viewWidth = width;
        this.viewHeight = height;
    }

    public int getWidth()
    {
        return tiles.length;
    }
    public int getHeight()
    {
        return tiles[0].length;
    }
    public int getTileWidth()
    {
        return tileWidth;
    }
    public int getTileHeight()
    {
        return tileHeight;
    }

    public int getZoomWidth()
    {
        return zoomWidth;
    }
    public int getZoomHeight()
    {
        return zoomHeight;
    }
    public Tile getTile(int x, int y, int z)
    {
        return tiles[x][y][z];
    }
    void resize(int newWidth, int newHeight, int newLayers)
    {
        System.out.println("Call resize");
        int w, h, l;
        newWidth = Math.max(1, newWidth);
        newHeight = Math.max(1, newHeight);
        Tile[][][] newTiles = new Tile[newWidth][newHeight][newLayers];


        w = Math.min(newWidth, tiles.length);
        h = Math.min(newHeight, tiles[0].length);
        l = Math.min(newLayers, tiles[0][0].length);

        for(int x = 0; x < w; x++) {
            for(int y = 0; y < h; y++) {
                for(int j = 0; j < l; j++) {
                    newTiles[x][y][j] = tiles[x][y][j];
                }
            }
        }
        tiles = newTiles;
    }

    void shift(int offX, int offY)
    {
        System.out.println("Shift to new offset " + offX + ", " + offY + ".");
        Tile[][][] newTiles = new Tile[tiles.length][tiles[0].length][LAYERS];

        int xStart = Math.max(0, -offX);
        int yStart = Math.max(0, -offY);
        int xEnd = Math.min(tiles.length,    tiles.length    - offX);
        int yEnd = Math.min(tiles[0].length, tiles[0].length - offY);

        for(int x = xStart; x < xEnd; x++) {
            for(int y = yStart; y < yEnd; y++) {
                for(int l = 0; l < LAYERS; l++) {
                    newTiles[x + offX][y + offY][l] = tiles[x][y][l];
                }
            }
        }
        tiles = newTiles;
    }

    void clear()
    {
        for(int x = 0; x < tiles.length; x++) {
            for(int y = 0; y < tiles[0].length; y++) {
                for(int l = 0; l < LAYERS; l++) {
                    tiles[x][y][l] = null;
                }
            }
        }
    }

    public int[][][] toIntArray() {
        int set[][][] = new int[tiles.length][tiles[0].length][tiles[0][0].length];
        for(int x = 0; x < tiles.length; x++) {
            for(int y = 0; y < tiles[0].length; y++) {
                for(int l = 0; l < LAYERS; l++) {
                    if(tiles[x][y][l] != null) {
                        set[x][y][l] = tiles[x][y][l].number;
                    } else {
                        set[x][y][l] = 0;
                    }
                }
            }
        }
        return set;
    }
    //Fill will need to fix
   // public void setAllTiles(int[][][] set, GraphicsBank bank) {
     //   gfx = bank;
       // resize(tiles.length, tiles[0].length, tiles[0][0].length);

		/*
		if(set.length == tiles.length &&
		   set[0].length == tiles[0].length &&
		   set[0][0].length == tiles[0][0].length) {
		  */

       // for(int x = 0; x < tiles.length; x++) {
         //   for(int y = 0; y < tiles[0].length; y++) {
           //     for(int l = 0; l < LAYERS; l++) {
             //       tiles[x][y][l] = bank.getTile(set[x][y][l]);
               // }
        //    }
       // }


}