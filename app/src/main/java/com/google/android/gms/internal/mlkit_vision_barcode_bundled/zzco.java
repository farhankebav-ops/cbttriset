package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzco extends zzeh implements zzfn {
    private static final zzco zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzco zzcoVar = new zzco();
        zzb = zzcoVar;
        zzeh.zzV(zzco.class, zzcoVar);
    }

    private zzco() {
    }

    public static zzco zzb() {
        return zzb;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final int zzd() {
        int iZza = zzcn.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzcm.zza, "zzf"});
        }
        if (i8 == 3) {
            return new zzco();
        }
        zzce zzceVar = null;
        if (i8 == 4) {
            return new zzcl(zzceVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
