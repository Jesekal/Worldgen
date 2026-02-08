package com.jeskal.worldgen.generation;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.jeskal.worldgen.world.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
Loads and unload chunks dynamically
 */
public class ChunkManager {
    private final World world;
    private final int loadRadius;

    public ChunkManager(World world, int loadRadius) {
        this.world = world;
        this.loadRadius = loadRadius;
    }

    public void update(OrthographicCamera camera) {
        ChunkRange range = getVisibleChunkRange(camera);

        Set<Position> visible = new HashSet<>();


        for (int cx = range.minX - loadRadius; cx <= range.maxX + loadRadius; cx++) {
            for (int cy = range.minY - loadRadius; cy <= range.maxY + loadRadius; cy++) {
                visible.add(new Position(cx, cy));

                if (!world.hasChunk(cx, cy)) {

                    world.addChunk(cx, cy, generateChunk(cx, cy));
                }
            }
        }
        //Remove all chunks not visible to the camera
        List<Position> toRemove = new ArrayList<>();
        for (Chunk chunk : world.getChunks()) {
            if(!visible.contains(chunk.getChunkPos())) {
                toRemove.add(chunk.getChunkPos());
            }
        }

        for (Position p : toRemove) {
            world.removeChunk(p.getX(), p.getY());
        }
    }

    private Chunk generateChunk(int cx, int cy) {
        Chunk chunk = new Chunk(cx, cy);

        for (int x = 0; x < Chunk.WIDTH; x++) {
            for (int y = 0; y < Chunk.WIDTH; y++) {
                if(x == 0 || y == 0) {
                    chunk.setTile(x, y, new Tile(Tiletype.GRASS));
                }
                else {
                    chunk.setTile(x, y, new Tile(Tiletype.WATER));
                }

            }
        }
        return chunk;
    }

    private ChunkRange getVisibleChunkRange(OrthographicCamera camera) {
        float viewWidth = camera.viewportWidth * camera.zoom;
        float viewHeight = camera.viewportHeight * camera.zoom;

        float left = camera.position.x - viewWidth / 2f;
        float right = camera.position.x + viewWidth / 2f;
        float bottom = camera.position.y - viewHeight / 2f;
        float top = camera.position.y + viewHeight / 2f;

        int minChunkX = MathUtils.floor(left / Chunk.CHUNKSIZE);
        int maxChunkX = MathUtils.floor(right / Chunk.CHUNKSIZE);
        int minChunkY = MathUtils.floor(bottom / Chunk.CHUNKSIZE);
        int maxChunkY = MathUtils.floor(top / Chunk.CHUNKSIZE);

        return new ChunkRange(minChunkX, maxChunkX, minChunkY, maxChunkY);
    }
}
