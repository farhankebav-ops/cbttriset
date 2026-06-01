package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbe {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();

    public final zzbe zza(String str, double d8, double d9) {
        List list;
        int i2 = 0;
        while (true) {
            list = this.zza;
            if (i2 >= list.size()) {
                break;
            }
            double dDoubleValue = ((Double) this.zzc.get(i2)).doubleValue();
            double dDoubleValue2 = ((Double) this.zzb.get(i2)).doubleValue();
            if (d8 < dDoubleValue || (dDoubleValue == d8 && d9 < dDoubleValue2)) {
                break;
            }
            i2++;
        }
        list.add(i2, str);
        this.zzc.add(i2, Double.valueOf(d8));
        this.zzb.add(i2, Double.valueOf(d9));
        return this;
    }

    public final zzbf zzb() {
        return new zzbf(this, null);
    }

    public final /* synthetic */ List zzc() {
        return this.zza;
    }

    public final /* synthetic */ List zzd() {
        return this.zzb;
    }

    public final /* synthetic */ List zze() {
        return this.zzc;
    }
}
