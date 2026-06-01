package com.google.android.gms.internal.ads;

import android.app.AppOpsManager$OnOpActiveChangedListener;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzayl implements AppOpsManager$OnOpActiveChangedListener {
    final /* synthetic */ zzaym zza;

    public zzayl(zzaym zzaymVar) {
        Objects.requireNonNull(zzaymVar);
        this.zza = zzaymVar;
    }

    public final void onOpActiveChanged(String str, int i2, String str2, boolean z2) {
        if (z2) {
            zzaym zzaymVar = this.zza;
            zzaymVar.zze(System.currentTimeMillis());
            zzaymVar.zzh(true);
            return;
        }
        zzaym zzaymVar2 = this.zza;
        long jZzf = zzaymVar2.zzf();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jZzf > 0 && jCurrentTimeMillis >= zzaymVar2.zzf()) {
            zzaymVar2.zzg(jCurrentTimeMillis - zzaymVar2.zzf());
        }
        zzaymVar2.zzh(false);
    }
}
