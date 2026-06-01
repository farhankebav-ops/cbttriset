package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhk extends zzeh implements zzfn {
    private static final zzhk zzb;
    private int zzd;
    private int zze;
    private zzjp zzf;
    private zzjb zzg;
    private zzjd zzh;

    static {
        zzhk zzhkVar = new zzhk();
        zzb = zzhkVar;
        zzeh.zzV(zzhk.class, zzhkVar);
    }

    private zzhk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0005ဉ\u0003", new Object[]{"zzd", "zze", zzij.zza, "zzf", "zzg", "zzh"});
        }
        if (i8 == 3) {
            return new zzhk();
        }
        zzhi zzhiVar = null;
        if (i8 == 4) {
            return new zzhj(zzhiVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
