package com.google.android.gms.internal.ads;

import androidx.annotation.CallSuper;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzhc {
    private int zza;

    @CallSuper
    public void zza() {
        this.zza = 0;
    }

    public final boolean zzb() {
        return zzi(4);
    }

    public final boolean zzc() {
        return zzi(1);
    }

    public final boolean zzd() {
        return zzi(536870912);
    }

    public final boolean zze() {
        return zzi(268435456);
    }

    public final boolean zzf() {
        return zzi(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }

    public final void zzg(int i2) {
        this.zza = i2;
    }

    public final void zzh(int i2) {
        this.zza |= 536870912;
    }

    public final boolean zzi(int i2) {
        return (this.zza & i2) == i2;
    }
}
