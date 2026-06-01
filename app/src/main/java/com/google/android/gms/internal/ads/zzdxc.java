package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdxc implements zzdwr {
    private final long zza;
    private final zzepb zzb;

    public zzdxc(long j, Context context, zzdwv zzdwvVar, zzcjn zzcjnVar, String str) {
        this.zza = j;
        zzfea zzfeaVarZzn = zzcjnVar.zzn();
        zzfeaVarZzn.zzd(context);
        zzfeaVarZzn.zzb(new com.google.android.gms.ads.internal.client.zzr());
        zzfeaVarZzn.zzc(str);
        zzepb zzepbVarZza = zzfeaVarZzn.zza().zza();
        this.zzb = zzepbVarZza;
        zzepbVarZza.zzdW(new zzdxb(this, zzdwvVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zzb.zze(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zzb() {
        this.zzb.zzR(ObjectWrapper.wrap(null));
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zzc() {
        this.zzb.zzc();
    }

    public final /* synthetic */ long zzd() {
        return this.zza;
    }
}
