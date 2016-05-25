package com.mqstack.airhockey.program;

import android.content.Context;
import android.opengl.GLES20;

import org.mqstack.airhockey.R;

import static android.opengl.GLES20.*;

/**
 * Created by mq on 16/4/24.
 */
public class ColorShaderProgram extends ShaderProgram {

    //Uniform locations
    private final int uMatrixLocation;

    //Attribute locations
    private final int aPositionLocation;
//    private final int aColorLocation;

    private final int uColorLocation;

    public ColorShaderProgram(Context context) {
        super(context, R.raw.simple_vertex_shader, R.raw.simple_fragment_shader);
        //Retrive uniform locations for the shader program
        uMatrixLocation = glGetUniformLocation(program, U_MATRIX);

        //Retrive attribute locations for the shader program.
        aPositionLocation = glGetAttribLocation(program, A_POSITION);
//        aColorLocation = glGetAttribLocation(program, A_COLOR);
        uColorLocation = glGetUniformLocation(program, U_COLOR);
    }

    public void setUniforms(float[] matrix, float r, float g, float b) {
        //Pass the matrix into the shader program.
        glUniformMatrix4fv(uMatrixLocation, 1, false, matrix, 0);
        glUniform4f(uColorLocation, r, g, b, 1f);
    }

    public int getPositionAttributeLocation() {
        return aPositionLocation;

    }

//    public int getColorAttributeLocation() {
//        return aColorLocation;
//    }
}
