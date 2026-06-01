package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdwj extends zzdwn {
    private long zza;
    private int zzb;
    private byte zzc;

    @Override // com.google.android.gms.internal.ads.zzdwn
    public final zzdwn zza(long j) {
        this.zza = j;
        this.zzc = (byte) (this.zzc | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdwn
    public final zzdwn zzb(int i2) {
        this.zzb = i2;
        this.zzc = (byte) (this.zzc | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdwn
    public final zzdwo zzc() {
        if (this.zzc == 3) {
            return new zzdwk(this.zza, this.zzb, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzc & 1) == 0) {
            sb.append(" id");
        }
        if ((this.zzc & 2) == 0) {
            sb.append(" eventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
