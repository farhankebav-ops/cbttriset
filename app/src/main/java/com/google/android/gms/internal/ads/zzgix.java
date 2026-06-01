package com.google.android.gms.internal.ads;

import android.app.AppOpsManager$OnOpActiveChangedListener;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgix implements AppOpsManager$OnOpActiveChangedListener {
    final /* synthetic */ zzgiz zza;

    public zzgix(zzgiz zzgizVar) {
        Objects.requireNonNull(zzgizVar);
        this.zza = zzgizVar;
    }

    public final void onOpActiveChanged(String str, int i2, String str2, boolean z2) {
        zzgiz zzgizVar = this.zza;
        synchronized (zzgizVar) {
            try {
                if (z2) {
                    zzgizVar.zzg(System.currentTimeMillis());
                    zzgizVar.zzj(true);
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzgizVar.zzh() > 0 && jCurrentTimeMillis >= zzgizVar.zzh()) {
                        zzgizVar.zzi(jCurrentTimeMillis - zzgizVar.zzh());
                    }
                    zzgizVar.zzj(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
