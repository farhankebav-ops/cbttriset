package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgaa extends zzhwo implements zzhya {
    private static final zzgaa zze;
    private static volatile zzhyh zzf;
    private int zza;
    private int zzb = 0;
    private Object zzc;
    private int zzd;

    static {
        zzgaa zzgaaVar = new zzgaa();
        zze = zzgaaVar;
        zzhwo.zzbu(zzgaa.class, zzgaaVar);
    }

    private zzgaa() {
    }

    public static zzfzz zzd() {
        return (zzfzz) zze.zzbn();
    }

    public static zzgaa zze() {
        return zze;
    }

    public final zzbai zza() {
        return this.zzb == 1 ? (zzbai) this.zzc : zzbai.zzj();
    }

    public final zzbag zzb() {
        return this.zzb == 2 ? (zzbag) this.zzc : zzbag.zzc();
    }

    public final zzbaa zzc() {
        zzbaa zzbaaVarZzb = zzbaa.zzb(this.zzd);
        return zzbaaVarZzb == null ? zzbaa.UNSUPPORTED : zzbaaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zze, "\u0004\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003᠌\u0000", new Object[]{"zzc", "zzb", "zza", zzbai.class, zzbag.class, "zzd", zzbaa.zzc()});
        }
        if (iOrdinal == 3) {
            return new zzgaa();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfzz(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzf;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzgaa.class) {
            try {
                zzhwjVar = zzf;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zze);
                    zzf = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }

    public final /* synthetic */ void zzg(zzbai zzbaiVar) {
        zzbaiVar.getClass();
        this.zzc = zzbaiVar;
        this.zzb = 1;
    }

    public final /* synthetic */ void zzh(zzbag zzbagVar) {
        zzbagVar.getClass();
        this.zzc = zzbagVar;
        this.zzb = 2;
    }

    public final /* synthetic */ void zzi(zzbaa zzbaaVar) {
        this.zzd = zzbaaVar.zza();
        this.zza |= 1;
    }
}
