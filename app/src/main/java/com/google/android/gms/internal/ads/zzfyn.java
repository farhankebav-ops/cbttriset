package com.google.android.gms.internal.ads;

import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfyn extends zzhwo implements zzhya {
    private static final zzfyn zzi;
    private static volatile zzhyh zzj;
    private int zza;
    private boolean zzc;
    private boolean zzd;
    private long zzh;
    private boolean zzb = true;
    private long zze = TTAdConstant.AD_MAX_EVENT_TIME;
    private long zzf = 3600000;
    private String zzg = "https://pagead2.googlesyndication.com/mads/asp";

    static {
        zzfyn zzfynVar = new zzfyn();
        zzi = zzfynVar;
        zzhwo.zzbu(zzfyn.class, zzfynVar);
    }

    private zzfyn() {
    }

    public static zzfym zze() {
        return (zzfym) zzi.zzbn();
    }

    public static zzfyn zzg() {
        return zzi;
    }

    public final boolean zza() {
        return this.zzd;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzi, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဈ\u0005\u0007ဂ\u0006", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (iOrdinal == 3) {
            return new zzfyn();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfym(bArr);
        }
        if (iOrdinal == 5) {
            return zzi;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzj;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zzfyn.class) {
            try {
                zzhwjVar = zzj;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzi);
                    zzj = zzhwjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhwjVar;
    }

    public final /* synthetic */ void zzh(boolean z2) {
        this.zza |= 4;
        this.zzd = z2;
    }

    public final /* synthetic */ void zzi(long j) {
        this.zza |= 64;
        this.zzh = j;
    }
}
