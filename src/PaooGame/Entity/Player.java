package PaooGame.Entity;

import PaooGame.Audio.Audio;
import PaooGame.Bullet.Bullet;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;
import PaooGame.Types.Current_Direction;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Creature {
    static private int points=0;
    static protected int upgrade_level = 0;
    protected int direction = 0;
    private long could=500;

    private long could2=0;
    private BufferedImage currentdirection;
    Audio audio;
    protected Current_Direction current_direction;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.Default_height, Creature.Default_width);
        bounds.x = 5;
        bounds.y = 5;
        bounds.height = 50;
        bounds.width = 50;
        current_direction = Current_Direction.up;
        currentdirection=Assets.tank_1[0];
        EnemyFire=false;

    }
    @Override
    public void die(){
        if(points>10){

        }
    }
    @Override
    public void Update() {
        switch (upgrade_level) {
            case 1:
                getInput2();
                break;
            default:
                getInput();
        }
        move();
        handler.getGameCamera().center(this);
        die();
    }
    private void getInput2() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) {
            yMove = -speed;
            current_direction = Current_Direction.up;
            currentdirection=Assets.tank_6[0];
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
            current_direction = Current_Direction.down;
            currentdirection=Assets.tank_6[2];
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
            current_direction = Current_Direction.left;
            currentdirection=Assets.tank_6[3];
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
            current_direction = Current_Direction.right;
            currentdirection=Assets.tank_6[1];
        }
        if (handler.getKeyManager().space) {
            long time=System.currentTimeMillis();
            if(time>could2+could){
                handler.getWorld().getBulletManager().addBullet(new Bullet(x, y, handler,current_direction,5));
                audio = new Audio("res/textures/music/trage.wav");
                audio.play();
                could2=time;
            }
        }
    }
    public void hurt(int n){
        health=health-10;
    }
    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) {
            yMove = -speed;
            current_direction = Current_Direction.up;
            currentdirection=Assets.tank_1[0];
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
            current_direction = Current_Direction.down;
            currentdirection=Assets.tank_1[2];
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
            current_direction = Current_Direction.left;
            currentdirection=Assets.tank_1[3];
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
            current_direction = Current_Direction.right;
            currentdirection=Assets.tank_1[1];
        }
        if (handler.getKeyManager().space) {
           long time=System.currentTimeMillis();
           if(time>could2+could){
               handler.getWorld().getBulletManager().addBullet(new Bullet(x, y, handler,current_direction,1));
               audio = new Audio("res/textures/music/trage.wav");
               audio.play();
               could2=time;
           }
        }
    }

    @Override
    public void Draw(Graphics g) {
        if (handler.getKeyManager().up && !handler.getKeyManager().right && !handler.getKeyManager().left) {
            g.drawImage(currentdirection, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
            direction = 1;
        }
        if (handler.getKeyManager().down && !handler.getKeyManager().right && !handler.getKeyManager().left) {
            g.drawImage(currentdirection, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
            direction = 2;
        }
        if (handler.getKeyManager().left) {
            g.drawImage(currentdirection, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
            direction = 3;
        }
        if (handler.getKeyManager().right) {
            g.drawImage(currentdirection, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
            direction = 4;
        }
        if (!handler.getKeyManager().up && !handler.getKeyManager().right && !handler.getKeyManager().left && !handler.getKeyManager().down) {
            switch (direction) {
                case 1:
                    g.drawImage(currentdirection, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
                    break;
                case 2:
                    g.drawImage(currentdirection, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
                    break;
                case 3:
                    g.drawImage(currentdirection, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
                    break;
                case 4:
                    g.drawImage(currentdirection, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
                    break;
            }
        }
    }

    public static void AddPoints(int points){
        Player.points += points;
    }
    public void addhealth(int health){
        this.health+=health;
    }
    public int getPoints(){return points;}
    public int getUpgrade_level(){return upgrade_level;}
    public void setUpgrade_level(int level){
        upgrade_level = level;
    }
    public Audio getAudio(){return audio;}
}
