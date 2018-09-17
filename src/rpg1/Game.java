package rpg1;

public class Game implements Runnable {

    private Display display;
    public int Width, Height;
    public String Title;
    private boolean running = false;
    private Thread thread;

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
