package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhmf extends zzhwo implements zzhya {
    private static final zzhmf zze;
    private static volatile zzhyh zzf;
    private int zza;
    private zzhmh zzb;
    private int zzc;
    private zzhvi zzd = zzhvi.zzb;

    static {
        zzhmf zzhmfVar = new zzhmf();
        zze = zzhmfVar;
        zzhwo.zzbu(zzhmf.class, zzhmfVar);
    }

    private zzhmf() {
    }

    public static zzhmf zzd(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhmf) zzhwo.zzbT(zze, zzhviVar, zzhvyVar);
    }

    public static zzhme zze() {
        return (zzhme) zze.zzbn();
    }

    public final zzhmh zza() {
        zzhmh zzhmhVar = this.zzb;
        return zzhmhVar == null ? zzhmh.zze() : zzhmhVar;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final zzhvi zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\n", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhmf();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhme(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzf;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzhmf.class) {
            try {
                zzhwjVar = zzf;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zze);
                    zzf = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }

    public final /* synthetic */ void zzg(zzhmh zzhmhVar) {
        zzhmhVar.getClass();
        this.zzb = zzhmhVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzh(int i2) {
        this.zzc = i2;
    }

    public final /* synthetic */ void zzi(zzhvi zzhviVar) {
        this.zzd = zzhviVar;
    }
}
