package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzv extends zzk {
    final CharSequence zzb;
    final zzp zzc;
    final boolean zzd;
    int zze = 0;
    int zzf = Integer.MAX_VALUE;

    public zzv(zzw zzwVar, CharSequence charSequence) {
        this.zzc = zzwVar.zzf();
        this.zzd = zzwVar.zzg();
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.common.zzk
    public final /* bridge */ /* synthetic */ Object zza() {
        int iZzc;
        int iZzd;
        int i2 = this.zze;
        while (true) {
            int i8 = this.zze;
            if (i8 == -1) {
                zzb();
                return null;
            }
            iZzc = zzc(i8);
            if (iZzc == -1) {
                iZzc = this.zzb.length();
                this.zze = -1;
                iZzd = -1;
            } else {
                iZzd = zzd(iZzc);
                this.zze = iZzd;
            }
            if (iZzd == i2) {
                int i9 = iZzd + 1;
                this.zze = i9;
                if (i9 > this.zzb.length()) {
                    this.zze = -1;
                }
            } else {
                if (i2 < iZzc) {
                    this.zzb.charAt(i2);
                }
                if (i2 < iZzc) {
                    this.zzb.charAt(iZzc - 1);
                }
                if (!this.zzd || i2 != iZzc) {
                    break;
                }
                i2 = this.zze;
            }
        }
        int i10 = this.zzf;
        if (i10 == 1) {
            CharSequence charSequence = this.zzb;
            int length = charSequence.length();
            this.zze = -1;
            if (length > i2) {
                charSequence.charAt(length - 1);
            }
            iZzc = length;
        } else {
            this.zzf = i10 - 1;
        }
        return this.zzb.subSequence(i2, iZzc).toString();
    }

    public abstract int zzc(int i2);

    public abstract int zzd(int i2);
}
