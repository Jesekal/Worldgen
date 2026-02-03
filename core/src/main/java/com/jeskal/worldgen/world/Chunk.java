package com.jeskal.worldgen.world;

import java.util.ArrayList;
import java.util.List;

public class Chunk {
    public static final int WIDTH = 8;
    private final Tile[][] tiles;
    public Chunk() {
        tiles = new Tile[WIDTH][WIDTH];
    }
    public void setTile(int x, int y, Tile tile) {
        if (!inBounds(x, y)) {
            throw new IndexOutOfBoundsException("Tile position out of bounds");
        }
        tiles[x][y] = tile;
    }

    public Tile getTile(int x, int y) {
        if (!inBounds(x, y)) {
            throw new IndexOutOfBoundsException("Tile position out of bounds");
        }
        return tiles[x][y];
    }

    private boolean inBounds(int x, int y) {
        return x >= 0 && x < WIDTH && y >= 0 && y < WIDTH;
    }
}
