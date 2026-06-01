package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzj extends zzeh implements zzfn {
    private static final zzj zzb;
    private int zzd;
    private int zzg;
    private zzu zzh;
    private zzp zzi;
    private zzjv zzj;
    private int zzk;
    private byte zzm = 2;
    private int zze = 17;
    private zzeo zzf = zzeh.zzP();
    private zzeo zzl = zzeh.zzP();

    static {
        zzj zzjVar = new zzj();
        zzb = zzjVar;
        zzeh.zzV(zzj.class, zzjVar);
    }

    private zzj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\b\u0000\u0001\u0001\u000f\b\u0000\u0002\u0004\u0001᠌\u0000\u0003Л\u0004င\u0001\u0005ᐉ\u0002\u0006ᐉ\u0003\u0007င\u0005\b\u001b\u000fᐉ\u0004", new Object[]{"zzd", "zze", zzi.zza, "zzf", zzah.class, "zzg", "zzh", "zzi", "zzk", "zzl", zzak.class, "zzj"});
        }
        if (i8 == 3) {
            return new zzj();
        }
        zzg zzgVar = null;
        if (i8 == 4) {
            return new zzh(zzgVar);
        }
        if (i8 == 5) {
            return zzb;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
