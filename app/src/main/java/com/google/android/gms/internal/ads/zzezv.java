package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzezv implements zzeya {
    public zzezv(zzcay zzcayVar, zzgus zzgusVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        final j2.q qVarZza = zzgui.zza(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgt)).booleanValue()) {
            qVarZza = zzgui.zza(null);
        }
        final j2.q qVarZza2 = zzgui.zza(null);
        return zzgui.zzo(qVarZza, qVarZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzezu
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzezw((String) qVarZza.get(), (String) qVarZza2.get());
            }
        }, zzcbv.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 47;
    }
}
