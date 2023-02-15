package PaooGame;

import PaooGame.Audio.Audio;
import PaooGame.GameWindow.GameCamera;
import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;
import PaooGame.Graphics.SpriteSheet;
import PaooGame.KeyManager.KeyManager;
import PaooGame.MouseManager.MouseManager;
import PaooGame.State.*;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.sql.SQLException;


public class Game implements Runnable
{

    private GameWindow      wnd;
    private boolean         runState;
    private Thread          gameThread;
    private BufferStrategy  bs;
    private KeyManager      keyManager;
    private MouseManager    mouseManager;
    private Graphics        g;
    private State           gameState;
    private State           menuState;
    private State           optState;
    private State           controlState;
    private State           pauseState;
    private State           level2;
    private GameCamera      Camera;
    private int             width, hight;
    private Handler         handler;
    private Audio           audio;
    public Game(String title, int width, int height)
    {
        this.width=width;
        this.hight=height;
        wnd = new GameWindow(title, this.width, this.hight);
        keyManager=new KeyManager();
        mouseManager=new MouseManager(null);
        runState=false;
        audio=new Audio("res/textures/music/fda.wav");
        audio.play();
    }

    public KeyManager getKeyManager(){ return keyManager; }
    public GameCamera getGameCamera(){ return Camera;}
    private void InitGame()
    {
        wnd = new GameWindow("Tank Hero", 700, 700);
        wnd.BuildGameWindow();
        wnd.getFrame().addKeyListener(keyManager);
        wnd.getFrame().addMouseListener(mouseManager);
        wnd.getFrame().addMouseMotionListener(mouseManager);
        wnd.GetCanvas().addMouseListener(mouseManager);
        wnd.GetCanvas().addMouseMotionListener(mouseManager);

        Assets.Init();
        handler=new Handler(this);
        Camera=new GameCamera(handler,0,0);
        gameState=new GameState(handler);
        level2=new Level2(handler);
        menuState=new MenuState(handler);
        optState=new OptState(handler);
        controlState=new ControlState(handler);
        pauseState=new PauseState(handler);

        //  exitState=new ExitState(handler);
        State.setState(menuState);

    }
    public void run()
    {
        InitGame();
        long oldTime = System.nanoTime();
        long curentTime;
        long timer=0;
        int ticks=0;
        double delta=0;

        final int framesPerSecond   = 60;
        final double timeFrame      = 1000000000 / framesPerSecond;
        while (runState == true)
        {
            curentTime = System.nanoTime();
            delta+=(curentTime-oldTime)/timeFrame;
            timer+=curentTime-oldTime;
            oldTime=curentTime;
            if(delta>=1){
                try {
                    Update();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Draw();
                ticks++;
                delta--;
            }
            if(timer>=1000000000){
                //System.out.println("ticks: "+ ticks);
                ticks=0;
                timer=0;
            }
        }
    }

    public synchronized void StartGame()
    {
        if(runState == false)
        {
            runState = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
        else
        {
            return;
        }
    }


    public synchronized void StopGame()
    {
        if(runState == true)
        {
            runState = false;
            try
            {
                gameThread.join();
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            return;
        }
    }


    private void Update() throws SQLException {
        keyManager.Update();
        if (State.getState() != null){
            State.getState().Update();
        }

    }

    private void Draw()
    {
        bs = wnd.GetCanvas().getBufferStrategy();
        if(bs == null)
        {
            try
            {
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {

                e.printStackTrace();
            }
        }
        g = bs.getDrawGraphics();

        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());
        if (State.getState() != null){
            State.getState().Draw(g);
        }
        bs.show();
        g.dispose();
    }
    public int getWidth(){return width;}
    public int getHight(){return hight;}
    public State getGameState(){return gameState;}
    public State getOptState() {return optState;}
    public State getControlState() {return controlState;}
    public State getMenuState(){return menuState;}
    public State getPauseState(){return pauseState;}
    public State getLevel2(){return level2;}
    public MouseManager getMouseManager() {return mouseManager;}
    public Audio getAudio(){return audio;}
}