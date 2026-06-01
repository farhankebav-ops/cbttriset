package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgs extends zzgq {
    public final int zzc;

    public zzgs(int i2, @Nullable String str, @Nullable IOException iOException, Map map, zzgf zzgfVar, byte[] bArr) {
        super(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 15), "Response code: ", i2), iOException, zzgfVar, 2004, 1);
        this.zzc = i2;
    }
}
