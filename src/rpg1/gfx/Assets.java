package rpg1.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    private static final  int width = 58, height =58;
    private static final  int heroWidth = 60, heroHeight =80;


    public static BufferedImage sand, player, dirt, grass, stone, tree;
    public static BufferedImage[] heroAnimationDown,heroAnimationUp,heroAnimationLeft,heroAnimationRight;


    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sheet1.png"));
        SpriteSheet HeroSheet = new SpriteSheet(ImageLoader.loadImage("/textures/heroSheet.png"));

        heroAnimationDown = new BufferedImage[2];
        heroAnimationUp = new BufferedImage[1];
        heroAnimationLeft = new BufferedImage[1];
        heroAnimationRight = new BufferedImage[1];

// TODO
        heroAnimationDown[0] = HeroSheet.crop(111,640,heroHeight,heroWidth);
        heroAnimationDown[1] = HeroSheet.crop(178,640,heroHeight ,heroWidth );

        heroAnimationUp[0] = HeroSheet.crop(heroWidth *2 ,0 ,width,heroWidth);
       // heroAnimationUp[1] = HeroSheet.crop(0,0,heroWidth,heroHeight);

        heroAnimationLeft[0] = HeroSheet.crop(0,0,heroWidth,heroHeight);
       // heroAnimationLeft[1] = HeroSheet.crop(0,0,heroWidth,heroHeight);

        heroAnimationRight[0] = HeroSheet.crop(0,0,heroWidth,heroHeight);
       // heroAnimationRight[1] = HeroSheet.crop(0,0,heroWidth,heroHeight);


        grass = sheet.crop(0,0, height,height);
        dirt = sheet.crop(0,height, width,height);
        stone  = sheet.crop(width * 2,0,width,height);
        //player = sheet.crop(width * 3,0,width,height);
        tree = sheet.crop(width * 4,0,width,height);
        sand = sheet.crop(width * 5,0,width,height);
        // TODO

    }

}
