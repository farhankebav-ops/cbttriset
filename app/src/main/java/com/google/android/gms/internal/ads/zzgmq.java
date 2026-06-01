package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgmq extends zzgll {
    final CharSequence zzb;
    int zzc = 0;
    int zzd = Integer.MAX_VALUE;

    public zzgmq(zzgms zzgmsVar, CharSequence charSequence) {
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.ads.zzgll
    public final /* bridge */ /* synthetic */ Object zza() {
        int iZzd;
        int i2 = this.zzc;
        while (true) {
            int i8 = this.zzc;
            if (i8 == -1) {
                zzb();
                return null;
            }
            int iZzc = zzc(i8);
            if (iZzc == -1) {
                iZzc = this.zzb.length();
                this.zzc = -1;
                iZzd = -1;
            } else {
                iZzd = zzd(iZzc);
                this.zzc = iZzd;
            }
            if (iZzd != i2) {
                if (i2 < iZzc) {
                    this.zzb.charAt(i2);
                }
                if (i2 < iZzc) {
                    this.zzb.charAt(iZzc - 1);
                }
                int i9 = this.zzd;
                if (i9 == 1) {
                    CharSequence charSequence = this.zzb;
                    int length = charSequence.length();
                    this.zzc = -1;
                    if (length > i2) {
                        charSequence.charAt(length - 1);
                    }
                    iZzc = length;
                } else {
                    this.zzd = i9 - 1;
                }
                return this.zzb.subSequence(i2, iZzc).toString();
            }
            int i10 = iZzd + 1;
            this.zzc = i10;
            if (i10 > this.zzb.length()) {
                this.zzc = -1;
            }
        }
    }

    public abstract int zzc(int i2);

    public abstract int zzd(int i2);
}
