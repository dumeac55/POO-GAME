package PaooGame.Entity;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Castel extends Entity2{
    protected BufferedImage image;
    public Castel(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        this.health=50;
        this.image=Assets.townGrass;
    }

    @Override
    public void Update() {

    }
    @Override
    public void die() {
    }

    @Override
    public void hurt(int amount){
        if (health > 0) {
            health -= amount;
            if (health <= 0) {
                handler.getWorld().getEntityManager().getPlayer().AddPoints(-30);
                this.image = Assets.townGrassDestroyed;
                die();
            }
        }
    }
    @Override
    public void Draw(Graphics g) {
        g.drawImage(this.image,(int)(x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height,null);
    }
}
