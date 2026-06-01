package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzayb implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzayd zzb;

    public zzayb(zzayd zzaydVar, int i2, boolean z2) {
        this.zza = i2;
        Objects.requireNonNull(zzaydVar);
        this.zzb = zzaydVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzauz zzauzVarZza;
        int i2 = this.zza;
        zzayd zzaydVar = this.zzb;
        if (i2 > 0) {
            try {
                Thread.sleep(i2 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            Context context = zzaydVar.zza;
            zzauzVarZza = zzfrz.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused2) {
            zzauzVarZza = null;
        }
        zzayd zzaydVar2 = this.zzb;
        zzaydVar2.zzs(zzauzVarZza);
        int i8 = this.zza;
        if (i8 < 4) {
            if (zzauzVarZza != null && zzauzVarZza.zza() && !zzauzVarZza.zzb().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzauzVarZza.zzg() && zzauzVarZza.zzh().zza() && zzauzVarZza.zzh().zzb() != -2) {
                return;
            }
            zzaydVar2.zzp(i8 + 1, true);
        }
    }
}
