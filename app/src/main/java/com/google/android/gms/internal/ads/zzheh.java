package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzheh extends zzgwj {
    private final String zza;
    private final zzhlt zzb;

    public /* synthetic */ zzheh(String str, zzhlt zzhltVar, byte[] bArr) {
        this.zza = str;
        this.zzb = zzhltVar;
    }

    public final String toString() {
        String str = this.zza;
        int iOrdinal = this.zzb.ordinal();
        return a1.a.o("(typeUrl=", str, ", outputPrefixType=", iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK", ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzb != zzhlt.RAW;
    }
}
