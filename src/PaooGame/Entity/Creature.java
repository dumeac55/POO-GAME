package PaooGame.Entity;

import PaooGame.AnimationManager.AnimationObject;
import PaooGame.Bullet.Bullet;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;
import PaooGame.Tiles.Tile;
import PaooGame.Types.Current_Direction;
import java.awt.image.BufferedImage;

public abstract class Creature extends Entity {
    protected int health;
    protected int speed;
    public static int Default_width = 64;
    public static int Default_height = 64;
    public float xMove;
    public float yMove;
    protected boolean EnemyFire = true;
    protected Current_Direction current_direction;
    protected BufferedImage[] images;

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    private int flag = 0;

    public boolean isEnemyFire() {
        return EnemyFire;
    }

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = 60;
        speed = 4;
        xMove = 0;
        yMove = 0;
        images = Assets.tank_1;
        // current_direction=Current_Direction.up;
    }

    public void move() {
        if (!checkEntityCollisions(xMove, 0f)) {
            moveX();
        }
        if (!checkEntityCollisions(0f, yMove)) {
            moveY();
        }
    }

    @Override
    public void die() {
        handler.getWorld().getAnimationManager().addAnimationObject(new AnimationObject(handler, x ,y, 64, 64, Default_width, Default_height));
    }

    public void moveX() {
        if (xMove > 0) {
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if (!collision(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collision(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
            }
        } else if (xMove < 0) {
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            if (!collision(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collision(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
    }

    public void moveY() {
        if (yMove < 0) {
            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
            if (!collision((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collision((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
            }
        } else if (yMove > 0) {
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
            if (!collision((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collision((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }

    protected boolean collision(int x, int y) {
        return handler.getWorld().getTile(x, y).IsSolid();
    }



}
