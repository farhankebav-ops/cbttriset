package com.google.android.gms.common;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzv {
    private String zza = null;

    @Nullable
    private Boolean zzb = null;

    @Nullable
    private Boolean zzc = null;

    private zzv() {
    }

    public final zzv zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzv zzb(boolean z2) {
        this.zzb = Boolean.valueOf(z2);
        return this;
    }

    public final zzv zzc(boolean z2) {
        this.zzc = Boolean.valueOf(z2);
        return this;
    }

    public final zzw zzd() {
        Boolean bool = this.zzb;
        if (bool == null) {
            throw new IllegalStateException("allowTestKeys must be set");
        }
        if (this.zzc != null) {
            return new zzw(this.zza, bool.booleanValue(), false, false, this.zzc.booleanValue(), false, null);
        }
        throw new IllegalStateException("isGoogleOrPlatformOnly must be set");
    }

    public /* synthetic */ zzv(byte[] bArr) {
    }
}
