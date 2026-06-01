package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzu extends zzeh implements zzfn {
    private static final zzu zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private zzjv zzg;
    private byte zzh = 2;

    static {
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzeh.zzV(zzu.class, zzuVar);
        zzeh.zzI(zzjv.zzf(), zzuVar, zzuVar, null, 13258261, zzhf.zzk, zzu.class);
    }

    private zzu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔅ\u0000\u0002ᔅ\u0001\u0003ᐉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i8 == 3) {
            return new zzu();
        }
        zzs zzsVar = null;
        if (i8 == 4) {
            return new zzt(zzsVar);
        }
        if (i8 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
