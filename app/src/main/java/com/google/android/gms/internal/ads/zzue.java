package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzue implements zzwm {
    private final zzgpe zza;
    private long zzb;

    public zzue(List list, List list2) {
        int i2 = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        zzgmd.zza(list.size() == list2.size());
        for (int i8 = 0; i8 < list.size(); i8++) {
            zzgpbVar.zzf(new zzud((zzwm) list.get(i8), (List) list2.get(i8)));
        }
        this.zza = zzgpbVar.zzi();
        this.zzb = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
        int i2 = 0;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i2 >= zzgpeVar.size()) {
                return;
            }
            ((zzud) zzgpeVar.get(i2)).zzg(j);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        int i2 = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i2 >= zzgpeVar.size()) {
                break;
            }
            zzud zzudVar = (zzud) zzgpeVar.get(i2);
            long jZzi = zzudVar.zzi();
            if ((zzudVar.zza().contains(1) || zzudVar.zza().contains(2) || zzudVar.zza().contains(4)) && jZzi != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzi);
            }
            if (jZzi != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jZzi);
            }
            i2++;
        }
        if (jMin != LocationRequestCompat.PASSIVE_INTERVAL) {
            this.zzb = jMin;
            return jMin;
        }
        if (jMin2 == LocationRequestCompat.PASSIVE_INTERVAL) {
            return Long.MIN_VALUE;
        }
        long j = this.zzb;
        return j != -9223372036854775807L ? j : jMin2;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        int i2 = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i2 >= zzgpeVar.size()) {
                break;
            }
            long jZzl = ((zzud) zzgpeVar.get(i2)).zzl();
            if (jZzl != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzl);
            }
            i2++;
        }
        if (jMin == LocationRequestCompat.PASSIVE_INTERVAL) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        boolean zZzm;
        boolean z2 = false;
        do {
            long jZzl = zzl();
            if (jZzl == Long.MIN_VALUE) {
                break;
            }
            int i2 = 0;
            zZzm = false;
            while (true) {
                zzgpe zzgpeVar = this.zza;
                if (i2 >= zzgpeVar.size()) {
                    break;
                }
                long jZzl2 = ((zzud) zzgpeVar.get(i2)).zzl();
                boolean z7 = jZzl2 != Long.MIN_VALUE && jZzl2 <= zzknVar.zza;
                if (jZzl2 == jZzl || z7) {
                    zZzm |= ((zzud) zzgpeVar.get(i2)).zzm(zzknVar);
                }
                i2++;
            }
            z2 |= zZzm;
        } while (zZzm);
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        int i2 = 0;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i2 >= zzgpeVar.size()) {
                return false;
            }
            if (((zzud) zzgpeVar.get(i2)).zzn()) {
                return true;
            }
            i2++;
        }
    }
}
