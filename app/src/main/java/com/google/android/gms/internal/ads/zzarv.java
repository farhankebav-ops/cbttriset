package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzarv implements zzaru {
    @Override // com.google.android.gms.internal.ads.zzaru
    public final byte zza(zzasg zzasgVar, int i2) {
        return zzasgVar.zzb(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final zzasg zzb(zzasg zzasgVar, int i2, int i8) {
        byte[] bArr;
        int length;
        if (i2 < 0 || i2 > i8 || i8 > (length = (bArr = zzasgVar.zza).length) || i2 > i8 || i8 > length) {
            throw new IndexOutOfBoundsException();
        }
        return new zzasg(zzasg.zzh(bArr, i2, i8 - i2));
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final zzaru zzc() {
        return new zzarv();
    }
}
