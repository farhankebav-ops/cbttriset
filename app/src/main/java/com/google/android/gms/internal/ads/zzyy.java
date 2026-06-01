package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyy {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzyz zzyzVar) {
        zzb(zzyzVar);
        this.zza.add(new zzyx(handler, zzyzVar));
    }

    public final void zzb(zzyz zzyzVar) {
        CopyOnWriteArrayList<zzyx> copyOnWriteArrayList = this.zza;
        for (zzyx zzyxVar : copyOnWriteArrayList) {
            if (zzyxVar.zzc() == zzyzVar) {
                zzyxVar.zza();
                copyOnWriteArrayList.remove(zzyxVar);
            }
        }
    }

    public final void zzc(final int i2, final long j, final long j3) {
        for (final zzyx zzyxVar : this.zza) {
            if (!zzyxVar.zzd()) {
                zzyxVar.zzb().post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzyw
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzyxVar.zzc().zzX(i2, j, j3);
                    }
                });
            }
        }
    }
}
