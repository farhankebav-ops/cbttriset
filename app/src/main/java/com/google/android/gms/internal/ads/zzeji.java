package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeji implements zzdjl {
    private final zzffu zza;
    private final zzbti zzb;
    private final AdFormat zzc;

    @Nullable
    private zzczg zzd = null;

    public zzeji(zzffu zzffuVar, zzbti zzbtiVar, AdFormat adFormat) {
        this.zza = zzffuVar;
        this.zzb = zzbtiVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final void zza(boolean z2, Context context, @Nullable zzczb zzczbVar) throws zzdjk {
        boolean zZzk;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int iOrdinal = this.zzc.ordinal();
            if (iOrdinal == 1) {
                zZzk = this.zzb.zzk(ObjectWrapper.wrap(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 5) {
                        zZzk = this.zzb.zzt(ObjectWrapper.wrap(context));
                    }
                    throw new zzdjk("Adapter failed to show.");
                }
                zZzk = this.zzb.zzm(ObjectWrapper.wrap(context));
            }
            if (zZzk) {
                zzczg zzczgVar = this.zzd;
                if (zzczgVar == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbN)).booleanValue() || this.zza.zzY != 2) {
                    return;
                }
                zzczgVar.zza();
                return;
            }
            throw new zzdjk("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdjk(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    @Nullable
    public final zzffu zzb() {
        return this.zza;
    }

    public final void zzc(zzczg zzczgVar) {
        this.zzd = zzczgVar;
    }
}
