package com.google.mlkit.vision.common;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PointF3D {
    @NonNull
    public static PointF3D from(float f4, float f8, float f9) {
        return new zza(f4, f8, f9);
    }

    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();
}
