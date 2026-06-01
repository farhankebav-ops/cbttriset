package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzied extends zzhwo implements zzhya {
    private static final zzied zzl;
    private static volatile zzhyh zzm;
    private int zza;
    private long zzd;
    private zzief zzi;
    private zzieh zzj;
    private zzhtd zzk;
    private zzhvi zzb = zzhvi.zzb;
    private zzhww zzc = zzhwo.zzbC();
    private zzhww zze = zzhwo.zzbC();
    private zzhxa zzf = zzhwo.zzbM();
    private String zzg = "";
    private zzhxa zzh = zzhwo.zzbM();

    static {
        zzied zziedVar = new zzied();
        zzl = zziedVar;
        zzhwo.zzbu(zzied.class, zziedVar);
    }

    private zzied() {
    }

    public static zzied zzc(byte[] bArr, zzhvy zzhvyVar) throws zzhxd {
        return (zzied) zzhwo.zzbV(zzl, bArr, zzhvyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzl, "\u0001\n\u0000\u0001\u0001\u000f\n\u0000\u0004\u0000\u0001'\u0002ဂ\u0001\u0003'\u0004\u001b\u0005ဉ\u0003\u0007ဈ\u0002\tဉ\u0004\n\u001a\rည\u0000\u000fဉ\u0005", new Object[]{"zza", "zzc", "zzd", "zze", "zzh", zzids.class, "zzi", "zzg", "zzj", "zzf", "zzb", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzied();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziec(bArr);
        }
        if (iOrdinal == 5) {
            return zzl;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzm;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzied.class) {
            try {
                zzhwjVar = zzm;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzl);
                    zzm = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }
}
