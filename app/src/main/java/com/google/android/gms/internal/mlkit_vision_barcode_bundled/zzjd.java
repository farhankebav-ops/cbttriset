package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjd extends zzeh implements zzfn {
    private static final zzjd zzb;
    private int zzd;
    private zzeo zze = zzeh.zzP();
    private zzjf zzf;
    private zzhm zzg;

    static {
        zzjd zzjdVar = new zzjd();
        zzb = zzjdVar;
        zzeh.zzV(zzjd.class, zzjdVar);
    }

    private zzjd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", zzjp.class, "zzf", "zzg"});
        }
        if (i8 == 3) {
            return new zzjd();
        }
        zzhi zzhiVar = null;
        if (i8 == 4) {
            return new zzjc(zzhiVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
