package com.jeskal.worldgen.render;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jeskal.worldgen.world.Chunk;
import com.jeskal.worldgen.world.Tile;
import com.jeskal.worldgen.world.World;

/*
Responsible handling rendering for world
 */
public class WorldRenderer {
    private final ChunkRenderer chunkRenderer;

    public WorldRenderer() {
        this.chunkRenderer = new ChunkRenderer();
    }

    public void render(ShapeRenderer shapeRenderer, World world) {

        for (Chunk chunk : world.getChunks()) {

            int worldX = chunk.getChunkPos().getX()* Chunk.WIDTH * Tile.size;

            int worldY = chunk.getChunkPos().getY() * Chunk.WIDTH * Tile.size;

            chunkRenderer.render(shapeRenderer, chunk, worldX, worldY);
        }
    }
}
