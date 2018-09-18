package rpg1;

import rpg1.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    public int Width, Height;
    public String Title;
    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage test;
    private SpriteSheet sheet;



    public Game( String Title, int Width, int Height){
        this.Height = Height;
        this.Width = Width;
        this.Title = Title;
    }

    private void init(){
        display = new Display(Title,Width,Height);
        //test = ImageLoader.loadImage("/textures/nazwa");
        sheet = new SpriteSheet(test);
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
        //Clear screen
        g.clearRect(0,0,Width,Height);
        //draw
        g.drawImage(sheet.crop(0,0,32,32),5,5,null);



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
