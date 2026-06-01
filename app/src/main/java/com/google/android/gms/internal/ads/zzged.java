package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.View;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzged implements zzgab {
    private final zzifb zza;
    private final zzifb zzb;
    private final zzifb zzc;
    private final boolean zzd;
    private final long zze;

    public zzged(zzifb zzifbVar, zzifb zzifbVar2, zzifb zzifbVar3, boolean z2, long j) {
        this.zza = zzifbVar;
        this.zzb = zzifbVar2;
        this.zzc = zzifbVar3;
        this.zzd = z2;
        this.zze = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgab
    public final String zza() {
        return ((zzgfh) this.zzb.zzb()).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgab
    public final j2.q zzb() {
        if (this.zzd) {
            return (zzgua) zzgui.zzj((zzgua) zzgui.zzg(zzgua.zzw(((zzgew) this.zza.zzb()).zza()), Throwable.class, zzgec.zza, zzguz.zza()), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzgea
                @Override // com.google.android.gms.internal.ads.zzgtq
                public final /* synthetic */ j2.q zza(Object obj) {
                    return this.zza.zzh((zzgev) obj);
                }
            }, zzguz.zza());
        }
        j2.q qVarZzb = ((zzgfh) this.zzb.zzb()).zzb();
        long j = this.zze;
        if (j > 0) {
            ((ScheduledExecutorService) this.zzc.zzb()).schedule(new Callable() { // from class: com.google.android.gms.internal.ads.zzgeb
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    this.zza.zzi();
                    return null;
                }
            }, j, TimeUnit.MILLISECONDS);
            return qVarZzb;
        }
        ((zzgew) this.zza.zzb()).zza();
        return qVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgab
    public final j2.q zzc(Context context) {
        return ((zzgfh) this.zzb.zzb()).zzc(context);
    }

    @Override // com.google.android.gms.internal.ads.zzgab
    public final j2.q zzd(Context context, String str, View view, Activity activity) {
        return ((zzgfh) this.zzb.zzb()).zzd(context, null, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzgab
    public final j2.q zze(Context context, String str, View view, Activity activity) {
        return ((zzgfh) this.zzb.zzb()).zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgab
    public final void zzf(InputEvent inputEvent) {
        ((zzgfh) this.zzb.zzb()).zzf(inputEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzgab
    public final int zzg() {
        return ((zzgfh) this.zzb.zzb()).zzg();
    }

    public final /* synthetic */ j2.q zzh(zzgev zzgevVar) {
        return ((zzgfh) this.zzb.zzb()).zzb();
    }

    public final /* synthetic */ Object zzi() {
        ((zzgew) this.zza.zzb()).zza();
        return null;
    }
}
