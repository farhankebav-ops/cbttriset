package com.unity3d.ads.gl;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class EglSurfaceBase {
    private EGLSurface mEGLSurface;
    private EglCore mEglCore;
    private int mHeight;
    private int mWidth;

    public EglSurfaceBase(EglCore eglCore) {
        k.e(eglCore, "eglCore");
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mEglCore = eglCore;
    }

    public final void createOffscreenSurface(int i2, int i8) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.mEglCore.createOffscreenSurface(i2, i8);
        this.mWidth = i2;
        this.mHeight = i8;
    }

    public final void makeCurrent() {
        this.mEglCore.makeCurrent(this.mEGLSurface);
    }

    public final void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }
}
