package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhlk extends zzhwo implements zzhya {
    private static final zzhlk zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private zzhxa zzb = zzhwo.zzbM();

    static {
        zzhlk zzhlkVar = new zzhlk();
        zzc = zzhlkVar;
        zzhwo.zzbu(zzhlk.class, zzhlkVar);
    }

    private zzhlk() {
    }

    public static zzhlh zza() {
        return (zzhlh) zzc.zzbn();
    }

    public final /* synthetic */ void zzb(int i2) {
        this.zza = i2;
    }

    public final /* synthetic */ void zzc(zzhlj zzhljVar) {
        zzhljVar.getClass();
        zzhxa zzhxaVar = this.zzb;
        if (!zzhxaVar.zza()) {
            this.zzb = zzhwo.zzbN(zzhxaVar);
        }
        this.zzb.add(zzhljVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzhwo.zzbv(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zza", "zzb", zzhlj.class});
        }
        if (iOrdinal == 3) {
            return new zzhlk();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhlh(bArr);
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
        synchronized (zzhlk.class) {
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
