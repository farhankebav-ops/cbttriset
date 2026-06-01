package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhlo extends zzhwo implements zzhya {
    private static final zzhlo zzb;
    private static volatile zzhyh zzc;
    private String zza = "";

    static {
        zzhlo zzhloVar = new zzhlo();
        zzb = zzhloVar;
        zzhwo.zzbu(zzhlo.class, zzhloVar);
    }

    private zzhlo() {
    }

    public static zzhlo zzb(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhlo) zzhwo.zzbT(zzb, zzhviVar, zzhvyVar);
    }

    public static zzhln zzc() {
        return (zzhln) zzb.zzbn();
    }

    public static zzhlo zzd() {
        return zzb;
    }

    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhlo();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhln(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzc;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzhlo.class) {
            try {
                zzhwjVar = zzc;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzb);
                    zzc = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }

    public final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza = str;
    }
}
