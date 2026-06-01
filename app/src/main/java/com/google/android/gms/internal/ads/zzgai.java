package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgai {
    private final zzifb zza;
    private final zzifb zzb;
    private final zzifb zzc;
    private final ExecutorService zzd;
    private final zzgjd zze;

    public zzgai(zzifb zzifbVar, zzifb zzifbVar2, zzifb zzifbVar3, ExecutorService executorService, zzgjd zzgjdVar) {
        this.zza = zzifbVar;
        this.zzb = zzifbVar2;
        this.zzc = zzifbVar3;
        this.zzd = executorService;
        this.zze = zzgjdVar;
    }

    private final j2.q zze(final int i2) {
        return (zzgua) zzgui.zzj(zzgua.zzw(zzgui.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzgae
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc(i2);
            }
        }, this.zzd)), zzgaf.zza, zzguz.zza());
    }

    public final /* synthetic */ zzgjd zza() {
        return this.zze;
    }

    public final j2.q zzb(int i2, boolean z2) {
        j2.q qVarZze = zze(i2);
        return (!z2 || i2 == 2) ? qVarZze : (zzgua) zzgui.zzj((zzgua) zzgui.zzg(zzgua.zzw(qVarZze), Throwable.class, zzgah.zza, zzguz.zza()), new zzgad(this), zzguz.zza());
    }

    public final /* synthetic */ zzgab zzc(int i2) {
        int i8 = i2 - 1;
        if (i8 == 1) {
            return (zzgab) this.zza.zzb();
        }
        if (i8 == 2) {
            return (zzgab) this.zzb.zzb();
        }
        if (i8 == 3) {
            return (zzgab) this.zzc.zzb();
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ j2.q zzd(int i2) {
        return zze(2);
    }
}
