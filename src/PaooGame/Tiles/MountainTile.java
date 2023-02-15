package PaooGame.Tiles;

import PaooGame.Graphics.Assets;


public class MountainTile extends Tile {


    public MountainTile(int id)
    {

        super(Assets.mountain, id);
    }


    @Override
    public boolean IsSolid()
    {
        return true;
    }
    public boolean isNotTraverseble() {
        return true;
    }
}
