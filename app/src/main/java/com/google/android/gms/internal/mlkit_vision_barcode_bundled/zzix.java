package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzix extends zzeh implements zzfn {
    private static final zzix zzb;
    private int zzd;
    private int zze;
    private int zzf = 100;
    private int zzg;

    static {
        zzix zzixVar = new zzix();
        zzb = zzixVar;
        zzeh.zzV(zzix.class, zzixVar);
    }

    private zzix() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", zziv.zza, "zzf", "zzg"});
        }
        if (i8 == 3) {
            return new zzix();
        }
        zzhi zzhiVar = null;
        if (i8 == 4) {
            return new zziw(zzhiVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
