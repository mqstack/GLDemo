package org.mqstack.gldemo.gl3d;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by USER on 2015/12/23.
 */
public class CubeSurfaceView extends GLSurfaceView {

    public CubeSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context
//        setEGLContextClientVersion(1);

        CubeRenderer renderer = new CubeRenderer();
        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(renderer);

//        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
