package org.mqstack.gldemo.gl2d;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

/**
 * Created by USER on 2015/8/8.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    private final TriangleGLRenderer mRenderer;

    private final SquareRenderer sRenderer;

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;


    public MyGLSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context
//        setEGLContextClientVersion(1);

        mRenderer = new TriangleGLRenderer();

        sRenderer = new SquareRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(sRenderer);

//        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - mPreviousX;
                float dy = y - mPreviousY;

                //reserve direction of rotation above the mid-line
                if (y < getHeight() / 2) {
                    dx = dx * -1;
                }

                // reverse direction of rotation to left of the mid-line
                if (x > getWidth() / 2) {
                    dy = dy * -1 ;
                }


                mRenderer.setAngle(mRenderer.getAngle() + ((dx + dy) * TOUCH_SCALE_FACTOR));
                requestRender();
        }

        mPreviousX = x;
        mPreviousY = y;

        return true;
    }
}
