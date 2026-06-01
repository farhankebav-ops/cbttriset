package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzbge {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    public zzbge(String str, Object obj, int i2) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i2;
    }

    public static zzbge zza(String str, boolean z2) {
        return new zzbge(str, Boolean.valueOf(z2), 1);
    }

    public static zzbge zzb(String str, long j) {
        return new zzbge(str, Long.valueOf(j), 2);
    }

    public static zzbge zzc(String str, double d8) {
        return new zzbge(str, Double.valueOf(d8), 3);
    }

    public static zzbge zzd(String str, String str2) {
        return new zzbge("gad:dynamite_module:experiment_id", "", 4);
    }

    public final Object zze() {
        zzbhk zzbhkVarZza = zzbhm.zza();
        if (zzbhkVarZza != null) {
            int i2 = this.zzc - 1;
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? zzbhkVarZza.zzd(this.zza, (String) this.zzb) : zzbhkVarZza.zzc(this.zza, ((Double) this.zzb).doubleValue()) : zzbhkVarZza.zzb(this.zza, ((Long) this.zzb).longValue()) : zzbhkVarZza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (zzbhm.zzb() != null) {
            zzbhm.zzb().zza();
        }
        return this.zzb;
    }
}
