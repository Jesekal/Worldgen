package com.jeskal.worldgen.world;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class World {
    private final Map<Dimension, Chunk> chunks = new HashMap<>();
    public void addChunk(int chunkX, int chunkY, Chunk chunk) {
        chunks.put(key(chunkX, chunkY), chunk);
    }

    public Chunk getChunk(int chunkX, int chunkY) {
        return chunks.get(key(chunkX, chunkY));
    }

    public Map<Dimension, Chunk> getChunks() {
        return chunks;
    }

    private Dimension key(int x, int y) {
        return new Dimension(x, y);
    }
}
