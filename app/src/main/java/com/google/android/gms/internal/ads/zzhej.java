package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhej extends zzgwj {
    private final zzhfx zza;

    public zzhej(zzhfx zzhfxVar) {
        this.zza = zzhfxVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhej)) {
            return false;
        }
        zzhfx zzhfxVar = ((zzhej) obj).zza;
        zzhfx zzhfxVar2 = this.zza;
        return zzhfxVar2.zzc().zzc().equals(zzhfxVar.zzc().zzc()) && zzhfxVar2.zzc().zza().equals(zzhfxVar.zzc().zza()) && zzhfxVar2.zzc().zzb().equals(zzhfxVar.zzc().zzb());
    }

    public final int hashCode() {
        zzhfx zzhfxVar = this.zza;
        return Objects.hash(zzhfxVar.zzc(), zzhfxVar.zzf());
    }

    public final String toString() {
        zzhfx zzhfxVar = this.zza;
        String strZza = zzhfxVar.zzc().zza();
        int iOrdinal = zzhfxVar.zzc().zzc().ordinal();
        return a1.a.o("(typeUrl=", strZza, ", outputPrefixType=", iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK", ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zza.zzc().zzc() != zzhlt.RAW;
    }

    public final zzhfx zzb() {
        return this.zza;
    }
}
