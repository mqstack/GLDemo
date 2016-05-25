package org.mqstack.gldemo.gltexture;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by mqstack on 2015/12/31.
 */
public class OpenGLRenderer implements GLSurfaceView.Renderer {

    private final Group root;

    public OpenGLRenderer() {
        root = new Group();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //set the background black
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        //Enable smooth shading, default not really needed
        gl.glShadeModel(GL10.GL_SMOOTH);

        //Depth buffer setup
        gl.glClearDepthf(1.0f);

        //Enable depth testing
        gl.glEnable(GL10.GL_DEPTH_TEST);

        //The type of depth testing to do
        gl.glDepthFunc(GL10.GL_LEQUAL);

        //Really nice perspective calculations.
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        //Sets the current view port to the new size
        gl.glViewport(0, 0, width, height);

        //Select the projection matrix
        gl.glMatrixMode(GL10.GL_PROJECTION);

        //Reset the projection matrix
        gl.glLoadIdentity();

        //Calculate the aspect ratio of the window
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 1000.0f);

        //Select the modelview matrix
        gl.glMatrixMode(GL10.GL_MODELVIEW);

        //Reset the modelview matrix
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //Clears the screen and depth buffer
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        //Replace the current matrix with the identity matrix
        gl.glLoadIdentity();

        //Translates 4 units into the screen
        gl.glTranslatef(0, 0, -4);

        //Draw our scene
        root.draw(gl);
    }

    /**
     * adds a mesh to the root
     *
     * @param mesh
     */
    public void addMesh(Mesh mesh) {
        root.add(mesh);
    }

}
