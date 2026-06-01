package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzig extends zzmf implements zznn {
    private static final zzig zzf;
    private int zzb;
    private int zzd = 1;
    private zzmo zze = zzmf.zzcv();

    static {
        zzig zzigVar = new zzig();
        zzf = zzigVar;
        zzmf.zzcp(zzig.class, zzigVar);
    }

    private zzig() {
    }

    public static zzie zza() {
        return (zzie) zzf.zzck();
    }

    public final /* synthetic */ void zzb(zzhu zzhuVar) {
        zzhuVar.getClass();
        zzmo zzmoVar = this.zze;
        if (!zzmoVar.zza()) {
            this.zze = zzmf.zzcw(zzmoVar);
        }
        this.zze.add(zzhuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzmf.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzb", "zzd", zzif.zza, "zze", zzhu.class});
        }
        if (i8 == 3) {
            return new zzig();
        }
        byte[] bArr = null;
        if (i8 == 4) {
            return new zzie(bArr);
        }
        if (i8 == 5) {
            return zzf;
        }
        throw null;
    }
}
