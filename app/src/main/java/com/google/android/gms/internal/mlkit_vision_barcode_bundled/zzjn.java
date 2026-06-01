package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjn extends zzeh implements zzfn {
    private static final zzjn zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzjn zzjnVar = new zzjn();
        zzb = zzjnVar;
        zzeh.zzV(zzjn.class, zzjnVar);
    }

    private zzjn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i8 == 3) {
            return new zzjn();
        }
        zzhi zzhiVar = null;
        if (i8 == 4) {
            return new zzjm(zzhiVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
