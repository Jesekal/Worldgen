package com.jeskal.worldgen.world;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
World is responisble for storing all (loaded) chunks.
 */
public class World implements HashPosition{
    private final Map<Long, Chunk> chunks = new HashMap<>();
    public void addChunk(int chunkX, int chunkY, Chunk chunk) {
        chunks.put(chunk.hashValue(), chunk);
    }

    public Chunk getChunk(int chunkX, int chunkY) {
        return chunks.get(HashPosition.getHash(chunkX, chunkY));
    }

    public boolean hasChunk(int x, int y) {
        return chunks.containsKey(HashPosition.getHash(x, y));
    }

    public void removeChunk(int chunkX, int chunkY) {
        chunks.remove(HashPosition.getHash(chunkX, chunkY));
    }

    public Collection<Chunk> getChunks() {
        return chunks.values();
    }



//    private Dimension key(int x, int y) {
//        return new Dimension(x, y);
//    }
}
