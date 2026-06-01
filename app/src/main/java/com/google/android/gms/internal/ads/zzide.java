package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzide extends zzhwo implements zzhya {
    private static final zzide zzh;
    private static volatile zzhyh zzi;
    private int zza;
    private int zzb;
    private int zze;
    private String zzc = "";
    private zzhww zzd = zzhwo.zzbC();
    private zzhxa zzf = zzhwo.zzbM();
    private zzhvi zzg = zzhvi.zzb;

    static {
        zzide zzideVar = new zzide();
        zzh = zzideVar;
        zzhwo.zzbu(zzide.class, zzideVar);
    }

    private zzide() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzh, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", zzidc.class, "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzide();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzidd(bArr);
        }
        if (iOrdinal == 5) {
            return zzh;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzi;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzide.class) {
            try {
                zzhwjVar = zzi;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzh);
                    zzi = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }
}
