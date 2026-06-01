package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzavv implements PackageManager$OnChecksumsReadyListener {
    final zzgvb zza = zzgvb.zze();

    public final void onChecksumsReady(List list) {
        int size;
        int i2;
        if (list == null) {
            this.zza.zza("");
            return;
        }
        try {
            size = list.size();
        } catch (Throwable unused) {
        }
        for (i2 = 0; i2 < size; i2++) {
            ApkChecksum apkChecksumB = c.a.b(list.get(i2));
            if (apkChecksumB.getType() == 8) {
                zzgvb zzgvbVar = this.zza;
                zzgrz zzgrzVarZzi = zzgrz.zzn().zzi();
                byte[] value = apkChecksumB.getValue();
                zzgvbVar.zza(zzgrzVarZzi.zzj(value, 0, value.length));
                return;
            }
            this.zza.zza("");
        }
        this.zza.zza("");
    }
}
