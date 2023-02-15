package PaooGame.Types;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Bullet_Types {

    public enum Bullet_Type{
        bullet_1, bullet_2, bullet_3, bullet_4, bullet_5
    }

    public static int FirePower(Bullet_Type e){
        switch (e){
            case bullet_1:
                return 2;
            case bullet_2:
                return 4;
            case bullet_3:
                return 6;
            case bullet_4:
                return 8;
            case bullet_5:
                return 10;
        }
        return 1;
    }


}

