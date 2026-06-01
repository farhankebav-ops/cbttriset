package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfh extends zzmf implements zznn {
    private static final zzfh zzh;
    private int zzb;
    private zzfr zzd;
    private zzfl zze;
    private boolean zzf;
    private String zzg = "";

    static {
        zzfh zzfhVar = new zzfh();
        zzh = zzfhVar;
        zzmf.zzcp(zzfh.class, zzfhVar);
    }

    private zzfh() {
    }

    public static zzfh zzi() {
        return zzh;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final zzfr zzb() {
        zzfr zzfrVar = this.zzd;
        return zzfrVar == null ? zzfr.zzh() : zzfrVar;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final zzfl zzd() {
        zzfl zzflVar = this.zze;
        return zzflVar == null ? zzfl.zzj() : zzflVar;
    }

    public final boolean zze() {
        return (this.zzb & 4) != 0;
    }

    public final boolean zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 8) != 0;
    }

    public final String zzh() {
        return this.zzg;
    }

    public final /* synthetic */ void zzj(String str) {
        this.zzb |= 8;
        this.zzg = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzmf.zzcq(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i8 == 3) {
            return new zzfh();
        }
        byte[] bArr = null;
        if (i8 == 4) {
            return new zzfg(bArr);
        }
        if (i8 == 5) {
            return zzh;
        }
        throw null;
    }
}
