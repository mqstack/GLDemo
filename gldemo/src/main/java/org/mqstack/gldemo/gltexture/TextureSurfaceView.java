package org.mqstack.gldemo.gltexture;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;

import org.mqstack.gldemo.R;

/**
 * Created by mqstack on 2016/1/4.
 */
public class TextureSurfaceView extends GLSurfaceView {

    public TextureSurfaceView(Context context) {
        super(context);

        OpenGLRenderer renderer = new OpenGLRenderer();
        setRenderer(renderer);

        SimplePlane plane = new SimplePlane(1, 1);

        plane.z = 1.7f;
        plane.rx = -65;

        plane.loadBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plane));

        renderer.addMesh(plane);
    }
}
