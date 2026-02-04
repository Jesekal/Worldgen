package com.jeskal.worldgen.world;

public interface HashPosition {
    /*
        for debugging purposes. Reverses hashvalue
         */
    static Position fromHashValue(long hash) {
        int x = (int) (hash >> 32);
        int y = (int) hash;
        return new Position(x, y);
    }

    /* generate unique long from pos
     */
    static long getHash(int x,int y) {
        return ((long)x << 32) | (y & 0xFFFFFFFFL);
    };
}
