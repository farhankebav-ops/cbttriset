package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzic extends zzeh implements zzfn {
    private static final zzic zzb;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        zzic zzicVar = new zzic();
        zzb = zzicVar;
        zzeh.zzV(zzic.class, zzicVar);
    }

    private zzic() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", zzid.zza, "zzf"});
        }
        if (i8 == 3) {
            return new zzic();
        }
        zzhi zzhiVar = null;
        if (i8 == 4) {
            return new zzib(zzhiVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
