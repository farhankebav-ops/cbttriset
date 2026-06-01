package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdxv implements zzdfw {
    private final Bundle zza = new Bundle();

    @VisibleForTesting
    public zzdxv() {
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final synchronized void zza(String str) {
        this.zza.putInt(str, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final synchronized void zzb(String str) {
        this.zza.putInt(str, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final synchronized void zzc(String str, String str2) {
        this.zza.putInt(str, 3);
    }

    public final synchronized Bundle zzg() {
        return new Bundle(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final void zzd(String str) {
    }
}
