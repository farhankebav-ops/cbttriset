package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhnl extends zzhpp {
    private final zzhnk zza;

    private zzhnl(zzhnk zzhnkVar) {
        this.zza = zzhnkVar;
    }

    public static zzhnl zzb(zzhnk zzhnkVar) {
        return new zzhnl(zzhnkVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhnl) && ((zzhnl) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzhnl.class, this.zza);
    }

    public final String toString() {
        String string = this.zza.toString();
        return a1.a.s(new StringBuilder(string.length() + 30), "Ed25519 Parameters (variant: ", string, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zza != zzhnk.zzd;
    }

    public final zzhnk zzc() {
        return this.zza;
    }
}
