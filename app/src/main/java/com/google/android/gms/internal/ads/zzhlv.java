package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zzhlv extends zzhwo implements zzhya {
    public static final /* synthetic */ int zza = 0;
    private static final zzhlv zzd;
    private static volatile zzhyh zze;
    private String zzb = "";
    private zzhxa zzc = zzhwo.zzbM();

    static {
        zzhlv zzhlvVar = new zzhlv();
        zzd = zzhlvVar;
        zzhwo.zzbu(zzhlv.class, zzhlvVar);
    }

    private zzhlv() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzd, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzb", "zzc", zzhlc.class});
        }
        if (iOrdinal == 3) {
            return new zzhlv();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhlu(bArr);
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
        synchronized (zzhlv.class) {
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
}
