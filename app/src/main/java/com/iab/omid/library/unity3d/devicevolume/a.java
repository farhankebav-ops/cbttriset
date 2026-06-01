package com.iab.omid.library.unity3d.devicevolume;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public float a(int i2, int i8) {
        if (i8 <= 0 || i2 <= 0) {
            return 0.0f;
        }
        float f4 = i2 / i8;
        if (f4 > 1.0f) {
            return 1.0f;
        }
        return f4;
    }
}
