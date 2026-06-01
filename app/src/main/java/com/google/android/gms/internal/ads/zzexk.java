package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzexk implements zzeya {
    private final zzcaf zza;
    private final zzgus zzb;
    private final Context zzc;

    public zzexk(zzcaf zzcafVar, zzgus zzgusVar, Context context) {
        this.zza = zzcafVar;
        this.zzb = zzgusVar;
        this.zzc = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zzb.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzexj
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 34;
    }

    public final /* synthetic */ zzexl zzc() {
        zzcaf zzcafVar = this.zza;
        Context context = this.zzc;
        if (!zzcafVar.zza(context)) {
            return new zzexl(null, null, null, null, null);
        }
        String strZzh = zzcafVar.zzh(context);
        String str = strZzh == null ? "" : strZzh;
        String strZzi = zzcafVar.zzi(context);
        String str2 = strZzi == null ? "" : strZzi;
        String strZzj = zzcafVar.zzj(context);
        String str3 = strZzj == null ? "" : strZzj;
        String str4 = true != zzcafVar.zza(context) ? null : "fa";
        return new zzexl(str, str2, str3, str4 == null ? "" : str4, "TIME_OUT".equals(str2) ? (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaC) : null);
    }
}
