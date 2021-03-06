package com.example.windows_home.andengine.andengine.entity.sprite.vbo;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.DrawType;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.opengl.vbo.attribute.VertexBufferObjectAttributes;

/**
 * (c) Zynga 2012
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 18:43:22 - 28.03.2012
 */
public class HighPerformanceDiamondSpriteVertexBufferObject extends HighPerformanceSpriteVertexBufferObject implements IDiamondSpriteVertexBufferObject {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public HighPerformanceDiamondSpriteVertexBufferObject(final VertexBufferObjectManager pVertexBufferObjectManager, final int pCapacity, final DrawType pDrawType, final boolean pAutoDispose, final VertexBufferObjectAttributes pVertexBufferObjectAttributes) {
		super(pVertexBufferObjectManager, pCapacity, pDrawType, pAutoDispose, pVertexBufferObjectAttributes);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public void onUpdateVertices(final Sprite pSprite) {
		final float[] bufferData = this.mBufferData;

		final float x = 0;
		final float y = 0;
		final float x2 = pSprite.getWidth(); // TODO Optimize with field access?
		final float y2 = pSprite.getHeight(); // TODO Optimize with field access?

		final float xCenter = (x + x2) * 0.5f;
		final float yCenter = (y + y2) * 0.5f;

		bufferData[0 * Sprite.VERTEX_SIZE + Sprite.VERTEX_INDEX_X] = x;
		bufferData[0 * Sprite.VERTEX_SIZE + Sprite.VERTEX_INDEX_Y] = yCenter;

		bufferData[1 * Sprite.VERTEX_SIZE + Sprite.VERTEX_INDEX_X] = xCenter;
		bufferData[1 * Sprite.VERTEX_SIZE + Sprite.VERTEX_INDEX_Y] = y2;

		bufferData[2 * Sprite.VERTEX_SIZE + Sprite.VERTEX_INDEX_X] = xCenter;
		bufferData[2 * Sprite.VERTEX_SIZE + Sprite.VERTEX_INDEX_Y] = y;

		bufferData[3 * Sprite.VERTEX_SIZE + Sprite.VERTEX_INDEX_X] = x2;
		bufferData[3 * Sprite.VERTEX_SIZE + Sprite.VERTEX_INDEX_Y] = yCenter;

		this.setDirtyOnHardware();
	}

	@Override
	public void onUpdateTextureCoordinates(final Sprite pSprite) {
		final float[] bufferData = this.mBufferData;

		final ITextureRegion textureRegion = pSprite.getTextureRegion();

		final float u;
		final float v;
		final float u2;
		final float v2;

		if(pSprite.isFlippedVertical()) { // TODO Optimize with field access?
			if(pSprite.isFlippedHorizontal()) { // TODO Optimize with field access?
				u = textureRegion.getU2();
				u2 = textureRegion.getU();
				v = textureRegion.getV2();
				v2 = textureRegion.getV();
			} else {
				u = textureRegion.getU();
				u2 = textureRegion.getU2();
				v = textureRegion.getV2();
				v2 = textureRegion.getV();
			}
		} else {
			if(pSprite.isFlippedHorizontal()) { // TODO Optimize with field access?
				u = textureRegion.getU2();
				u2 = textureRegion.getU();
				v = textureRegion.getV();
				v2 = textureRegion.getV2();
			} else {
				u = textureRegion.getU();
				u2 = textureRegion.getU2();
				v = textureRegion.getV();
				v2 = textureRegion.getV2();
			}
		}

		final float uCenter = (u + u2) * 0.5f;
		final float vCenter = (v + v2) * 0.5f;

		if(textureRegion.isRotated()) {
			bufferData[0 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_U] = uCenter;
			bufferData[0 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_V] = v;

			bufferData[1 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_U] = u;
			bufferData[1 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_V] = vCenter;

			bufferData[2 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_U] = u2;
			bufferData[2 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_V] = vCenter;

			bufferData[3 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_U] = uCenter;
			bufferData[3 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_V] = v2;
		} else {
			bufferData[0 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_U] = u;
			bufferData[0 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_V] = vCenter;

			bufferData[1 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_U] = uCenter;
			bufferData[1 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_V] = v2;

			bufferData[2 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_U] = uCenter;
			bufferData[2 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_V] = v;

			bufferData[3 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_U] = u2;
			bufferData[3 * Sprite.VERTEX_SIZE + Sprite.TEXTURECOORDINATES_INDEX_V] = vCenter;
		}

		this.setDirtyOnHardware();
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}