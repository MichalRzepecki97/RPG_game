package rpg1.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet (BufferedImage sheet){
        this.sheet = sheet;

    }
    public BufferedImage crop(int x, int y, int Width, int Height){
        return sheet .getSubimage(x,y,Width,Height);

    }
}
