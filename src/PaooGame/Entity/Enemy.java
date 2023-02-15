package PaooGame.Entity;


import PaooGame.Bullet.Bullet;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;
import PaooGame.Item.Item;
import PaooGame.Types.Bullet_Types;
import PaooGame.Types.Current_Direction;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Enemy extends Creature {
    protected long lastMoveTimer, moveCoolDown = 2000, moveTimer = moveCoolDown;
    protected long lastAttackTimer, attackCooldown = 600, attackTimer = attackCooldown;
    private Current_Direction current_direction;
    private BufferedImage currentimage;
    private int tipbullet=0;
    private int tipenemy=0;
    private boolean enemy_fire = true;
    private int firepower;
    public Enemy(Handler handler, float x, float y, int width, int height, int tipenemy) {
        super(handler, x, y, width, height);
        speed = 2;
        bounds.x = 5;
        bounds.y = 5;
        bounds.height = 55;
        bounds.width = 55;
        active = true;
        this.tipenemy=tipenemy;

    }

    @Override
    public void die() {
        super.die();
        Random rand = new Random();
        int n = rand.nextInt(100);
        if (n < 15) {
            handler.getWorld().getItemManager().addItem(new Item(handler, (int) x, (int) y, 1));
        } else if (n < 30) {
            handler.getWorld().getItemManager().addItem(new Item(handler, (int) x, (int) y, 2));
        } else if (n < 40) {
            handler.getWorld().getItemManager().addItem(new Item(handler, (int) x, (int) y, 3));
        }
    }



    public void Update() {

        for (Bullet b : handler.getWorld().getBulletManager().getBullets()) {
            if (b.equals(this)) {
                continue;
            }
            if (b.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(bounds.x, bounds.y))) {
                // b.setActive(true);
                health = health - b.getFirepower();
                if (health <= 0) {
                    active = false;
                    die();
                }
            }
        }
        getInput();
        move();
    }

    private void getInput(){

        Random rand = new Random();
        int n = rand.nextInt(2);
        if (n == 0){
            checkAttacks();
        }

        moveTimer += System.currentTimeMillis() - lastMoveTimer;
        lastMoveTimer = System.currentTimeMillis();
        if (moveTimer < moveCoolDown){
            return;
        }
        xMove = 0;
        yMove = 0;


        n = rand.nextInt(110);
        if (n < 25) {
            yMove = -speed;
            current_direction = Current_Direction.up;
            tipbullet=1;
            if(tipenemy==1)
                currentimage=Assets.tank_1[0];
            if(tipenemy==2)
                currentimage=Assets.tank_2[0];
            if(tipenemy==3)
                currentimage=Assets.tank_3[0];
            if(tipenemy==4)
                currentimage=Assets.tank_4[0];
            if(tipenemy==5)
                currentimage=Assets.tank_5[0];
            //currentimage= Assets.tank_2[0];
        }else
        if (n < 50) {
            yMove = speed;
            tipbullet=2;
            current_direction = Current_Direction.down;
            if(tipenemy==1)
                currentimage=Assets.tank_1[2];
            if(tipenemy==2)
                currentimage=Assets.tank_2[2];
            if(tipenemy==3)
                currentimage=Assets.tank_3[2];
            if(tipenemy==4)
                currentimage=Assets.tank_4[2];
            if(tipenemy==5)
                currentimage=Assets.tank_5[2];

        } else
        if (n < 75) {
            xMove = -speed;
            tipbullet=3;
            current_direction = Current_Direction.left;
            if(tipenemy==1)
                currentimage=Assets.tank_1[3];
            if(tipenemy==2)
                currentimage=Assets.tank_2[3];
            if(tipenemy==3)
                currentimage=Assets.tank_3[3];
            if(tipenemy==4)
                currentimage=Assets.tank_4[3];
            if(tipenemy==5)
                currentimage=Assets.tank_5[3];
        } else
        if (n < 100) {
            xMove = speed;
            tipbullet=4;
            current_direction = Current_Direction.right;
            if(tipenemy==1)
                currentimage=Assets.tank_1[1];
            if(tipenemy==2)
                currentimage=Assets.tank_2[1];
            if(tipenemy==3)
                currentimage=Assets.tank_3[1];
            if(tipenemy==4)
                currentimage=Assets.tank_4[1];
            if(tipenemy==5)
                currentimage=Assets.tank_5[1];
        }
        else if (n < 110){
            xMove = 0;
            yMove = 0;
        }
        moveTimer = 0;
    }

    @Override
    public void Draw(Graphics g) {
        drawHealth(g);
        g.drawImage(currentimage, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
    protected void checkAttacks(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown) {
            return;
        }
        if(current_direction==Current_Direction.up) {
            handler.getWorld().getBulletManager().addBullet(new Bullet(x, y, handler, current_direction,tipbullet));
        }
        if(current_direction==Current_Direction.down){
            handler.getWorld().getBulletManager().addBullet(new Bullet(x, y, handler, current_direction,tipbullet));
        }
        if(current_direction==Current_Direction.left){
            handler.getWorld().getBulletManager().addBullet(new Bullet(x, y, handler, current_direction,tipbullet));
        }
        if(current_direction==Current_Direction.right){
           handler.getWorld().getBulletManager().addBullet(new Bullet(x, y, handler, current_direction,tipbullet));
        }
        attackTimer=0;
    }
    protected void drawHealth(Graphics g){
        Font fnt1 = new Font("arial", Font.BOLD, 15);
        String text = Integer.toString(health);
        int text_width = g.getFontMetrics().stringWidth(text);
        g.setColor(Color.red);
        g.setFont(fnt1);
        g.drawString(text, (int) (x - handler.getGameCamera().getxOffset() + bounds.x + bounds.width/2 - text_width/2), (int) (y - handler.getGameCamera().getyOffset()));
    }

}
