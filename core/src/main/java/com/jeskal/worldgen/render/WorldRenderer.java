package com.jeskal.worldgen.render;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jeskal.worldgen.world.Chunk;
import com.jeskal.worldgen.world.World;

public class WorldRenderer {
    private final ChunkRenderer chunkRenderer;

    public WorldRenderer() {
        this.chunkRenderer = new ChunkRenderer();
    }

    public void render(ShapeRenderer shapeRenderer, World world) {

        for (Chunk chunk : world.getChunks().values()) {

            int worldX = chunk.getChunkPos().getX()* Chunk.WIDTH * TileRenderer.TILE_SIZE;

            int worldY = chunk.getChunkPos().getY() * Chunk.WIDTH * TileRenderer.TILE_SIZE;

            chunkRenderer.render(shapeRenderer, chunk, worldX, worldY);
        }
    }
}
