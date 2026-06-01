package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgfi extends RuntimeException {
    public zzgfi() {
        this(0);
    }

    public zzgfi(int i2) {
        super(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 3), "r: ", i2));
    }

    public zzgfi(int i2, Throwable th) {
        super("r: 2", th);
    }
}
