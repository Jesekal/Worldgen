package com.jeskal.worldgen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class WorldGenGame extends ApplicationAdapter {
    private ShapeRenderer shape;

    @Override
    public void create() {
        shape = new ShapeRenderer();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.rect(100, 100, 50, 50);
        shape.end();
    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}
