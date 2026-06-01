package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfzq extends zzhwo implements zzhya {
    private static final zzfzq zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private zzatg zzb;

    static {
        zzfzq zzfzqVar = new zzfzq();
        zzc = zzfzqVar;
        zzhwo.zzbu(zzfzq.class, zzfzqVar);
    }

    private zzfzq() {
    }

    public static zzfzp zza() {
        return (zzfzp) zzc.zzbn();
    }

    public final /* synthetic */ void zzb(zzatg zzatgVar) {
        zzatgVar.getClass();
        this.zzb = zzatgVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzc, "\u0004\u0001\u0000\u0001\u0012\u0012\u0001\u0000\u0000\u0000\u0012ဉ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzfzq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfzp(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzd;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzfzq.class) {
            try {
                zzhwjVar = zzd;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzc);
                    zzd = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }
}
