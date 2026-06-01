package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdwk extends zzdwo {
    private final long zza;
    private final int zzb;

    public /* synthetic */ zzdwk(long j, int i2, byte[] bArr) {
        this.zza = j;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdwo) {
            zzdwo zzdwoVar = (zzdwo) obj;
            if (this.zza == zzdwoVar.zza() && this.zzb == zzdwoVar.zzb()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.zza;
        return ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.zzb;
    }

    public final String toString() {
        long j = this.zza;
        int length = String.valueOf(j).length();
        int i2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 34 + String.valueOf(i2).length() + 1);
        androidx.camera.core.processing.util.a.y(sb, "OnDeviceStorageKey{id=", j, ", eventType=");
        return a1.a.q(sb, "}", i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdwo
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdwo
    public final int zzb() {
        return this.zzb;
    }
}
