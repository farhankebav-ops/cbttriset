package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzflv extends zzhwo implements zzhya {
    private static final zzflv zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private zzfls zzb;

    static {
        zzflv zzflvVar = new zzflv();
        zzc = zzflvVar;
        zzhwo.zzbu(zzflv.class, zzflvVar);
    }

    private zzflv() {
    }

    public static zzflu zza() {
        return (zzflu) zzc.zzbn();
    }

    public final /* synthetic */ void zzb(zzfls zzflsVar) {
        zzflsVar.getClass();
        this.zzb = zzflsVar;
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
            return zzhwo.zzbv(zzc, "\u0004\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzflv();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzflu(bArr);
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
        synchronized (zzflv.class) {
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
