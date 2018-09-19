package rpg1;

import rpg1.controls.KeyMenager;
import rpg1.gfx.Assets;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Game implements Runnable {

    private Display display;
    public int Width, Height;
    public String Title;
    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;
    //states
    private State gameState;
    private State menuState;
    private KeyMenager keyMenager;
    private Object KeyMenager;


    public Game( String Title, int Width, int Height){
        this.Height = Height;
        this.Width = Width;
        this.Title = Title;
        keyMenager = new KeyMenager();
    }

    private void init(){
        display = new Display(Title,Width,Height);
        display.getFrame().addKeyListener(keyMenager);
        Assets.init();

        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);
    }
    private void tick(){
        if (State.getState() != null )
            State.getState().tick();
    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0,0,Width,Height);
        //draw

        if (State.getState() != null )
            State.getState().render(g);

        bs.show();
        g.dispose();
    }
    @Override
    public void run() {
        init();
//ograniczenie klatek na sekunde
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lasteTime = System.nanoTime();
        long timer = 0;
        int ticks =0;


        while (running){
            now = System.nanoTime();
            delta += (now -lasteTime) / timePerTick;
            timer +=now -lasteTime;
            lasteTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta --;
                //koniec klatek
            }
            if(timer >= 1000000000){
                System.out.println("fps: " +ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }
    
    public KeyMenager getKeyMenager(){
        return (rpg1.controls.KeyMenager) KeyMenager;
    }
    
    public synchronized void start(){
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if (!running)
        running = false;
        try {
            thread.join();
        }catch (InterruptedException e){
            //TODO
            e.printStackTrace();
        }

    }
}
