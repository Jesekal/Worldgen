package com.jeskal.worldgen.world;

import java.util.Objects;

public class ChunkPos {
    public final int x;
    public final int y;

    public ChunkPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChunkPos other)) return false;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
