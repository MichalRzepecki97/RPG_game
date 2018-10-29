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
        heroAnimationUp = new BufferedImage[2];
        heroAnimationLeft = new BufferedImage[8];
        heroAnimationRight = new BufferedImage[8];

// TODO
        heroAnimationDown[0] = HeroSheet.crop(111,640,heroHeight,heroWidth);
        heroAnimationDown[1] = HeroSheet.crop(178,640,heroHeight ,heroWidth );

        heroAnimationUp[0] = HeroSheet.crop(111,520 ,heroHeight,heroWidth);
        heroAnimationUp[1] = HeroSheet.crop(304,520 ,heroHeight,heroWidth);

        heroAnimationLeft[0] = HeroSheet.crop(60,580,heroHeight,heroWidth);
        heroAnimationLeft[1] = HeroSheet.crop(120,580,heroHeight,heroWidth);
        heroAnimationLeft[2] = HeroSheet.crop(180,580,heroHeight,heroWidth);
        heroAnimationLeft[3] = HeroSheet.crop(240,580,heroHeight,heroWidth);
        heroAnimationLeft[4] = HeroSheet.crop(310,580,heroHeight,heroWidth);
        heroAnimationLeft[5] = HeroSheet.crop(380,580,heroHeight,heroWidth);
        heroAnimationLeft[6] = HeroSheet.crop(440,580,heroHeight,heroWidth);
        heroAnimationLeft[7] = HeroSheet.crop(500,580,heroHeight,heroWidth);

        heroAnimationRight[0] = HeroSheet.crop(60,710,heroHeight,heroWidth);
        heroAnimationRight[1] = HeroSheet.crop(120,710,heroHeight,heroWidth);
        heroAnimationRight[2] = HeroSheet.crop(180,710,heroHeight,heroWidth);
        heroAnimationRight[3] = HeroSheet.crop(240,710,heroHeight,heroWidth);
        heroAnimationRight[4] = HeroSheet.crop(310,710,heroHeight,heroWidth);
        heroAnimationRight[5] = HeroSheet.crop(380,710,heroHeight,heroWidth);
        heroAnimationRight[6] = HeroSheet.crop(440,710,heroHeight,heroWidth);
        heroAnimationRight[7] = HeroSheet.crop(500,710,heroHeight,heroWidth);

        grass = sheet.crop(0,0, height,height);
        dirt = sheet.crop(0,height, width,height);
        stone  = sheet.crop(width * 2,0,width,height);
        //player = sheet.crop(width * 3,0,width,height);
        tree = sheet.crop(width * 4,0,width,height);
        sand = sheet.crop(width * 5,0,width,height);
        // TODO

    }

}
