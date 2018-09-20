package rpg1.tiles;

import rpg1.gfx.Assets;

public class RockTile extends Tile {

    public RockTile( int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
