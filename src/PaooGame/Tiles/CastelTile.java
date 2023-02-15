package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class CastelTile extends  Tile{
    public CastelTile(int id)
    {
        super(Assets.townGrass, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
    public boolean isNotTraverseble() {
        return true;
    }
}
