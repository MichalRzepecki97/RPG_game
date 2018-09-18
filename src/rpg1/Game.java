package rpg1;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;
    public int Width, Height;
    public String Title;
    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;


    public Game( String Title, int Width, int Height){
        this.Height = Height;
        this.Width = Width;
        this.Title = Title;
    }

    private void init(){
        display = new Display(Title,Width,Height);
    }
    private void tick(){

    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //draw here


        bs.show();
        g.dispose();
    }
    @Override
    public void run() {
        init();

        while (running){
        tick();
        render();

        }
        stop();
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
