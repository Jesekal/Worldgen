package com.jeskal.worldgen.world;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class World implements HashPosition{
    private final Map<Long, Chunk> chunks = new HashMap<>();
    public void addChunk(int chunkX, int chunkY, Chunk chunk) {
        chunks.put(chunk.hashValue(), chunk);
    }

    public Chunk getChunk(int chunkX, int chunkY) {
        return chunks.get(HashPosition.getHash(chunkX, chunkY));
    }

    public Map<Long, Chunk> getChunks() {
        return chunks;
    }

//    private Dimension key(int x, int y) {
//        return new Dimension(x, y);
//    }
}
