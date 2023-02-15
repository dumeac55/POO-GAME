package PaooGame.Bullet;


import PaooGame.AnimationManager.AnimationObject;
import PaooGame.Entity.Enemy;
import PaooGame.Entity.Entity;
import PaooGame.Entity.Player;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;
import PaooGame.Tiles.Tile;
import PaooGame.Types.Bullet_Types;
import PaooGame.Types.Current_Direction;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends Entity {
    private float x;
    private float y;
    private float speed = 3;
    private float xMove, yMove;
    private int directie2;
    private int firepower;
    protected Handler handler;
    private boolean enemy_fire = true;
    private BufferedImage current_image;
    private BufferedImage current_image1;
    private Current_Direction current_direction;
    protected Player player;
    private int tip;

    public Bullet(float x, float y, Handler handler, Current_Direction current_direction, int tip) {
        super(handler, x, y, 32, 32);
        this.x = x;
        this.y = y;
        this.tip = tip;
        this.enemy_fire = handler.getGame().getGameState().getPlayer().isEnemyFire();
        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_1);
        this.current_direction = current_direction;
        player = handler.getGame().getGameState().getPlayer();
        this.handler = handler;
        xMove = 0;
        yMove = 0;
        bounds.x = 15;
        bounds.y = 15;
        switch (tip) {
            case 1:
                switch (current_direction) {
                    case up:
                        yMove = -speed;
                        current_image = Assets.bullet_1[0];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_1);
                        this.x += 22
                        ;
                        this.y =y;
                        break;
                    case down:
                        yMove = speed;
                        current_image = Assets.bullet_1[2];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_1);
                        this.x += 22;
                        this.y += 22;
                        break;
                    case right:
                        xMove = speed;
                        current_image = Assets.bullet_1[1];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_1);
                        this.x += 22;
                        this.y += 22;
                        break;
                    case left:
                        xMove = -speed;
                        current_image = Assets.bullet_1[3];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_1);
                        this.x += 22;
                        this.y += 22;
                        break;
                }
                break;
            case 2:
                switch (current_direction) {
                    case up:
                        yMove = -speed;
                        current_image = Assets.bullet_2[0];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_2);
                        this.x += 22;
                        this.y = y;
                        break;
                    case down:
                        yMove = speed;
                        current_image = Assets.bullet_2[2];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_2);
                        this.x += 22;
                        this.y += 22;
                        break;
                    case right:
                        xMove = speed;
                        current_image = Assets.bullet_2[1];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_2);
                        this.x += 22;
                        this.y += 22;
                        break;
                    case left:
                        xMove = -speed;
                        current_image = Assets.bullet_2[3];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_2);
                        this.x += 22;
                        this.y += 22;
                        break;
                }
                break;
            case 3:
                switch (current_direction) {
                    case up:
                        yMove = -speed;
                        current_image = Assets.bullet_3[0];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_3);
                        this.x += 22;
                        this.y = y;
                        break;
                    case down:
                        yMove = speed;
                        current_image = Assets.bullet_3[2];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_3);
                        this.x += 22;
                        this.y += 22;
                        break;
                    case right:
                        xMove = speed;
                        current_image = Assets.bullet_3[1];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_3);
                        this.x += 22;
                        this.y += 22;
                        break;
                    case left:
                        xMove = -speed;
                        current_image = Assets.bullet_3[3];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_3);
                        this.x += 22;
                        this.y += 22;
                        break;
                }
                break;

            case 4:
                switch (current_direction) {
                    case up:
                        yMove = -speed;
                        current_image = Assets.bullet_4[0];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_4);
                        this.x += 22;
                        this.y = y;
                        break;
                    case down:
                        yMove = speed;
                        current_image = Assets.bullet_4[2];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_4);
                        this.x += 22;
                        this.y += 22;
                        break;
                    case right:
                        xMove = speed;
                        current_image = Assets.bullet_4[1];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_4);
                        this.x += 22;
                        this.y += 22;
                        break;
                    case left:
                        xMove = -speed;
                        current_image = Assets.bullet_4[3];
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_4);
                        this.x += 22;
                        this.y += 22;
                        break;
                }
                break;
            case 5:
                switch (current_direction) {
                    case up:
                        yMove = -speed;
                        current_image = Assets.bullet_5[0];
                        current_image1 = Assets.bullet_4[0];
                        this.x += 22;
                        this.y = y;
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_5) + Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_4);
                        break;
                    case down:
                        yMove = speed;
                        current_image = Assets.bullet_5[2];
                        current_image1 = Assets.bullet_4[2];
                        this.x += 22;
                        this.y += 22;
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_5) + Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_4);
                        break;
                    case right:
                        xMove = speed;
                        current_image = Assets.bullet_5[1];
                        current_image1 = Assets.bullet_4[1];
                        directie2 = 1;
                        this.x += 22;
                        this.y += 22;
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_5) + Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_4);
                        break;
                    case left:
                        xMove = -speed;
                        current_image = Assets.bullet_5[3];
                        current_image1 = Assets.bullet_4[3];
                        directie2 = 2;
                        this.x += 22;
                        this.y += 22;
                        this.firepower = Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_5) + Bullet_Types.FirePower(Bullet_Types.Bullet_Type.bullet_4);
                        break;
                }
                break;
        }
    }

    public void Update() {
        if (active) {
            move();
            if (checkEntityCollisions(xMove, 0f)) {
                active = false;
            } else if (checkEntityCollisions(0f, yMove)) {
                active = false;
            }
        }
    }

    public void Draw(Graphics g) {

        if(tip==5) {
                if (directie2 == 1) {
                    g.drawImage(current_image, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - 11 - handler.getGameCamera().getyOffset()), 20, 20, null);
                    g.drawImage(current_image1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y + 11 - handler.getGameCamera().getyOffset()), 20, 20, null);
                } else if (directie2 == 2) {
                    g.drawImage(current_image, (int) (x - handler.getGameCamera().getxOffset()), (int) (y + 11 - handler.getGameCamera().getyOffset()), 20, 20, null);
                    g.drawImage(current_image1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - 11 - handler.getGameCamera().getyOffset()), 20, 20, null);
                } else {
                    g.drawImage(current_image, (int) (x - 11 - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 20, 20, null);
                    g.drawImage(current_image1, (int) (x + 11 - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 20, 20, null);
                }
        }
        else
            g.drawImage(current_image, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 20, 20, null);
    }

    public void move() {
        moveX();
        moveY();
    }


    public void moveX() {
        if (xMove > 0) {
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            } else {
                active = false;
            }
        } else if (xMove < 0) {
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            } else {
                active = false;
            }
        }
    }


    public void moveY() {
        if (yMove < 0) {
            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                y += yMove;
            } else {
                active = false;
            }
        } else if (yMove > 0) {
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                y += yMove;
            } else {
                active = false;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isNotTraverseble();
    }
    @Override
    public boolean checkEntityCollisions(float xOffset, float yOffset) {
        for (Bullet b : handler.getWorld().getBulletManager().getBullets()) {
            if (b.equals(this) ) {
                continue;
            }

            if (b.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                b.setActive(true);
                return true;
            }
        }
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(player)) {
                continue;
            }

            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                if (!(e instanceof Enemy && this.enemy_fire)) {
                    e.hurt(firepower);
                }
                return true;
            }
        }
        return false;
    }
    @Override
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }
    public void die() {
        handler.getWorld().getAnimationManager().addAnimationObject(new AnimationObject(handler, x ,y, 32, 32, 20, 20));
    }
    public int getFirepower(){return firepower;}
}
