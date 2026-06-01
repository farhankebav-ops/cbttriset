package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzavj extends zzhwo implements zzhya {
    private static final zzavj zzh;
    private static volatile zzhyh zzi;
    private int zza;
    private long zzd;
    private long zzf;
    private long zzg;
    private String zzb = "";
    private String zzc = "";
    private String zze = "D";

    static {
        zzavj zzavjVar = new zzavj();
        zzh = zzavjVar;
        zzhwo.zzbu(zzavj.class, zzavjVar);
    }

    private zzavj() {
    }

    public static zzavi zza() {
        return (zzavi) zzh.zzbn();
    }

    public final /* synthetic */ void zzb(String str) {
        this.zza |= 1;
        this.zzb = str;
    }

    public final /* synthetic */ void zzc(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzc = str;
    }

    public final /* synthetic */ void zzd(long j) {
        this.zza |= 4;
        this.zzd = j;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzh, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဈ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzavj();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzavi(bArr);
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
        synchronized (zzavj.class) {
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

    public final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza |= 8;
        this.zze = str;
    }

    public final /* synthetic */ void zzg(long j) {
        this.zza |= 16;
        this.zzf = j;
    }

    public final /* synthetic */ void zzh(long j) {
        this.zza |= 32;
        this.zzg = j;
    }
}
