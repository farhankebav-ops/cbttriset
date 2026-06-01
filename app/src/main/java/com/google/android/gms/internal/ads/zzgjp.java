package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgjp extends zzgkq {
    private int zza;
    private String zzb;
    private int zzc;
    private byte zzd;

    @Override // com.google.android.gms.internal.ads.zzgkq
    public final zzgkq zza(int i2) {
        this.zza = i2;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgkq
    public final zzgkq zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgkq
    public final zzgkq zzc(int i2) {
        this.zzc = i2;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgkq
    public final zzgkr zzd() {
        if (this.zzd == 3) {
            return new zzgjq(this.zza, this.zzb, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzd & 1) == 0) {
            sb.append(" statusCode");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" uiMode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
