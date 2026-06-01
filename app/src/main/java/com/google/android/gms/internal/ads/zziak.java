package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zziak extends zzhwo implements zzhya {
    private static final zziak zzd;
    private static volatile zzhyh zze;
    private int zza;
    private long zzb;
    private long zzc;

    static {
        zziak zziakVar = new zziak();
        zzd = zziakVar;
        zzhwo.zzbu(zziak.class, zziakVar);
    }

    private zziak() {
    }

    public static zziaj zzc() {
        return (zziaj) zzd.zzbn();
    }

    public final /* synthetic */ void zzd(int i2) {
        this.zza = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zziak();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziaj(bArr);
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
        synchronized (zziak.class) {
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

    public final /* synthetic */ void zze(long j) {
        this.zzb = j;
    }

    public final /* synthetic */ void zzg(long j) {
        this.zzc = j;
    }
}
