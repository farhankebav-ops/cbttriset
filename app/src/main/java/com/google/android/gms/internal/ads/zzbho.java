package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbho {
    private final Context zza;

    public zzbho(Context context) {
        this.zza = context;
    }

    public final void zza(zzbwl zzbwlVar) {
        try {
            ((zzbhp) com.google.android.gms.ads.internal.util.client.zzs.zza(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", zzbhn.zza)).zze(zzbwlVar);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(e.getMessage())));
        } catch (com.google.android.gms.ads.internal.util.client.zzr e4) {
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(e4.getMessage())));
        }
    }
}
