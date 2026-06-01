package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzief extends zzhwo implements zzhya {
    private static final zzief zzj;
    private static volatile zzhyh zzk;
    private int zza;
    private zzido zzh;
    private String zzb = "";
    private String zzc = "";
    private zzhxa zzd = zzhwo.zzbM();
    private zzhxa zze = zzhwo.zzbM();
    private zzhxa zzf = zzhwo.zzbM();
    private int zzg = -1;
    private String zzi = "";

    static {
        zzief zziefVar = new zzief();
        zzj = zziefVar;
        zzhwo.zzbu(zzief.class, zziefVar);
    }

    private zzief() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzj, "\u0001\b\u0000\u0001\u0001\n\b\u0000\u0003\u0000\u0001ဈ\u0001\u0002\u001b\u0003\u001b\u0004င\u0002\u0005ဈ\u0000\b\u001b\tဈ\u0004\nဉ\u0003", new Object[]{"zza", "zzc", "zzd", zzids.class, "zze", zzidz.class, "zzg", "zzb", "zzf", zziem.class, "zzi", "zzh"});
        }
        if (iOrdinal == 3) {
            return new zzief();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziee(bArr);
        }
        if (iOrdinal == 5) {
            return zzj;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzk;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzief.class) {
            try {
                zzhwjVar = zzk;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzj);
                    zzk = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }
}
