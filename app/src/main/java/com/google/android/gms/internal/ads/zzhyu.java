package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhyu extends zzhyy {
    public zzhyu() {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhyy
    public final void zza() {
        if (!zzb()) {
            for (int i2 = 0; i2 < zzc(); i2++) {
                Map.Entry entryZzd = zzd(i2);
                if (((zzhwc) ((zzhyv) entryZzd).zza()).zzd()) {
                    entryZzd.setValue(Collections.unmodifiableList((List) entryZzd.getValue()));
                }
            }
            for (Map.Entry entry : zze()) {
                if (((zzhwc) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
