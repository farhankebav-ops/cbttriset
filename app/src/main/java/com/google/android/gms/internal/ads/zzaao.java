package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaao {
    private final Context zza;
    private final zzaba zzb;
    private zzbs zzc;
    private boolean zzd;
    private boolean zzf;
    private long zzg = 15000;
    private final zzabb zzh = new zzabb(1.0f);
    private zzdc zze = zzdc.zza;

    public zzaao(Context context, zzaba zzabaVar) {
        this.zza = context.getApplicationContext();
        this.zzb = zzabaVar;
    }

    public final zzaao zza(boolean z2) {
        this.zzd = true;
        return this;
    }

    public final zzaao zzb(zzdc zzdcVar) {
        this.zze = zzdcVar;
        return this;
    }

    public final zzaao zzc(long j) {
        this.zzg = j;
        return this;
    }

    public final zzaaw zzd() {
        zzgmd.zzh(!this.zzf);
        if (this.zzc == null) {
            this.zzc = new zzaau(false);
        }
        zzaaw zzaawVar = new zzaaw(this, null);
        this.zzf = true;
        return zzaawVar;
    }

    public final /* synthetic */ Context zze() {
        return this.zza;
    }

    public final /* synthetic */ zzaba zzf() {
        return this.zzb;
    }

    public final /* synthetic */ zzbs zzg() {
        return this.zzc;
    }

    public final /* synthetic */ boolean zzh() {
        return this.zzd;
    }

    public final /* synthetic */ zzdc zzi() {
        return this.zze;
    }

    public final /* synthetic */ long zzj() {
        return this.zzg;
    }

    public final /* synthetic */ zzabb zzk() {
        return this.zzh;
    }
}
