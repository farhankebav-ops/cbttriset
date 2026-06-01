package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgvh extends zzgtz implements RunnableFuture {
    private volatile zzgup zza;

    public zzgvh(zzgtp zzgtpVar) {
        this.zza = new zzgvf(this, zzgtpVar);
    }

    public static zzgvh zze(Runnable runnable, Object obj) {
        return new zzgvh(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzgup zzgupVar = this.zza;
        if (zzgupVar != null) {
            zzgupVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final void zzc() {
        zzgup zzgupVar;
        if (zzj() && (zzgupVar = this.zza) != null) {
            zzgupVar.zzh();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final String zzd() {
        zzgup zzgupVar = this.zza;
        if (zzgupVar == null) {
            return super.zzd();
        }
        String string = zzgupVar.toString();
        return a1.a.s(new StringBuilder(string.length() + 7), "task=[", string, C2300e4.i.e);
    }

    public zzgvh(Callable callable) {
        this.zza = new zzgvg(this, callable);
    }
}
