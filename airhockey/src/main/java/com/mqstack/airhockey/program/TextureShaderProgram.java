package com.mqstack.airhockey.program;

import android.content.Context;
import android.graphics.Shader;
import android.opengl.GLES20;

import org.mqstack.airhockey.R;

import static android.opengl.GLES20.*;

/**
 * Created by mq on 16/4/23.
 */
public class TextureShaderProgram extends ShaderProgram {

    //Uniform locations
    private final int uMatrixLocation;
    private final int uTextureUnitLocation;

    //Attribute locations
    private final int aPositionLocation;
    private final int aTextureCoordinatesLocation;

    public TextureShaderProgram(Context context) {
        super(context, R.raw.texture_vertex_shader, R.raw.texture_fragment_shader);

        //Retrive uniform locations for the shader program.
        this.uMatrixLocation = glGetUniformLocation(program, U_MATRIX);
        this.uTextureUnitLocation = glGetUniformLocation(program, U_TEXTURE_UNIT);

        //Retrive attribute locations for the shader program.
        this.aPositionLocation = glGetAttribLocation(program, A_POSITION);
        this.aTextureCoordinatesLocation = glGetAttribLocation(program, A_TEXTURE_COORDINATES);
    }

    public void setUniforms(float matrix[], int textureId) {
        //Pass the matrix into the shader program.
        glUniformMatrix4fv(uMatrixLocation, 1, false, matrix, 0);

        //Set the active texture unit to texture uni 0.
        glActiveTexture(GL_TEXTURE0);

        //Bind the texture to this unit.
        glBindTexture(GL_TEXTURE_2D, textureId);

        //Tell the texture uniform sampler to use this texture int the shader
        //by telling it to read from texture uni 0.
        glUniform1i(uTextureUnitLocation, 0);
    }

    public int getPositionAttributeLocation() {
        return aPositionLocation;

    }

    public int getTextureCoordinateAttributeLocation() {
        return aTextureCoordinatesLocation;
    }


}
