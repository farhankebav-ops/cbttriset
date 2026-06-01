package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaub extends zzhwo implements zzhya {
    private static final zzaub zzg;
    private static volatile zzhyh zzh;
    private int zza;
    private boolean zzc;
    private boolean zzd;
    private long zzb = 100;
    private long zze = 300;
    private long zzf = 1000;

    static {
        zzaub zzaubVar = new zzaub();
        zzg = zzaubVar;
        zzhwo.zzbu(zzaub.class, zzaubVar);
    }

    private zzaub() {
    }

    public static zzaub zza() {
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzg, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005ဂ\u0004", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzaub();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaua(bArr);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzh;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzaub.class) {
            try {
                zzhwjVar = zzh;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzg);
                    zzh = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }
}
