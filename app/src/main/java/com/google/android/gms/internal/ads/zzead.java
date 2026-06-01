package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzead {
    private final zzgus zza;
    private final zzgus zzb;
    private final zzebn zzc;
    private final zzifb zzd;

    public zzead(zzgus zzgusVar, zzgus zzgusVar2, zzebn zzebnVar, zzifb zzifbVar) {
        this.zza = zzgusVar;
        this.zzb = zzgusVar2;
        this.zzc = zzebnVar;
        this.zzd = zzifbVar;
    }

    public final j2.q zza(final zzbxj zzbxjVar) {
        j2.q qVarZzh;
        String str = zzbxjVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzc();
        if (com.google.android.gms.ads.internal.util.zzs.zzG(str)) {
            qVarZzh = zzgui.zzc(new zzecj(1));
        } else {
            qVarZzh = zzgui.zzh(this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzeac
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzb(zzbxjVar);
                }
            }), ExecutionException.class, zzdzz.zza, this.zzb);
        }
        final int callingUid = Binder.getCallingUid();
        return zzgui.zzh(qVarZzh, zzecj.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzeaa
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzc(zzbxjVar, callingUid, (zzecj) obj);
            }
        }, this.zzb);
    }

    public final /* synthetic */ zzeck zzb(zzbxj zzbxjVar) {
        return (zzeck) this.zzc.zza(zzbxjVar).get(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgi)).intValue(), TimeUnit.SECONDS);
    }

    public final /* synthetic */ j2.q zzc(final zzbxj zzbxjVar, int i2, zzecj zzecjVar) {
        Bundle bundle;
        if (zzbxjVar != null && (bundle = zzbxjVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzgui.zzj(((zzeea) this.zzd.zzb()).zzb(zzbxjVar, i2), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzeab
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return zzgui.zza(new zzeck((InputStream) obj, zzbxjVar));
            }
        }, this.zzb);
    }
}
