package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzhut implements zzhyh {
    static {
        int i2 = zzhvy.zzb;
        int i8 = zzhuv.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhyh
    public final /* synthetic */ Object zza(InputStream inputStream, zzhvy zzhvyVar) throws zzhxd {
        zzhzb zzhzbVarZzaU;
        zzhvn zzhvnVarZzF = zzhvn.zzF(inputStream, 4096);
        zzhxz zzhxzVar = (zzhxz) zzb(zzhvnVarZzF, zzhvyVar);
        zzhvnVarZzF.zzb(0);
        if (zzhxzVar == null || zzhxzVar.zzbi()) {
            return zzhxzVar;
        }
        if (zzhxzVar instanceof zzhur) {
            zzhzbVarZzaU = ((zzhur) zzhxzVar).zzaU();
        } else {
            if (zzhxzVar instanceof zzhus) {
                throw null;
            }
            zzhzbVarZzaU = new zzhzb(zzhxzVar);
        }
        throw zzhzbVarZzaU.zza();
    }
}
