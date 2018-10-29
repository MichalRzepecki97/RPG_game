package rpg1.gfx;

import java.awt.image.BufferedImage;

public class Animation {
    private int idx,speed;
    private BufferedImage[]frames;
    private long timer, lastTime;

    public Animation(int speed,BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        idx = 0;
        timer = 0;
        lastTime = System.currentTimeMillis(); //check

    }
    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer>speed){
            idx++;
            timer = 0;
            if (idx>=frames.length)
                idx = 0;
        }
    }

    public BufferedImage CurrentFrame(){
        return frames[idx];
    }
}
