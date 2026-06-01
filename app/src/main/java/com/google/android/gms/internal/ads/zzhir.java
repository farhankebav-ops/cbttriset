package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhir extends zzhwo implements zzhya {
    private static final zzhir zze;
    private static volatile zzhyh zzf;
    private int zza;
    private int zzb;
    private zzhvi zzc = zzhvi.zzb;
    private zzhiv zzd;

    static {
        zzhir zzhirVar = new zzhir();
        zze = zzhirVar;
        zzhwo.zzbu(zzhir.class, zzhirVar);
    }

    private zzhir() {
    }

    public static zzhir zzd(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhir) zzhwo.zzbT(zze, zzhviVar, zzhvyVar);
    }

    public static zzhiq zze() {
        return (zzhiq) zze.zzbn();
    }

    public static zzhyh zzg() {
        return zze.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhvi zzb() {
        return this.zzc;
    }

    public final zzhiv zzc() {
        zzhiv zzhivVar = this.zzd;
        return zzhivVar == null ? zzhiv.zzc() : zzhivVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhir();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhiq(bArr);
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
        synchronized (zzhir.class) {
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

    public final /* synthetic */ void zzh(zzhvi zzhviVar) {
        this.zzc = zzhviVar;
    }

    public final /* synthetic */ void zzi(zzhiv zzhivVar) {
        zzhivVar.getClass();
        this.zzd = zzhivVar;
        this.zza |= 1;
    }
}
