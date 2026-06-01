package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbcv {
    private com.google.android.gms.ads.internal.client.zzbx zza;
    private final Context zzb;
    private final String zzc;
    private final com.google.android.gms.ads.internal.client.zzek zzd;
    private final AppOpenAd.AppOpenAdLoadCallback zze;
    private final zzbrf zzf = new zzbrf();
    private final com.google.android.gms.ads.internal.client.zzq zzg = com.google.android.gms.ads.internal.client.zzq.zza;

    public zzbcv(Context context, String str, com.google.android.gms.ads.internal.client.zzek zzekVar, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzekVar;
        this.zze = appOpenAdLoadCallback;
    }

    public final void zza() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.google.android.gms.ads.internal.client.zzr zzrVarZzd = com.google.android.gms.ads.internal.client.zzr.zzd();
            com.google.android.gms.ads.internal.client.zzaz zzazVarZzb = com.google.android.gms.ads.internal.client.zzbb.zzb();
            Context context = this.zzb;
            String str = this.zzc;
            com.google.android.gms.ads.internal.client.zzbx zzbxVarZza = zzazVarZzb.zza(context, zzrVarZzd, str, this.zzf);
            this.zza = zzbxVarZza;
            if (zzbxVarZza != null) {
                com.google.android.gms.ads.internal.client.zzek zzekVar = this.zzd;
                zzekVar.zzp(jCurrentTimeMillis);
                this.zza.zzJ(new zzbci(this.zze, str));
                this.zza.zze(this.zzg.zza(context, zzekVar));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
