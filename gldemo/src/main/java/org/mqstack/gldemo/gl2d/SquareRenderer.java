package org.mqstack.gldemo.gl2d;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import org.mqstack.gldemo.gl2d.ColoredSquare;
import org.mqstack.gldemo.gl2d.Square;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by mqstack on 2015/12/18.
 */
public class SquareRenderer implements GLSurfaceView.Renderer {

    private Square square;

    private int angle;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        square = new ColoredSquare();

        // Set the background color to black ( rgba ).
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);

        // Enable Smooth Shading, default not really needed.
        gl.glShadeModel(GL10.GL_SMOOTH);

        // Depth buffer setup.
        gl.glClearDepthf(1.0f);

        // Enables depth testing.
        gl.glEnable(GL10.GL_DEPTH_TEST);

        // The type of depth testing to do.
        gl.glDepthFunc(GL10.GL_LEQUAL);

        // Really nice perspective calculations.
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Sets the current view port to the new size.
        gl.glViewport(0, 0, width, height);

        // Select the projection matrix
        gl.glMatrixMode(GL10.GL_PROJECTION);

        // Reset the projection matrix
        gl.glLoadIdentity();

        // Calculate the aspect ratio of the window
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100.0f);

        // Select the modelview matrix
        gl.glMatrixMode(GL10.GL_MODELVIEW);

        // Reset the modelview matrix
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // Clears the screen and depth buffer.
        drawTranslate(gl);
    }

    private void drawSquare(GL10 gl){
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();

        gl.glTranslatef(0, 0, -3);

        square.draw(gl);
    }

    private void drawTranslate(GL10 gl){
        //clears the screen and depth buffer
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        //replace the current matrix with the identity matrix
        gl.glLoadIdentity();

        //translates 10 units into the screen
        gl.glTranslatef(0, 0, -10);

        //square a
        //save the current matrix
        gl.glPushMatrix();

        //rotate square a counter-clockwise
        gl.glRotatef(angle, 0, 0, 1);
        //draw square a
        square.draw(gl);

        //restore the last matrix
        gl.glPopMatrix();

        //square b
        //save the current matrix
        gl.glPushMatrix();
        //rotate square b before moving it
        //making it rotate around a
        gl.glRotatef(-angle, 0, 0, 1);

        //move square b
        gl.glTranslatef(2, 0, 0);

        //sccale it to 50% of square a
        gl.glScalef(.5f, .5f, .5f);

        gl.glRotatef(-angle, 0, 0, 1);
        //draw square b
        square.draw(gl);

        //square c
        //save the current matrix
        gl.glPushMatrix();
        //make the rotation around b
        gl.glRotatef(angle, 0, 0, 1);
        gl.glTranslatef(2, 0, 0);
        //sccale it to 50% of square a
        gl.glScalef(.5f, .5f, .5f);

        gl.glRotatef(angle, 0, 0, 1);
        square.draw(gl);

        gl.glPopMatrix();
        gl.glPopMatrix();
        angle++;
    }
}
