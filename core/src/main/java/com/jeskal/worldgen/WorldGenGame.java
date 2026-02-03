package com.jeskal.worldgen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.jeskal.worldgen.render.TileRenderer;
import com.jeskal.worldgen.world.Tile;
import com.jeskal.worldgen.world.Tiletype;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class WorldGenGame extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private TileRenderer tileRenderer;
    private Tile testTile;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        tileRenderer = new TileRenderer();

        testTile = new Tile(Tiletype.GRASS);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        tileRenderer.render(shapeRenderer, testTile, 100, 100);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
