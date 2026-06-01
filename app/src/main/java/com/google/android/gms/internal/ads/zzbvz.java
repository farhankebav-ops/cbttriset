package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbvz {
    private static zzcas zze;
    private final Context zza;
    private final AdFormat zzb;

    @Nullable
    private final com.google.android.gms.ads.internal.client.zzek zzc;

    @Nullable
    private final String zzd;

    public zzbvz(Context context, AdFormat adFormat, @Nullable com.google.android.gms.ads.internal.client.zzek zzekVar, @Nullable String str) {
        this.zza = context;
        this.zzb = adFormat;
        this.zzc = zzekVar;
        this.zzd = str;
    }

    @Nullable
    public static zzcas zza(Context context) {
        zzcas zzcasVar;
        synchronized (zzbvz.class) {
            try {
                if (zze == null) {
                    zze = com.google.android.gms.ads.internal.client.zzbb.zzb().zzj(context, new zzbrf());
                }
                zzcasVar = zze;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzcasVar;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        com.google.android.gms.ads.internal.client.zzm zzmVarZza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context context = this.zza;
        zzcas zzcasVarZza = zza(context);
        if (zzcasVarZza == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(context);
        com.google.android.gms.ads.internal.client.zzek zzekVar = this.zzc;
        if (zzekVar == null) {
            com.google.android.gms.ads.internal.client.zzn zznVar = new com.google.android.gms.ads.internal.client.zzn();
            zznVar.zzi(jCurrentTimeMillis);
            zzmVarZza = zznVar.zza();
        } else {
            zzekVar.zzp(jCurrentTimeMillis);
            zzmVarZza = com.google.android.gms.ads.internal.client.zzq.zza.zza(context, zzekVar);
        }
        try {
            zzcasVarZza.zze(iObjectWrapperWrap, new zzcaw(this.zzd, this.zzb.name(), null, zzmVarZza, 0, null), new zzbvy(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
