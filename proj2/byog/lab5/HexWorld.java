package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 * Inspired by the official solution
 */
public class HexWorld {
    /**
     * add Hexagon function
     * @param world the world to draw on
     * @param x the starting point at the left bottom coordinate
     * @param y the starting point at the left bottom coordinate
     * @param base the base size to begin with
     * @param t the tile to draw
     */
    public static void addHexagon(TETile[][]world,int x,int y,int base, TETile t) {
    }

    /*for any given row, draw the world based on the offset and width*/
    public static void addrow(TETile[][]world,int x,int y,int width,TETile t){
        for(int i=0;i<width;i++){
            int xnew=x+i;
            world[xnew][y]=t;
        }
    }

    public static int rowoffset(int base, int row){
        if(row<base){
            return base-1-row;
        }
        return row-base-1;
    }
    public static int rowwidth(int base, int row){
        if(row<base){
            return base+2*row;
        }
        return 2*(base-row);
    }
}
