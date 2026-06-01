package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbxs extends zzbxu {
    private final String zza;
    private final int zzb;

    public zzbxs(String str, int i2) {
        this.zza = str;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbxs)) {
            return false;
        }
        zzbxs zzbxsVar = (zzbxs) obj;
        if (Objects.equal(this.zza, zzbxsVar.zza)) {
            if (Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbxsVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbxv
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbxv
    public final int zzc() {
        return this.zzb;
    }
}
