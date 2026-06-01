package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzahy implements zzaeh {
    public final int zza;
    public final long zzb;
    public final int zzc;

    public zzahy(int i2, long j, int i8) {
        this.zza = i2;
        this.zzb = j;
        this.zzc = i8;
    }

    public final String toString() {
        String strZzx = zzep.zzx(this.zza);
        int length = strZzx.length();
        long j = this.zzb;
        int length2 = String.valueOf(j).length();
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 29 + length2 + 16 + String.valueOf(i2).length() + 1);
        androidx.camera.core.processing.util.a.z(sb, "AtomSizeTooSmall{type=", strZzx, ", size=");
        sb.append(j);
        sb.append(", minHeaderSize=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
