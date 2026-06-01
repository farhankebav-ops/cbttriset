package com.unity3d.ads.gl;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OffscreenSurface extends EglSurfaceBase {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OffscreenSurface(EglCore eglCore, int i2, int i8) {
        super(eglCore);
        k.e(eglCore, "eglCore");
        createOffscreenSurface(i2, i8);
    }

    public final void release() {
        releaseEglSurface();
    }
}
