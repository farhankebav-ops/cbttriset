package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhxp implements zzhxx {
    private final zzhxx[] zza;

    public zzhxp(zzhxx... zzhxxVarArr) {
        this.zza = zzhxxVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzhxx
    public final boolean zzb(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.zza[i2].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzhxx
    public final zzhxw zzc(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            zzhxx zzhxxVar = this.zza[i2];
            if (zzhxxVar.zzb(cls)) {
                return zzhxxVar.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
