package com.jeskal.worldgen.render;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jeskal.worldgen.world.Chunk;
import com.jeskal.worldgen.world.Tile;

/*
Tells the shaperenderer how to render a chunk
 */
public class ChunkRenderer {
    private final TileRenderer tileRenderer;

    public ChunkRenderer() {
        this.tileRenderer = new TileRenderer();
    }

    public void render(ShapeRenderer renderer, Chunk chunk, int chunkWorldX, int chunkWorldY) {
        for (int x = 0; x < Chunk.WIDTH; x++) {
            for (int y = 0; y < Chunk.WIDTH; y++) {

                Tile tile = chunk.getTile(x, y);
                if (tile == null) continue;

                int worldX = chunkWorldX + x * Tile.size;
                int worldY = chunkWorldY + y * Tile.size;

                tileRenderer.render(renderer, tile, worldX, worldY);
            }
        }
    }
}
