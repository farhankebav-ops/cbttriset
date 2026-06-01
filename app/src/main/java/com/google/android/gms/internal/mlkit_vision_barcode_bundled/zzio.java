package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzio extends zzeh implements zzfn {
    private static final zzio zzb;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzg = true;
    private String zzl = "";
    private String zzm = "";

    static {
        zzio zzioVar = new zzio();
        zzb = zzioVar;
        zzeh.zzV(zzio.class, zzioVar);
    }

    private zzio() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            zzel zzelVar = zzip.zza;
            return zzeh.zzS(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zzd", "zze", "zzf", zziq.zza, "zzg", "zzh", zzim.zza, "zzi", zzelVar, "zzj", zzelVar, "zzk", zzelVar, "zzl", "zzm"});
        }
        if (i8 == 3) {
            return new zzio();
        }
        zzhi zzhiVar = null;
        if (i8 == 4) {
            return new zzin(zzhiVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
