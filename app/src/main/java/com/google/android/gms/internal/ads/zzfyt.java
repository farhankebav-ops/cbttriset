package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfyt implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzfyt(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzfyt zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzfyt(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        ExecutorService executorService = (ExecutorService) this.zza.zzb();
        zzfxt zzfxtVar = (zzfxt) this.zzb.zzb();
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30 + String.valueOf(str2).length() + 1);
        androidx.camera.core.processing.util.a.A(sb, "Mozilla/5.0 (Linux; Android ", str, "; ", str2);
        sb.append(")");
        return new zzfyy(executorService, sb.toString(), zzfxtVar.zzl());
    }
}
