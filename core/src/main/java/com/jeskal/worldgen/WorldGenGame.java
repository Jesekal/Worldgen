package com.jeskal.worldgen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.jeskal.worldgen.render.ChunkRenderer;
import com.jeskal.worldgen.render.TileRenderer;
import com.jeskal.worldgen.world.Chunk;
import com.jeskal.worldgen.world.Tile;
import com.jeskal.worldgen.world.Tiletype;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class WorldGenGame extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private TileRenderer tileRenderer;
    private Tile testTile;
    private ChunkRenderer chunkRenderer;
    private Chunk testChunk;
    private OrthographicCamera camera;

    private static final float CAMERA_SPEED = 300f;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        chunkRenderer = new ChunkRenderer();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        camera.update();

        testChunk = new Chunk();

        for (int x = 0; x < Chunk.WIDTH; x++) {
            for (int y = 0; y < Chunk.WIDTH; y++) {
                int sum = x + y;

                if(sum % 2 == 0) {
                    testChunk.setTile(x, y, new Tile(Tiletype.GRASS));
                }
                else {
                    testChunk.setTile(x, y, new Tile(Tiletype.WATER));
                }

            }
        }
    }
    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        handleInput(delta);
        camera.update();
        ScreenUtils.clear(0, 0, 0, 1);
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        chunkRenderer.render(shapeRenderer, testChunk, 100, 100);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    private void handleInput(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.position.x -= CAMERA_SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.position.x += CAMERA_SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.position.y += CAMERA_SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            camera.position.y -= CAMERA_SPEED * delta;
        }
    }
}
