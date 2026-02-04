package com.jeskal.worldgen.world;

public class Chunk {
    public static final int WIDTH = 8;
    private final Tile[][] tiles;
    private Position pos;

    public Chunk(int x, int y) {
        this.pos = new Position(x,y);
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

    public Position getChunkPos() {
        return this.pos;
    }

    public long hashValue(){
        return this.pos.getHash();
    }

}
