package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzet implements zzao {
    public final int zza;

    public zzet(int i2) {
        this.zza = i2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzet) && this.zza == ((zzet) obj).zza;
    }

    public final int hashCode() {
        return this.zza;
    }

    public final String toString() {
        int i2 = this.zza;
        return androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 19), "Mp4AlternateGroup: ", i2);
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final /* synthetic */ void zza(zzam zzamVar) {
        g.a(this, zzamVar);
    }
}
