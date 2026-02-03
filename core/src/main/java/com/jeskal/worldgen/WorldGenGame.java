package com.jeskal.worldgen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.jeskal.worldgen.render.ChunkRenderer;
import com.jeskal.worldgen.render.TileRenderer;
import com.jeskal.worldgen.world.Chunk;
import com.jeskal.worldgen.world.Tile;
import com.jeskal.worldgen.world.Tiletype;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class WorldGenGame extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private TileRenderer tileRenderer;
    private Tile testTile;
    private ChunkRenderer chunkRenderer;
    private Chunk testChunk;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        chunkRenderer = new ChunkRenderer();

        testChunk = new Chunk();

        for (int x = 0; x < Chunk.WIDTH; x++) {
            for (int y = 0; y < Chunk.WIDTH; y++) {
                int sum = x + y;

                if(sum % 2 == 0) {
                    testChunk.setTile(x, y, new Tile(Tiletype.GRASS));
                }
                else {
                    testChunk.setTile(x, y, new Tile(Tiletype.WATER));
                }

            }
        }
    }
    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        chunkRenderer.render(shapeRenderer, testChunk, 100, 100);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
