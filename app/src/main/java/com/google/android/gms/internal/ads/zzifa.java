package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzifa {
    public static final zzifa zzj = new zzifa(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzifa zzk = new zzifa(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzifa zzl = new zzifa(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzifa zzm = new zzifa(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public final double zza;
    public final double zzb;
    public final double zzc;
    public final double zzd;
    public final double zze;
    public final double zzf;
    public final double zzg;
    public final double zzh;
    public final double zzi;

    public zzifa(double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        this.zza = d12;
        this.zzb = d13;
        this.zzc = d14;
        this.zzd = d8;
        this.zze = d9;
        this.zzf = d10;
        this.zzg = d11;
        this.zzh = d15;
        this.zzi = d16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzifa.class != obj.getClass()) {
            return false;
        }
        zzifa zzifaVar = (zzifa) obj;
        return Double.compare(zzifaVar.zzd, this.zzd) == 0 && Double.compare(zzifaVar.zze, this.zze) == 0 && Double.compare(zzifaVar.zzf, this.zzf) == 0 && Double.compare(zzifaVar.zzg, this.zzg) == 0 && Double.compare(zzifaVar.zzh, this.zzh) == 0 && Double.compare(zzifaVar.zzi, this.zzi) == 0 && Double.compare(zzifaVar.zza, this.zza) == 0 && Double.compare(zzifaVar.zzb, this.zzb) == 0 && Double.compare(zzifaVar.zzc, this.zzc) == 0;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.zza);
        long j = jDoubleToLongBits ^ (jDoubleToLongBits >>> 32);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.zzb);
        long j3 = jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32);
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.zzc);
        long j8 = jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32);
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.zzd);
        long j9 = jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32);
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.zze);
        long j10 = jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32);
        long jDoubleToLongBits6 = Double.doubleToLongBits(this.zzf);
        long j11 = jDoubleToLongBits6 ^ (jDoubleToLongBits6 >>> 32);
        long jDoubleToLongBits7 = Double.doubleToLongBits(this.zzg);
        long jDoubleToLongBits8 = Double.doubleToLongBits(this.zzh);
        long j12 = jDoubleToLongBits8 ^ (jDoubleToLongBits8 >>> 32);
        long jDoubleToLongBits9 = Double.doubleToLongBits(this.zzi);
        return (((((((((((((((((int) j) * 31) + ((int) j3)) * 31) + ((int) j8)) * 31) + ((int) j9)) * 31) + ((int) j10)) * 31) + ((int) j11)) * 31) + ((int) (jDoubleToLongBits7 ^ (jDoubleToLongBits7 >>> 32)))) * 31) + ((int) j12)) * 31) + ((int) (jDoubleToLongBits9 ^ (jDoubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zzj)) {
            return "Rotate 0°";
        }
        if (equals(zzk)) {
            return "Rotate 90°";
        }
        if (equals(zzl)) {
            return "Rotate 180°";
        }
        if (equals(zzm)) {
            return "Rotate 270°";
        }
        double d8 = this.zza;
        double d9 = this.zzb;
        double d10 = this.zzc;
        double d11 = this.zzd;
        double d12 = this.zze;
        double d13 = this.zzf;
        double d14 = this.zzg;
        double d15 = this.zzh;
        double d16 = this.zzi;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d8);
        sb.append(", v=");
        sb.append(d9);
        sb.append(", w=");
        sb.append(d10);
        sb.append(", a=");
        sb.append(d11);
        sb.append(", b=");
        sb.append(d12);
        sb.append(", c=");
        sb.append(d13);
        sb.append(", d=");
        sb.append(d14);
        sb.append(", tx=");
        sb.append(d15);
        sb.append(", ty=");
        sb.append(d16);
        sb.append("}");
        return sb.toString();
    }
}
