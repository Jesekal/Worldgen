package com.jeskal.worldgen.render;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jeskal.worldgen.world.Tile;
import com.jeskal.worldgen.world.Tiletype;


public class TileRenderer {

    public static final int TILE_SIZE = 32;

    public void render(ShapeRenderer shapeRenderer, Tile tile, int x, int y) {
        if(tile.getType() == Tiletype.GRASS) {
            shapeRenderer.setColor(0, 0.8f, 0, 1);
        } else if (tile.getType() == Tiletype.WATER) {
            shapeRenderer.setColor(0, 0, 0.8f, 1);
        }



        shapeRenderer.rect(x, y, TILE_SIZE, TILE_SIZE);
    }


}

