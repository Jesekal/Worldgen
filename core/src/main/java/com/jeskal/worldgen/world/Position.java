package com.jeskal.worldgen.world;

import java.util.Objects;

public class Position implements HashPosition {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position other)) return false;
        return x == other.x && y == other.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getHash() {
        return HashPosition.getHash(this.x, this.y);
    }
}
