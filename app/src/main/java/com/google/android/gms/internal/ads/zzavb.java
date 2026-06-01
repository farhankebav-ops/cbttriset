package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzavb extends zzhwo implements zzhya {
    private static final zzavb zzl;
    private static volatile zzhyh zzm;
    private int zza;
    private long zzb;
    private int zzc;
    private boolean zzd;
    private long zzf;
    private boolean zzg;
    private int zzi;
    private int zzj;
    private int zzk;
    private zzhww zze = zzhwo.zzbC();
    private zzhxa zzh = zzhwo.zzbM();

    static {
        zzavb zzavbVar = new zzavb();
        zzl = zzavbVar;
        zzhwo.zzbu(zzavb.class, zzavbVar);
    }

    private zzavb() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzl, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0002\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003\u0006ဇ\u0004\u0007\u001b\b᠌\u0005\t᠌\u0006\n᠌\u0007", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzavf.class, "zzi", zzglj.zza(), "zzj", zziae.zza(), "zzk", zziac.zza()});
        }
        if (iOrdinal == 3) {
            return new zzavb();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzava(bArr);
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
        synchronized (zzavb.class) {
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
