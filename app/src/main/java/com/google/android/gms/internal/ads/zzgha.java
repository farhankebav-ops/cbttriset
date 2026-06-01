package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgha implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;
    private final zzifq zzc;

    private zzgha(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
        this.zzc = zzifqVar3;
    }

    public static zzgha zza(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        return new zzgha(zzifqVar, zzifqVar2, zzifqVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        File file = (File) this.zza.zzb();
        zzfzi zzfziVar = (zzfzi) this.zzb.zzb();
        final zzgjd zzgjdVar = (zzgjd) this.zzc.zzb();
        return zzfziVar.zza(file, zzgaa.zze(), new Function() { // from class: com.google.android.gms.internal.ads.zzggz
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzgjdVar.zzd(15308, (Throwable) obj);
                return zzgaa.zze();
            }
        });
    }
}
