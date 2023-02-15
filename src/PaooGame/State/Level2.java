package PaooGame.State;
import PaooGame.Entity.Player;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;
import PaooGame.Utils.PlayerBar;
import PaooGame.Word.Word;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Level2 extends State {
    private Player player;
    private Word world;
    private PlayerBar playerBar;
    private BufferedImage currentimage;
    public Level2(Handler handler){
        super(handler);
       // world=new Word(handler,"res/textures/World/world2.txt",2);
        world=handler.getGame().getGameState().handler.getWorld();
        if(handler.getGame().getGameState().getflag()==1) {
            handler.setWorld(world);
        }
      //  player=new Player(handler,450,450);
        player=handler.getGame().getGameState().getPlayer();
        playerBar=handler.getGame().getGameState().getPlayerBar();
        handler.getGameCamera().move(0,0);
    }
    @Override
    public void Update() {
        // if(handler.getGame().getGameState().getflag()==1) {
        world.Update();
        player.Update();
        playerBar.Update();
        if (handler.getKeyManager().esc) {
            State.setState(handler.getGame().getPauseState());
        }
        if (handler.getWorld().getEntityManager().getCounter() == 0) {
            currentimage = Assets.WinState;
        }

    }
    @Override
    public void Draw(Graphics g) {
        world.Draw(g);
        player.Draw(g);
        playerBar.Draw(g);
        if (handler.getWorld().getEntityManager().getCounter() == 0) {
            g.drawImage(currentimage, 0, 0, 700, 700, null);
        }
    }

}
