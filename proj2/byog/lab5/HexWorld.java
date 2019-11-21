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
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    /*private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);*/
    public static void addHexagon(TETile[][]world,int x,int y,int base, TETile t) {
        if(base<2){
            throw new IllegalArgumentException("base needs to be at least 2");
        }
        for(int m=y;m<y+2*base;m++){
            int width=rowwidth(base,m-y);
            int offset=rowoffset(base,m-y);
            addrow(world,x+offset,m,width,t);
        }
    }

    /*for any given row, draw the world based on the offset and width*/
    public static void addrow(TETile[][]world,int offset,int y,int width,TETile t){
        for(int i=0;i<width;i++){
            int xnew=offset+i;
            world[xnew][y]=t;
        }
    }
    public static int rowoffset(int base, int row){
        if(row<base){
            return base-1-row;
        }
        return row-base;
    }
    public static int rowwidth(int base, int row){
        if(row<base){
            return base+2*row;
        }
        return 2*(base-row)+2*(base-1)+base;
    }
    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        addHexagon(world,20,20,9,Tileset.FLOWER);
        ter.renderFrame(world);
    }
}
