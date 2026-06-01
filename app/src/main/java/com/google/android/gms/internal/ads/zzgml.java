package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgml extends zzgmq {
    public zzgml(zzgms zzgmsVar, CharSequence charSequence, int i2) {
        super(zzgmsVar, charSequence);
    }

    @Override // com.google.android.gms.internal.ads.zzgmq
    public final int zzc(int i2) {
        int i8 = i2 + 4000;
        if (i8 < ((zzgmq) this).zzb.length()) {
            return i8;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgmq
    public final int zzd(int i2) {
        return i2;
    }
}
