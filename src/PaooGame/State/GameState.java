package PaooGame.State;
import PaooGame.Entity.Enemy;
import PaooGame.Entity.Player;
import PaooGame.Graphics.Handler;
import PaooGame.Utils.PlayerBar;
import PaooGame.Word.Word;
import java.awt.*;

public class GameState extends State {
    private Player player;
    private Word world;
    private PlayerBar playerBar;
    private int flag;
    public GameState(Handler handler){
        super(handler);
        world=new Word(handler,"res/textures/World/world1.txt",1);
        handler.setWorld(world);
        player=new Player(handler,450,450);
       // enemy=new Enemy(handler,300,300,64,64,5);
        handler.getGameCamera().move(0,0);
        this.playerBar=new PlayerBar(handler);
        flag=0;
    }
    @Override
    public void Update(){
        world.Update();
        player.Update();
        playerBar.Update();
        if(handler.getKeyManager().esc){
            State.setState(handler.getGame().getPauseState());
        }
        if(handler.getWorld().getEntityManager().getCounter()==3){
            State.setState(handler.getGame().getLevel2());
            flag=1;
        }
      //  enemy.Update();
    }
    @Override
    public void Draw(Graphics g){
        world.Draw(g);
        player.Draw(g);
        playerBar.Draw(g);
       // enemy.Draw(g);
    }
    public Word getWorld(){return world;}
    public Player getPlayer(){return player;}
    public int getFlag(){return flag;}
    public PlayerBar getPlayerBar() {
        return playerBar;
    }
}
