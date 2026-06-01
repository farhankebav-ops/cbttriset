package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaa extends zzeh implements zzfn {
    private static final zzaa zzb;
    private int zzd;
    private zzad zze;
    private boolean zzf;

    static {
        zzaa zzaaVar = new zzaa();
        zzb = zzaaVar;
        zzeh.zzV(zzaa.class, zzaaVar);
    }

    private zzaa() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i8 == 3) {
            return new zzaa();
        }
        zzy zzyVar = null;
        if (i8 == 4) {
            return new zzz(zzyVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
