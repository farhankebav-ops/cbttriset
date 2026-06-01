package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzht extends zzeh implements zzfn {
    private static final zzht zzb;
    private int zzd;
    private String zze = "";
    private int zzf = 1;
    private boolean zzg;
    private int zzh;

    static {
        zzht zzhtVar = new zzht();
        zzb = zzhtVar;
        zzeh.zzV(zzht.class, zzhtVar);
    }

    private zzht() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", zzhs.zza, "zzg", "zzh"});
        }
        if (i8 == 3) {
            return new zzht();
        }
        zzhi zzhiVar = null;
        if (i8 == 4) {
            return new zzhr(zzhiVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
