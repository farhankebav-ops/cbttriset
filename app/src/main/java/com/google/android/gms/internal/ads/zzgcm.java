package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgcm implements zzgdg {
    private final Map zza;
    private final zzauc zzb;
    private final zzgjb zzc;
    private final long zzd;

    public zzgcm(zzauc zzaucVar, Map map, zzfxt zzfxtVar, zzgjd zzgjdVar) {
        this.zza = map;
        this.zzb = zzaucVar;
        this.zzc = zzgjdVar.zza(112);
        this.zzd = zzfxtVar.zzj();
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zza();
        return null;
    }

    public final Void zza() throws Exception {
        zzauz zzauzVar;
        try {
            try {
                this.zzc.zza();
                j2.q qVar = (j2.q) this.zza.get("gs");
                if (qVar != null && (zzauzVar = (zzauz) qVar.get(this.zzd, TimeUnit.MILLISECONDS)) != null) {
                    zzauc zzaucVar = this.zzb;
                    synchronized (zzaucVar) {
                        zzaucVar.zzad(zzauzVar.zzh());
                        zzaucVar.zzN(zzauzVar.zzd());
                    }
                }
            } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException e) {
                this.zzc.zzb(e);
            }
            this.zzc.zzc();
            return null;
        } catch (Throwable th) {
            this.zzc.zzc();
            throw th;
        }
    }
}
