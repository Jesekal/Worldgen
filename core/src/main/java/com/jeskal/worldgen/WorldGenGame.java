package com.jeskal.worldgen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.jeskal.worldgen.world.Tile;
import com.jeskal.worldgen.world.Tiletype;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class WorldGenGame extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private Tile testTile;

    private static final int TILE_SIZE = 32;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        testTile = new Tile(Tiletype.GRASS);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);



        if (testTile.getType() == Tiletype.GRASS) {
            shapeRenderer.setColor(0, 0.8f, 0, 1);
        }


        shapeRenderer.rect(100, 100, TILE_SIZE, TILE_SIZE);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
