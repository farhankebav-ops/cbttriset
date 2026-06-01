package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhxq implements zzhys {
    private static final zzhxx zzb = new zzhxo();
    private final zzhxx zza;

    public zzhxq() {
        zzhwh zzhwhVarZza = zzhwh.zza();
        int i2 = zzhuv.zza;
        zzhxp zzhxpVar = new zzhxp(zzhwhVarZza, zzb);
        byte[] bArr = zzhxb.zzb;
        this.zza = zzhxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhys
    public final zzhyr zza(Class cls) {
        int i2 = zzhyt.zza;
        if (!zzhwo.class.isAssignableFrom(cls)) {
            int i8 = zzhuv.zza;
        }
        zzhxw zzhxwVarZzc = this.zza.zzc(cls);
        if (zzhxwVarZzc.zza()) {
            int i9 = zzhuv.zza;
            return zzhyd.zzh(zzhyt.zzF(), zzhwb.zza(), zzhxwVarZzc.zzb());
        }
        int i10 = zzhuv.zza;
        return zzhyc.zzm(cls, zzhxwVarZzc, zzhyg.zza(), zzhxm.zza(), zzhyt.zzF(), zzhxwVarZzc.zzc() + (-1) != 1 ? zzhwb.zza() : null, zzhxv.zza());
    }
}
