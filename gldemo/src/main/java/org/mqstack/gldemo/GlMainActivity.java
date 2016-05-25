package org.mqstack.gldemo;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.mqstack.gldemo.gl2d.MyGLSurfaceView;
import org.mqstack.gldemo.gl3d.CubeSurfaceView;
import org.mqstack.gldemo.gltexture.TextureSurfaceView;
import org.mqstack.gldemo.point.OpenGLRenderer;
import org.mqstack.gldemo.sphere.SphereOpenGLRenderer;
import org.mqstack.gldemo.star.StarOpenGLRenderer;

public class GlMainActivity extends AppCompatActivity {

    private GLSurfaceView mGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGLView = new GLSurfaceView(this);
        mGLView.setRenderer(new SphereOpenGLRenderer());
//        mGLView = new MyGLSurfaceView(this);
//        mGLView = new CubeSurfaceView(this);
//        mGLView = new TextureSurfaceView(this);

        setContentView(mGLView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
