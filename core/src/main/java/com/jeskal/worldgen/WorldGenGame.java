package com.jeskal.worldgen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.jeskal.worldgen.generation.ChunkManager;
import com.jeskal.worldgen.input.CameraController;
import com.jeskal.worldgen.render.WorldRenderer;
import com.jeskal.worldgen.world.*;

/*
The main class. WOrks in 3 parts, create (start), render (update) and dispose(close)
 */
public class WorldGenGame extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private CameraController cameraController;
    private ChunkManager myManagaer;

    private WorldRenderer worldRenderer;
    private World world;

    @Override
    public void create() {

        shapeRenderer = new ShapeRenderer();
        worldRenderer = new WorldRenderer();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        cameraController = new CameraController(camera);
        Gdx.input.setInputProcessor(cameraController);

        world = new World();
        myManagaer = new ChunkManager(world, 0);


    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        cameraController.update(delta);
        camera.update();

        ScreenUtils.clear(0, 0, 0, 1);

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        worldRenderer.render(shapeRenderer, world);
        myManagaer.update(camera);

        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
