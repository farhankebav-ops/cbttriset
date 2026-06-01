package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcxx {
    private final Context zza;
    private final zzfgn zzb;
    private final Bundle zzc;

    @Nullable
    private final zzfgg zzd;

    @Nullable
    private final zzcxp zze;

    @Nullable
    private final zzehp zzf;
    private final int zzg;

    public /* synthetic */ zzcxx(zzcxw zzcxwVar, byte[] bArr) {
        this.zza = zzcxwVar.zzi();
        this.zzb = zzcxwVar.zzj();
        this.zzc = zzcxwVar.zzk();
        this.zzd = zzcxwVar.zzl();
        this.zze = zzcxwVar.zzm();
        this.zzf = zzcxwVar.zzn();
        this.zzg = zzcxwVar.zzo();
    }

    public final zzcxw zza() {
        zzcxw zzcxwVar = new zzcxw();
        zzcxwVar.zza(this.zza);
        zzcxwVar.zzb(this.zzb);
        zzcxwVar.zzc(this.zzc);
        zzcxwVar.zzd(this.zze);
        zzcxwVar.zzg(this.zzf);
        return zzcxwVar;
    }

    public final zzfgn zzb() {
        return this.zzb;
    }

    @Nullable
    public final zzfgg zzc() {
        return this.zzd;
    }

    @Nullable
    public final Bundle zzd() {
        return this.zzc;
    }

    @Nullable
    public final zzcxp zze() {
        return this.zze;
    }

    public final Context zzf(Context context) {
        return this.zza;
    }

    public final zzehp zzg(String str) {
        zzehp zzehpVar = this.zzf;
        return zzehpVar != null ? zzehpVar : new zzehp(str);
    }

    public final int zzh() {
        return this.zzg;
    }
}
