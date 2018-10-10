package rpg1.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    private static final  int width = 58, height =58;

    public static BufferedImage sand, player, dirt, grass, stone, tree;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet1.png"));

        grass = sheet.crop(0,0, height,height);
        dirt = sheet.crop(0,height, width,height);
        stone  = sheet.crop(width * 2,0,width,height);
        player = sheet.crop(width * 3,0,width,height);
        tree = sheet.crop(width * 4,0,width,height);
        sand = sheet.crop(width * 5,0,width,height);
    }
}
