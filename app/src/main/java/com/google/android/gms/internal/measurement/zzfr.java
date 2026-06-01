package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfr extends zzmf implements zznn {
    private static final zzfr zzh;
    private int zzb;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private zzmo zzg = zzmf.zzcv();

    static {
        zzfr zzfrVar = new zzfr();
        zzh = zzfrVar;
        zzmf.zzcp(zzfr.class, zzfrVar);
    }

    private zzfr() {
    }

    public static zzfr zzh() {
        return zzh;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zzb() {
        return (this.zzb & 2) != 0;
    }

    public final String zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final boolean zze() {
        return this.zzf;
    }

    public final List zzf() {
        return this.zzg;
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public final int zzj() {
        int iZza = zzfq.zza(this.zzd);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzmf.zzcq(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzb", "zzd", zzfp.zza, "zze", "zzf", "zzg"});
        }
        if (i8 == 3) {
            return new zzfr();
        }
        byte[] bArr = null;
        if (i8 == 4) {
            return new zzfo(bArr);
        }
        if (i8 == 5) {
            return zzh;
        }
        throw null;
    }
}
