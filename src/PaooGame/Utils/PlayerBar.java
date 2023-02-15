package PaooGame.Utils;



import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;
import PaooGame.State.State;

import java.awt.*;



public class PlayerBar extends State {
    protected int player_health, points;

    public PlayerBar(Handler handler){
        super(handler);
    }

    @Override
    public void Update() {
        this.points=handler.getGame().getGameState().getPlayer().getPoints();
       this.player_health = handler.getGame().getGameState().getPlayer().getHealth();
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.heart, 10, 10, 32, 32, null);
        g.drawImage(Assets.points,90,10,32,32,null);
        Font fnt1 = new Font("arial", Font.BOLD, 20);
        g.setFont(fnt1);
        g.setColor(Color.white);
        g.drawString(Integer.toString(player_health), 40, 33);
        g.drawString(Integer.toString(points), 120, 33);
    }
}
