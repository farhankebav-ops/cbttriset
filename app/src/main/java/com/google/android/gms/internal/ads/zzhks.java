package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhks extends zzhwo implements zzhya {
    private static final zzhks zze;
    private static volatile zzhyh zzf;
    private int zza;
    private zzhku zzb;
    private int zzc;
    private int zzd;

    static {
        zzhks zzhksVar = new zzhks();
        zze = zzhksVar;
        zzhwo.zzbu(zzhks.class, zzhksVar);
    }

    private zzhks() {
    }

    public static zzhks zzd(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhks) zzhwo.zzbT(zze, zzhviVar, zzhvyVar);
    }

    public static zzhkr zze() {
        return (zzhkr) zze.zzbn();
    }

    public static zzhks zzg() {
        return zze;
    }

    public final zzhku zza() {
        zzhku zzhkuVar = this.zzb;
        return zzhkuVar == null ? zzhku.zzd() : zzhkuVar;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final int zzc() {
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
            return zzhwo.zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhks();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhkr(bArr);
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
        synchronized (zzhks.class) {
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

    public final /* synthetic */ void zzh(zzhku zzhkuVar) {
        zzhkuVar.getClass();
        this.zzb = zzhkuVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzi(int i2) {
        this.zzc = i2;
    }
}
