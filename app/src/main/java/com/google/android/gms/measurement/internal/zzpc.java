package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzpc {
    com.google.android.gms.internal.measurement.zzid zza;
    List zzb;
    List zzc;
    long zzd;
    final /* synthetic */ zzpg zze;

    public /* synthetic */ zzpc(zzpg zzpgVar, byte[] bArr) {
        Objects.requireNonNull(zzpgVar);
        this.zze = zzpgVar;
    }

    private static final long zzb(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        return ((zzhsVar.zzf() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        Preconditions.checkNotNull(zzhsVar);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (!this.zzc.isEmpty() && zzb((com.google.android.gms.internal.measurement.zzhs) this.zzc.get(0)) != zzb(zzhsVar)) {
            return false;
        }
        long jZzcn = this.zzd + ((long) zzhsVar.zzcn());
        zzpg zzpgVar = this.zze;
        if (!zzpgVar.zzd().zzp(null, zzfy.zzbd)) {
            zzpgVar.zzd();
            if (jZzcn >= zzal.zzG()) {
                return false;
            }
        } else if (!this.zzc.isEmpty()) {
            zzpgVar.zzd();
            if (jZzcn >= zzal.zzG()) {
                return false;
            }
        }
        this.zzd = jZzcn;
        this.zzc.add(zzhsVar);
        this.zzb.add(Long.valueOf(j));
        int size = this.zzc.size();
        zzpgVar.zzd();
        return size < Math.max(1, ((Integer) zzfy.zzj.zzb(null)).intValue());
    }
}
