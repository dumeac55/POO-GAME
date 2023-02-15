package PaooGame.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Assets
{
    private static final int width = 64, height = 64;

    public static BufferedImage soil, grass, tree, water, mountain, townGrass, townGrassDestroyed;
    public static BufferedImage ice_chest, tree_chest, purple_chest;
    public static BufferedImage heart,points;
    public static BufferedImage Menu, Setings, Pause, Controls,WinState;

    public static BufferedImage[] bullet_1, bullet_2, bullet_3, bullet_4, bullet_5;
    public static BufferedImage[] tank_1, tank_2, tank_3, tank_4,tank_5,tank_6;
    public static BufferedImage[] bullet_explosion_animation;
    protected BufferedImage[ ] a;
    public static void Init()
    {

        SpriteSheet explosion_sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/bullets/explosion.png"));

        Menu= ImageLoader.LoadImage("/textures/meniu_principal.PNG");
        Setings=ImageLoader.LoadImage("/textures/meniu_optiuni.PNG");
        Controls=ImageLoader.LoadImage("/textures/meniu_controale.PNG");
        Pause=ImageLoader.LoadImage("/textures/meniu_pauza.PNG");

        soil = ImageLoader.LoadImage("/textures/soil.png");
        tree = ImageLoader.LoadImage("/textures/tree.png");
        water = ImageLoader.LoadImage("/textures/water.png");
        grass = ImageLoader.LoadImage("/textures/grass.png");
        townGrass = ImageLoader.LoadImage("/textures/townGrass.png");
        townGrassDestroyed = ImageLoader.LoadImage("/textures/townGrassDestroyed.png");
        mountain = ImageLoader.LoadImage("/textures/mountain.png");

        ice_chest = ImageLoader.LoadImage("/textures/chests/ice_chest.png");
        tree_chest = ImageLoader.LoadImage("/textures/chests/tree_chest.png");
        purple_chest = ImageLoader.LoadImage("/textures/chests/purple_chest.png");

        heart=ImageLoader.LoadImage("/textures/heart.png");
        points=ImageLoader.LoadImage("/textures/coin.png");

        WinState=ImageLoader.LoadImage("/textures/you_win.jpg");
        tank_1 = new BufferedImage[4];
        tank_1[0] = ImageLoader.LoadImage("/textures/tanks/1-up.png");
        tank_1[1] = ImageLoader.LoadImage("/textures/tanks/1-right.png");
        tank_1[2] = ImageLoader.LoadImage("/textures/tanks/1-down.png");
        tank_1[3] = ImageLoader.LoadImage("/textures/tanks/1-left.png");

        tank_2 = new BufferedImage[4];
        tank_2[0] = ImageLoader.LoadImage("/textures/tanks/2-up.png");
        tank_2[1] = ImageLoader.LoadImage("/textures/tanks/2-right.png");
        tank_2[2] = ImageLoader.LoadImage("/textures/tanks/2-down.png");
        tank_2[3] = ImageLoader.LoadImage("/textures/tanks/2-left.png");

        tank_3 = new BufferedImage[4];
        tank_3[0] = ImageLoader.LoadImage("/textures/tanks/3-up.png");
        tank_3[1] = ImageLoader.LoadImage("/textures/tanks/3-right.png");
        tank_3[2] = ImageLoader.LoadImage("/textures/tanks/3-down.png");
        tank_3[3] = ImageLoader.LoadImage("/textures/tanks/3-left.png");

        tank_4 = new BufferedImage[4];
        tank_4[0] = ImageLoader.LoadImage("/textures/tanks/4-up.png");
        tank_4[1] = ImageLoader.LoadImage("/textures/tanks/4-right.png");
        tank_4[2] = ImageLoader.LoadImage("/textures/tanks/4-down.png");
        tank_4[3] = ImageLoader.LoadImage("/textures/tanks/4-left.png");

        tank_5 = new BufferedImage[4];
        tank_5[0] = ImageLoader.LoadImage("/textures/tanks/5-up.png");
        tank_5[1] = ImageLoader.LoadImage("/textures/tanks/5-right.png");
        tank_5[2] = ImageLoader.LoadImage("/textures/tanks/5-down.png");
        tank_5[3] = ImageLoader.LoadImage("/textures/tanks/5-left.png");

        tank_6 = new BufferedImage[4];
        tank_6[0] = ImageLoader.LoadImage("/textures/tanks/6-up.png");
        tank_6[1] = ImageLoader.LoadImage("/textures/tanks/6-right.png");
        tank_6[2] = ImageLoader.LoadImage("/textures/tanks/6-down.png");
        tank_6[3] = ImageLoader.LoadImage("/textures/tanks/6-left.png");

        bullet_1 = new BufferedImage[4];
        bullet_1[0] = ImageLoader.LoadImage("/textures/bullets/bullet1/1-up.png");
        bullet_1[1] = ImageLoader.LoadImage("/textures/bullets/bullet1/1-right.png");
        bullet_1[2] = ImageLoader.LoadImage("/textures/bullets/bullet1/1-down.png");
        bullet_1[3] = ImageLoader.LoadImage("/textures/bullets/bullet1/1-left.png");

        bullet_2 = new BufferedImage[4];
        bullet_2[0] = ImageLoader.LoadImage("/textures/bullets/bullet2/2-up.png");
        bullet_2[1] = ImageLoader.LoadImage("/textures/bullets/bullet2/2-right.png");
        bullet_2[2] = ImageLoader.LoadImage("/textures/bullets/bullet2/2-down.png");
        bullet_2[3] = ImageLoader.LoadImage("/textures/bullets/bullet2/2-left.png");

        bullet_3 = new BufferedImage[4];
        bullet_3[0] = ImageLoader.LoadImage("/textures/bullets/bullet3/3-up.png");
        bullet_3[1] = ImageLoader.LoadImage("/textures/bullets/bullet3/3-right.png");
        bullet_3[2] = ImageLoader.LoadImage("/textures/bullets/bullet3/3-down.png");
        bullet_3[3] = ImageLoader.LoadImage("/textures/bullets/bullet3/3-left.png");

        bullet_4 = new BufferedImage[4];
        bullet_4[0] = ImageLoader.LoadImage("/textures/bullets/bullet4/4-up.png");
        bullet_4[1] = ImageLoader.LoadImage("/textures/bullets/bullet4/4-right.png");
        bullet_4[2] = ImageLoader.LoadImage("/textures/bullets/bullet4/4-down.png");
        bullet_4[3] = ImageLoader.LoadImage("/textures/bullets/bullet4/4-left.png");

        bullet_5 = new BufferedImage[4];
        bullet_5[0] = ImageLoader.LoadImage("/textures/bullets/bullet5/5-up.png");
        bullet_5[1] = ImageLoader.LoadImage("/textures/bullets/bullet5/5-rigth.png");
        bullet_5[2] = ImageLoader.LoadImage("/textures/bullets/bullet5/5-down.png");
        bullet_5[3] = ImageLoader.LoadImage("/textures/bullets/bullet5/5-left.png");

        bullet_explosion_animation = new BufferedImage[16];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                bullet_explosion_animation[4*i+j] = explosion_sheet.crop(i,j);
            }
        }
    }
}
