package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzck extends zzeh implements zzfn {
    private static final zzck zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzck zzckVar = new zzck();
        zzb = zzckVar;
        zzeh.zzV(zzck.class, zzckVar);
    }

    private zzck() {
    }

    public static zzck zzb() {
        return zzb;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zzj;
    }

    public final String zzf() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i8 == 3) {
            return new zzck();
        }
        zzce zzceVar = null;
        if (i8 == 4) {
            return new zzcj(zzceVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzh() {
        return this.zzg;
    }

    public final String zzi() {
        return this.zzf;
    }

    public final String zzj() {
        return this.zzk;
    }
}
