package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzp extends zzeh implements zzfn {
    private static final zzp zzb;
    private int zzd;
    private zzjv zzj;
    private byte zzk = 2;
    private zzen zze = zzeh.zzO();
    private zzem zzf = zzeh.zzM();
    private boolean zzg = true;
    private String zzh = "";
    private String zzi = "";

    static {
        zzp zzpVar = new zzp();
        zzb = zzpVar;
        zzeh.zzV(zzp.class, zzpVar);
    }

    private zzp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0006\u0000\u0001\u0001\u000f\u0006\u0000\u0002\u0001\u0001\u0016\u0002\u0013\u0003ဇ\u0000\u0004ဈ\u0001\u0005ဈ\u0002\u000fᐉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i8 == 3) {
            return new zzp();
        }
        zzn zznVar = null;
        if (i8 == 4) {
            return new zzo(zznVar);
        }
        if (i8 == 5) {
            return zzb;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
