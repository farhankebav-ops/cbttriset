package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhtb {
    private final zzhsz zza;

    private zzhtb(zzhsz zzhszVar) {
        this.zza = zzhszVar;
    }

    public static zzhtb zza(byte[] bArr, zzgwn zzgwnVar) {
        return new zzhtb(zzhsz.zza(bArr));
    }

    public static zzhtb zzb(int i2) {
        return new zzhtb(zzhsz.zza(zzhfz.zza(i2)));
    }

    public final byte[] zzc(zzgwn zzgwnVar) {
        return this.zza.zzc();
    }

    public final int zzd() {
        return this.zza.zzd();
    }
}
