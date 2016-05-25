package org.mqstack.gldemo.star;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by USER on 2016/1/14.
 */
public class StarOpenGLRenderer implements GLSurfaceView.Renderer {

    private Star sun = new Star();

    private Star earth = new Star();

    private Star moon = new Star();

    private int angle = 0;


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0, 0, 0, 0.5f);

        gl.glShadeModel(GL10.GL_SMOOTH);

        gl.glClearDepthf(1.0f);

        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glDepthFunc(GL10.GL_LEQUAL);

        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_PROJECTION);

        gl.glLoadIdentity();

        GLU.gluPerspective(gl, 45f, (float) width / (float) height, 0.1f, 100f);

        gl.glMatrixMode(GL10.GL_MODELVIEW);

        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        GLU.gluLookAt(gl, 0.0f, 0.0f, 15.0f,
                0.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f);

        //Start A save the current matrix
        gl.glPushMatrix();

        //Rotate Star A counter-clickwise.
        gl.glRotatef(angle, 0, 0, 1);
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);

        //Draw star A
        sun.draw(gl);

        //Restore the last matrix.
        gl.glPopMatrix();

        //Star B save the current matrix
        gl.glPushMatrix();

        //Rotate Star B before moving it, making it rotate around A.
        gl.glRotatef(-angle, 0, 0, 1);

        //Move Star B
        gl.glTranslatef(3, 0, 0);

        //Scale it to 50% of Star A
        gl.glScalef(.5f, .5f, .5f);
        gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);

        //Draw star B
        earth.draw(gl);

        //Star C, Save the current matrix
        gl.glPushMatrix();

        gl.glRotatef(-angle, 0, 0, 1);

        gl.glTranslatef(2, 0, 0);

        gl.glScalef(.5f, .5f, .5f);

        gl.glRotatef(angle * 10, 0, 0, 1);
        gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

        moon.draw(gl);

        gl.glPopMatrix();
        gl.glPopMatrix();

        angle++;

    }
}
