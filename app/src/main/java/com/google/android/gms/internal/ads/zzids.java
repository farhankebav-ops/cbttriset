package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzids extends zzhwo implements zzhya {
    private static final zzids zzn;
    private static volatile zzhyh zzo;
    private int zza;
    private int zzd;
    private boolean zzf;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private zzidx zzk;
    private zzidr zzm;
    private String zzb = "";
    private String zzc = "";
    private int zze = 1;
    private String zzg = "";
    private String zzl = "";

    static {
        zzids zzidsVar = new zzids();
        zzn = zzidsVar;
        zzhwo.zzbu(zzids.class, zzidsVar);
    }

    private zzids() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzn, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005ဇ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\bင\u0007\t᠌\b\nဉ\t\u000bဈ\n\fဉ\u000b", new Object[]{"zza", "zzb", "zzc", "zzd", zzieb.zza, "zze", zziea.zza, "zzf", "zzg", "zzh", "zzi", "zzj", zzidt.zza, "zzk", "zzl", "zzm"});
        }
        if (iOrdinal == 3) {
            return new zzids();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzidp(bArr);
        }
        if (iOrdinal == 5) {
            return zzn;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzo;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzids.class) {
            try {
                zzhwjVar = zzo;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzn);
                    zzo = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }
}
