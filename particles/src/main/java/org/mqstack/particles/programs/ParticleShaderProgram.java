package org.mqstack.particles.programs;

import android.content.Context;

import org.mqstack.particles.R;

import static android.opengl.GLES20.*;

/**
 * Created by mq on 16/5/7.
 */
public class ParticleShaderProgram extends ShaderProgram {

    //Uniform locations
    private final int uMatrixLocation;
    private final int uTimeLocation;

    //Attribute locations
    private final int aPositionLocation;
    private final int aColorLocation;
    private final int aDirectionVectorLocation;
    private final int aParticlesStartTimeLocation;

    private final int uTextureUnitLocation;

    public ParticleShaderProgram(Context context) {

        super(context, R.raw.particle_vertex_shader, R.raw.particle_fragment_shader);

        //Retrieve uniform locations for the shader program
        uMatrixLocation = glGetUniformLocation(program, U_MATRIX);
        uTimeLocation = glGetUniformLocation(program, U_TIME);

        //Retrieve attribute locations for the shader program.
        aPositionLocation = glGetAttribLocation(program, A_POSITION);
        aColorLocation = glGetAttribLocation(program, A_COLOR);
        aDirectionVectorLocation = glGetAttribLocation(program, A_DIRECTION_VECTOR);
        aParticlesStartTimeLocation = glGetAttribLocation(program, A_PARTICLE_START_TIME);
        uTextureUnitLocation = glGetUniformLocation(program, U_TEXTURE_UNIT);

    }

    public void setUniforms(float[] matrix, float elapsedTime, int textureId) {
        glUniformMatrix4fv(uMatrixLocation, 1, false, matrix, 0);
        glUniform1f(uTimeLocation, elapsedTime);

        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, textureId);
        glUniform1i(uTextureUnitLocation, 0);
    }

    public int getPositionAttributeLocation() {
        return aPositionLocation;
    }

    public int getColorAttributeLocation() {
        return aColorLocation;
    }

    public int getDirectionVectorAttributeLocation() {
        return aDirectionVectorLocation;
    }

    public int getParticleStartTimeAttributeLocation() {
        return aParticlesStartTimeLocation;
    }
}
