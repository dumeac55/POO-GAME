package PaooGame.Tiles;

import PaooGame.Graphics.Assets;


public class TreeTile extends Tile
{

    public TreeTile(int id)
    {
        super(Assets.tree, id);
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
