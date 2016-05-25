package org.mqstack.gldemo.gltexture;

import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by mqstack on 2015/12/31.
 */
public class Group extends Mesh {
    private final Vector<Mesh> mChildren = new Vector<>();

    @Override
    public void draw(GL10 gl) {
        int size = mChildren.size();
        for (int i = 0; i < size; i++) {
            mChildren.get(i).draw(gl);
        }
    }

    public void add(int location, Mesh mesh) {
        mChildren.add(location, mesh);
    }

    public boolean add(Mesh mesh) {
        return mChildren.add(mesh);
    }

    public void clear() {
        mChildren.clear();
    }

    public Mesh get(int location) {
        return mChildren.get(location);
    }

    public Mesh remove(int location) {
        return mChildren.remove(location);
    }

    public boolean remove(Mesh mesh) {
        return mChildren.remove(mesh);
    }

    public int size() {
        return mChildren.size();
    }
}
