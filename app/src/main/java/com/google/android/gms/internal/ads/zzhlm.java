package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhlm extends zzhwo implements zzhya {
    private static final zzhlm zzd;
    private static volatile zzhyh zze;
    private int zza;
    private int zzb;
    private zzhlo zzc;

    static {
        zzhlm zzhlmVar = new zzhlm();
        zzd = zzhlmVar;
        zzhwo.zzbu(zzhlm.class, zzhlmVar);
    }

    private zzhlm() {
    }

    public static zzhlm zzc(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhlm) zzhwo.zzbT(zzd, zzhviVar, zzhvyVar);
    }

    public static zzhll zzd() {
        return (zzhll) zzd.zzbn();
    }

    public static zzhyh zze() {
        return zzd.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhlo zzb() {
        zzhlo zzhloVar = this.zzc;
        return zzhloVar == null ? zzhlo.zzd() : zzhloVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhlm();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhll(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zze;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzhlm.class) {
            try {
                zzhwjVar = zze;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzd);
                    zze = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }

    public final /* synthetic */ void zzg(zzhlo zzhloVar) {
        zzhloVar.getClass();
        this.zzc = zzhloVar;
        this.zza |= 1;
    }
}
