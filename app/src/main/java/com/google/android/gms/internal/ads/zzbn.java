package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbn {
    public static final zzbn zza = new zzbn(zzgpe.zzi());
    private final zzgpe zzb;

    static {
        String str = zzep.zza;
        Integer.toString(0, 36);
    }

    public zzbn(List list) {
        this.zzb = zzgpe.zzq(list);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzbn.class != obj.getClass()) {
            return false;
        }
        return this.zzb.equals(((zzbn) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final zzgpe zza() {
        return this.zzb;
    }

    public final boolean zzb(int i2) {
        int i8 = 0;
        while (true) {
            zzgpe zzgpeVar = this.zzb;
            if (i8 >= zzgpeVar.size()) {
                return false;
            }
            zzbm zzbmVar = (zzbm) zzgpeVar.get(i8);
            if (zzbmVar.zzb() && zzbmVar.zzd() == i2) {
                return true;
            }
            i8++;
        }
    }
}
