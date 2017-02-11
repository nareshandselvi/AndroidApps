package com.example.windows_home.andengine.andengine.opengl.shader.source;

import org.andengine.opengl.util.GLState;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 16:24:57 - 10.10.2011
 */
public interface IShaderSource {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public String getShaderSource(final GLState pGLState);
}
