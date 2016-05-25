package org.mqstack.gldemo.gl3d;

/**
 * Created by mqstack on 2015/12/23.
 */
public class Cube extends Mesh {

    public Cube(float width, float height, float depth) {
        width /= 2;
        height /= 2;
        depth /= 2;

        float vertices[] = {-width, -height, -depth, // 0
                width, -height, -depth, // 1
                width, height, -depth, // 2
                -width, height, -depth, // 3
                -width, -height, depth, // 4
                width, -height, depth, // 5
                width, height, depth, // 6
                -width, height, depth, // 7
        };

        short indices[] = {0, 4, 5,
                0, 5, 1,
                1, 5, 6,
                1, 6, 2,
                2, 6, 7,
                2, 7, 3,
                3, 7, 4,
                3, 4, 0,
                4, 7, 6,
                4, 6, 5,
                3, 0, 1,
                3, 1, 2,};

        float[] colors = {
                1f, 0f, 0f, 1f,
                0f, 1f, 0f, 1f,
                0f, 0f, 1f, 1f,
                1f, 0f, 1f, 1f,
        };

        setIndices(indices);
        setVertices(vertices);
        setColor(0, 1, 1, 1);
        setColors(colors);
    }
}
