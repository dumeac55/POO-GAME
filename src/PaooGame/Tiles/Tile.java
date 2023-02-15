package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Tile
{
    private static final int NO_TILES   = 32;
    public static Tile[] tiles          = new Tile[NO_TILES];
    public static Tile grassTile        = new GrassTile(0);
    public static Tile mountainTile     = new MountainTile(1);
    public static Tile waterTile        = new WaterTile(2);
    public static Tile treeTile         = new TreeTile(3);
    public static Tile soilTile         = new SoilTile(4);
    public static Tile castel          = new CastelTile(5);

    public static final int TILE_WIDTH  = 72;
    public static final int TILE_HEIGHT = 72;

    protected BufferedImage img;
    protected final int id;

    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;
        tiles[id] = this;
    }


    public void Update()
    {

    }
    public void Draw(Graphics g, int x, int y)
    {

        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }
    public boolean IsSolid()
    {
        return false;
    }
    public int GetId()
    {
        return id;
    }
    public boolean isNotTraverseble() {
        return false;
    }


}
