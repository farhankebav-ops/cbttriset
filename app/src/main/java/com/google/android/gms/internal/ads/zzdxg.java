package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdxg implements zzdwr {
    private final long zza;
    private final zzdwv zzb;
    private final zzffl zzc;

    public zzdxg(long j, Context context, zzdwv zzdwvVar, zzcjn zzcjnVar, String str) {
        this.zza = j;
        this.zzb = zzdwvVar;
        zzffn zzffnVarZzq = zzcjnVar.zzq();
        zzffnVarZzq.zzc(context);
        zzffnVarZzq.zzb(str);
        this.zzc = zzffnVarZzq.zza().zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        try {
            this.zzc.zzc(zzmVar, new zzdxe(this));
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zzb() {
        try {
            zzffl zzfflVar = this.zzc;
            zzfflVar.zze(new zzdxf(this));
            zzfflVar.zzb(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final /* synthetic */ long zzd() {
        return this.zza;
    }

    public final /* synthetic */ zzdwv zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zzc() {
    }
}
