package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcer extends zzarb {
    static final zzcer zzb = new zzcer();

    @Override // com.google.android.gms.internal.ads.zzarb
    public final zzarf zza(String str, byte[] bArr, String str2) {
        return "moov".equals(str) ? new zzarh() : "mvhd".equals(str) ? new zzari() : new zzarj(str);
    }
}
