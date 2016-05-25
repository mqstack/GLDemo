package org.mqstack.particles.programs;

import android.content.Context;

import org.mqstack.particles.util.ShaderHelper;
import org.mqstack.particles.util.TextResourceReader;

import static android.opengl.GLES20.glUseProgram;

/**
 * Created by mq on 16/5/7.
 */
public class ShaderProgram {

    protected static final String U_TIME = "u_Time";

    protected static final String A_DIRECTION_VECTOR = "a_DirectionVector";
    protected static final String A_PARTICLE_START_TIME = "a_ParticleStartTime";


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
