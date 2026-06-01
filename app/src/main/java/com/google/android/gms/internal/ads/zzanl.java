package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzanl extends zzacm {
    public zzanl(zzem zzemVar, long j, long j3) {
        super(new zzach(), new zzank(zzemVar, null), j, 0L, j + 1, 0L, j3, 188L, 1000);
    }

    public static /* synthetic */ int zzh(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}
