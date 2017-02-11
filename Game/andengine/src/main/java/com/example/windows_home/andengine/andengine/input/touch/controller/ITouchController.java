package com.example.windows_home.andengine.andengine.input.touch.controller;

import android.view.MotionEvent;

import org.andengine.engine.handler.IUpdateHandler;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 20:23:45 - 13.07.2010
 */
public interface ITouchController extends IUpdateHandler {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public void setTouchEventCallback(final ITouchEventCallback pTouchEventCallback);

	public void onHandleMotionEvent(final MotionEvent pMotionEvent);

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
