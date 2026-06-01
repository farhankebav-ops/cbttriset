package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhgd {
    private final Class zza;
    private final zzhsz zzb;

    public /* synthetic */ zzhgd(Class cls, zzhsz zzhszVar, byte[] bArr) {
        this.zza = cls;
        this.zzb = zzhszVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhgd)) {
            return false;
        }
        zzhgd zzhgdVar = (zzhgd) obj;
        return zzhgdVar.zza.equals(this.zza) && zzhgdVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        zzhsz zzhszVar = this.zzb;
        String simpleName = this.zza.getSimpleName();
        String strValueOf = String.valueOf(zzhszVar);
        return a1.a.s(new StringBuilder(simpleName.length() + 21 + strValueOf.length()), simpleName, ", object identifier: ", strValueOf);
    }
}
