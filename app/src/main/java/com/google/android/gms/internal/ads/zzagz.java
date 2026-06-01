package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagz implements zzao {
    public final List zza;

    public zzagz(List list) {
        this.zza = list;
        boolean z2 = false;
        if (!list.isEmpty()) {
            long j = ((zzagy) list.get(0)).zzb;
            int i2 = 1;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                if (((zzagy) list.get(i2)).zza < j) {
                    z2 = true;
                    break;
                } else {
                    j = ((zzagy) list.get(i2)).zzb;
                    i2++;
                }
            }
        }
        zzgmd.zza(!z2);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzagz.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzagz) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.zza.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final /* synthetic */ void zza(zzam zzamVar) {
        g.a(this, zzamVar);
    }
}
