package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzezf implements zzeya {
    private final Executor zza;
    private final String zzb;

    public zzezf(zzcbb zzcbbVar, Executor executor, String str, @Nullable PackageInfo packageInfo, int i2) {
        this.zza = executor;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        j2.q qVarZza = zzgui.zza(this.zzb);
        zzeze zzezeVar = zzeze.zza;
        Executor executor = this.zza;
        return zzgui.zzh(zzgui.zzk(qVarZza, zzezeVar, executor), Throwable.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzezd
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzc((Throwable) obj);
            }
        }, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 41;
    }

    public final /* synthetic */ j2.q zzc(Throwable th) {
        return zzgui.zza(new zzezg(this.zzb));
    }
}
