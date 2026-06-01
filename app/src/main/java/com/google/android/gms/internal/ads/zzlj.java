package com.google.android.gms.internal.ads;

import android.os.Looper;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlj {
    private final zzli zza;
    private final zzlh zzb;
    private final zzbf zzc;
    private int zzd;

    @Nullable
    private Object zze;
    private final Looper zzf;
    private final int zzg;
    private boolean zzh;
    private boolean zzi;

    public zzlj(zzlh zzlhVar, zzli zzliVar, zzbf zzbfVar, int i2, zzdc zzdcVar, Looper looper) {
        this.zzb = zzlhVar;
        this.zza = zzliVar;
        this.zzc = zzbfVar;
        this.zzf = looper;
        this.zzg = i2;
    }

    public final zzli zza() {
        return this.zza;
    }

    public final zzlj zzb(int i2) {
        zzgmd.zzh(!this.zzh);
        this.zzd = i2;
        return this;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzlj zzd(@Nullable Object obj) {
        zzgmd.zzh(!this.zzh);
        this.zze = obj;
        return this;
    }

    @Nullable
    public final Object zze() {
        return this.zze;
    }

    public final Looper zzf() {
        return this.zzf;
    }

    public final zzlj zzg() {
        zzgmd.zzh(!this.zzh);
        this.zzh = true;
        this.zzb.zzk(this);
        return this;
    }

    public final synchronized boolean zzh() {
        return false;
    }

    public final synchronized void zzi(boolean z2) {
        this.zzi = z2 | this.zzi;
        notifyAll();
    }
}
