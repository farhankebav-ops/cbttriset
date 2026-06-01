package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhmv extends zzhwo implements zzhya {
    private static final zzhmv zzb;
    private static volatile zzhyh zzc;
    private int zza;

    static {
        zzhmv zzhmvVar = new zzhmv();
        zzb = zzhmvVar;
        zzhwo.zzbu(zzhmv.class, zzhmvVar);
    }

    private zzhmv() {
    }

    public static zzhmv zzb(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhmv) zzhwo.zzbT(zzb, zzhviVar, zzhvyVar);
    }

    public static zzhmv zzc() {
        return zzb;
    }

    public final int zza() {
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
            return zzhwo.zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhmv();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhmu(bArr);
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
        synchronized (zzhmv.class) {
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
}
