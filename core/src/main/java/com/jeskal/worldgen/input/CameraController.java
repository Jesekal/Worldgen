package com.jeskal.worldgen.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;

/*
In charge of the camera movement speed input keys
 */
public class CameraController extends InputAdapter {

    private final OrthographicCamera camera;

    private final float moveSpeed;
    private final float zoomSpeed;
    private final float minZoom;
    private final float maxZoom;

    public CameraController(OrthographicCamera camera) {
        this(camera, 300f, 0.1f, 0.5f, 4f);
    }

    public CameraController(
        OrthographicCamera camera,
        float moveSpeed,
        float zoomSpeed,
        float minZoom,
        float maxZoom
    ) {
        this.camera = camera;
        this.moveSpeed = moveSpeed;
        this.zoomSpeed = zoomSpeed;
        this.minZoom = minZoom;
        this.maxZoom = maxZoom;
    }

    public void update(float delta) {
        float speed = moveSpeed * delta * camera.zoom;

        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.position.x -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.position.x += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.position.y += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            camera.position.y -= speed;
        }
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        camera.zoom += amountY * zoomSpeed;
        camera.zoom = MathUtils.clamp(camera.zoom, minZoom, maxZoom);
        return true;
    }
}
