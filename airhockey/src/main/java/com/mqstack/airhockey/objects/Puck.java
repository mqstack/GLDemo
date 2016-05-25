package com.mqstack.airhockey.objects;

import com.mqstack.airhockey.data.VertexArray;
import com.mqstack.airhockey.program.ColorShaderProgram;

import org.mqstack.airhockey.util.Geometry;

import java.util.List;

/**
 * Created by mq on 16/4/24.
 */
public class Puck {

    private static final int POSITION_COMPONENT_COUNT = 3;
    public final float radius, height;

    private final VertexArray vertexArray;
    private final List<ObjectBuilder.DrawCommand> drawList;

    public Puck(float radius, float height, int numPointsAroundPuck) {
        ObjectBuilder.GeneratedData generatedData = ObjectBuilder.createPuck(
                new Geometry.Cylinder(new Geometry.Point(0f, 0f, 0f), radius, height),
                numPointsAroundPuck);
        this.radius = radius;
        this.height = height;

        vertexArray = new VertexArray(generatedData.vertexData);
        drawList = generatedData.drawList;
    }

    public void bindData(ColorShaderProgram colorProgram){
        vertexArray.setVertexAttribPointer(0,
                colorProgram.getPositionAttributeLocation(),
                POSITION_COMPONENT_COUNT, 0);

    }

    public void draw(){
        for(ObjectBuilder.DrawCommand drawCommand: drawList){
            drawCommand.draw();
        }
    }
}
