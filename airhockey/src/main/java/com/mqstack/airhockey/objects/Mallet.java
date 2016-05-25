package com.mqstack.airhockey.objects;

import android.opengl.GLES20;

import com.mqstack.airhockey.data.VertexArray;
import com.mqstack.airhockey.program.ColorShaderProgram;

import org.mqstack.airhockey.util.Constant;
import org.mqstack.airhockey.util.Geometry;

import java.util.List;

import static android.opengl.GLES20.*;

/**
 * Created by mq on 16/4/24.
 */
public class Mallet {

    private static final int POSITION_COMPONENT_COUNT = 3;

    //    private static final int COLOR_COMPONENT_COUNT = 3;
//
//    private static final int STRIDE =
//            (POSITION_COMPONENT_COUNT + COLOR_COMPONENT_COUNT)
//                    * Constant.BYTES_PER_FLOAT;
//
//    private static final float[] VERTEX_DATA = {
//            //Order of coordinates: X, Y, R, G, B
//            0f, -0.4f, 0f, 0f, 1f,
//            0f, 0.4f, 1f, 0f, 0f
//    };
//
//    private final VertexArray vertexArray;
    public final float radius;
    public final float height;

    private final VertexArray vertexArray;
    private final List<ObjectBuilder.DrawCommand> drawList;

    public Mallet(float radius, float height, int numPointAroundMallet) {
        ObjectBuilder.GeneratedData generatedData = ObjectBuilder.createMallet(
                new Geometry.Point(0f, 0f, 0f), radius, height, numPointAroundMallet
        );

        this.radius = radius;
        this.height = height;

        vertexArray = new VertexArray(generatedData.vertexData);
        drawList = generatedData.drawList;
    }

    public void bindData(ColorShaderProgram colorProgram) {
        vertexArray.setVertexAttribPointer(
                0,
                colorProgram.getPositionAttributeLocation(),
                POSITION_COMPONENT_COUNT,
                0
        );

//        vertexArray.setVertexAttribPointer(
//                POSITION_COMPONENT_COUNT,
//                colorProgram.getColorAttributeLocation(),
//                COLOR_COMPONENT_COUNT,
//                STRIDE
//        );
    }

    public void draw() {
        for (ObjectBuilder.DrawCommand drawCommand : drawList) {
            drawCommand.draw();
        }
//        glDrawArrays(GL_POINTS, 0, 2);
    }
}
