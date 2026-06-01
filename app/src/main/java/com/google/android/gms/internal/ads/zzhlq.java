package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhlq extends zzhwo implements zzhya {
    private static final zzhlq zzd;
    private static volatile zzhyh zze;
    private int zza;
    private int zzb;
    private zzhls zzc;

    static {
        zzhlq zzhlqVar = new zzhlq();
        zzd = zzhlqVar;
        zzhwo.zzbu(zzhlq.class, zzhlqVar);
    }

    private zzhlq() {
    }

    public static zzhlq zzc(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhlq) zzhwo.zzbT(zzd, zzhviVar, zzhvyVar);
    }

    public static zzhlp zzd() {
        return (zzhlp) zzd.zzbn();
    }

    public static zzhyh zze() {
        return zzd.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhls zzb() {
        zzhls zzhlsVar = this.zzc;
        return zzhlsVar == null ? zzhls.zze() : zzhlsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhlq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhlp(bArr);
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
        synchronized (zzhlq.class) {
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

    public final /* synthetic */ void zzg(zzhls zzhlsVar) {
        zzhlsVar.getClass();
        this.zzc = zzhlsVar;
        this.zza |= 1;
    }
}
