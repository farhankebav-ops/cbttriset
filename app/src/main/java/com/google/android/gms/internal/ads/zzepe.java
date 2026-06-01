package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzepe {
    private final zzepj zza;
    private final String zzb;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzea zzc;

    public zzepe(zzepj zzepjVar, String str) {
        this.zza = zzepjVar;
        this.zzb = str;
    }

    public final synchronized boolean zza() throws RemoteException {
        return this.zza.zzb();
    }

    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, int i2) throws RemoteException {
        this.zzc = null;
        zzepk zzepkVar = new zzepk(i2);
        zzepd zzepdVar = new zzepd(this);
        this.zza.zza(zzmVar, this.zzb, zzepkVar, zzepdVar);
    }

    @Nullable
    public final synchronized String zzc() {
        com.google.android.gms.ads.internal.client.zzea zzeaVar;
        try {
            zzeaVar = this.zzc;
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return zzeaVar != null ? zzeaVar.zze() : null;
    }

    @Nullable
    public final synchronized String zzd() {
        com.google.android.gms.ads.internal.client.zzea zzeaVar;
        try {
            zzeaVar = this.zzc;
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return zzeaVar != null ? zzeaVar.zze() : null;
    }

    public final /* synthetic */ void zze(com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        this.zzc = zzeaVar;
    }
}
