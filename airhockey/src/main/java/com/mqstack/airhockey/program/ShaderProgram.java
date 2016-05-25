package com.mqstack.airhockey.program;

import android.content.Context;
import android.opengl.GLES20;

import org.mqstack.airhockey.util.ShaderHelper;
import org.mqstack.airhockey.util.TextResourceReader;

import static android.opengl.GLES20.*;

/**
 * Created by mq on 16/4/23.
 */
public class ShaderProgram {

    //uniform constants
    protected static final String U_MATRIX = "u_Matrix";
    protected static final String U_TEXTURE_UNIT = "u_TextureUnit";

    //Attribute constants
    protected static final String A_POSITION = "a_Position";
    protected static final String A_COLOR = "a_Color";
    protected static final String A_TEXTURE_COORDINATES = "a_TextureCoordinates";

    protected static final String U_COLOR = "u_Color";


    //Shader Program
    protected final int program;

    protected ShaderProgram(Context context, int vertexShaderResourceId, int fragmentShaderResourceId) {
        //Compile the shaders and link the program
        program = ShaderHelper.buildProgram(TextResourceReader.readTextFileFromResource(context, vertexShaderResourceId),
                TextResourceReader.readTextFileFromResource(context, fragmentShaderResourceId));


    }

    public void useProgram() {

        //Set the current OpenGL shader program to this program.
        glUseProgram(program);
    }

}
