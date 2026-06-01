package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zziy extends zzmf implements zznn {
    private static final zziy zzf;
    private int zzb;
    private String zzd = "";
    private zzmo zze = zzmf.zzcv();

    static {
        zziy zziyVar = new zziy();
        zzf = zziyVar;
        zzmf.zzcp(zziy.class, zziyVar);
    }

    private zziy() {
    }

    public final String zza() {
        return this.zzd;
    }

    public final List zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzmf.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zzd", "zze", zzje.class});
        }
        if (i8 == 3) {
            return new zziy();
        }
        byte[] bArr = null;
        if (i8 == 4) {
            return new zzix(bArr);
        }
        if (i8 == 5) {
            return zzf;
        }
        throw null;
    }
}
